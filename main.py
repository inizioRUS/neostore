import logging
from config import *
from telegram import ForceReply, Update, InlineKeyboardButton, InlineKeyboardMarkup, KeyboardButton, \
    ReplyKeyboardMarkup, ReplyKeyboardRemove
from telegram.ext import Updater, CommandHandler, CallbackContext, MessageHandler, Filters, CallbackQueryHandler
import random
import requests
import json

# Enable logging
logging.basicConfig(
    format="%(asctime)s - %(name)s - %(levelname)s - %(message)s", level=logging.INFO
)
logger = logging.getLogger(__name__)

keyboard = [

    [
        KeyboardButton('/login'),
        KeyboardButton('/logout'),
    ],
    [
        KeyboardButton('/getinfo'),
        KeyboardButton('/gettasks'),
    ]
]
reply_markup = ReplyKeyboardMarkup(keyboard, resize_keyboard=True)


def start(update: Update, context: CallbackContext) -> None:
    if "islogin" not in context.chat_data:
        context.chat_data["islogin"] = False
    context.chat_data["CheckLogin"] = False
    user = update.effective_user
    update.message.reply_html(
        rf"""Привет {user.mention_html()}!
        Это бот для отслеживания твоих задач, пожалуйста авторизуйся""",
        reply_markup=reply_markup
    )


def login(update: Update, context: CallbackContext):
    if context.chat_data["islogin"]:
        update.message.reply_html(
            rf"""Вы уже авторизированы""",
        )
    else:
        context.chat_data["CheckLogin"] = True
        update.message.reply_html(
            rf"""Введите логин""",
        )


def logout(update: Update, context: CallbackContext):
    if not context.chat_data["islogin"]:
        update.message.reply_html(
            rf"""Пожалуйста авторизуйтесь""",
        )
    else:
        context.chat_data["islogin"] = False
        update.message.reply_html(
            rf"""Успешный выход""",
        )
    context.chat_data["CheckLogin"] = False


def getinfo(update: Update, context: CallbackContext):
    if not context.chat_data["islogin"]:
        update.message.reply_html(
            rf"""Пожалуйста авторизуйтесь""",
        )
    else:
        data = json.loads(
            requests.get(f"http://5.101.51.166:8080/workers/worker/id/{int(context.chat_data['id'])}").text)
        update.message.reply_html(
            rf"""Привет {data['surname']} {data['name']} {data['secondName']} ({data['login']}, ваш баланс -  {data['balance']})""",
        )
    context.chat_data["CheckLogin"] = False


def gettasks(update: Update, context: CallbackContext):
    if not context.chat_data["islogin"]:
        update.message.reply_html(
            rf"""Пожалуйста авторизуйтесь""",
        )
    else:
        taskac = None
        tasks = \
            json.loads(requests.get(f"http://5.101.51.166:8080/tasks").text)
        for task in tasks:
            if task['workerId'] == context.chat_data['id']:
                taskac = task
        if taskac is None:
            update.message.reply_html(
                rf"""Задачи нет""",
            )
        else:
            print(taskac)
            update.message.reply_html(
                f"""Название задачи {taskac['name']}, \n Описание задачи  {taskac['description']} \n Сложность {taskac['difficulty']}"""
            )
    context.chat_data["CheckLogin"] = False


def checkText(update: Update, context: CallbackContext):
    if context.chat_data["CheckLogin"]:
        ans = requests.get(f"http://5.101.51.166:8080/workers/worker?login={update.message.text}")
        print(ans)
        if 'id' in json.loads(ans.text):
            context.chat_data['id'] = json.loads(ans.text)['id']
            context.chat_data["islogin"] = True
            update.message.reply_html(
                rf"""Вы авторизированны""",
            )
        else:
            update.message.reply_html(
                rf"""Неверный логин""",
            )
            context.chat_data["CheckLogin"] = False
    else:
        pass


def help_command(update: Update, context: CallbackContext):
    update.message.reply_html(
        rf"""
/login - вход
/logout - выход
/getinfo - информация о человеке
/gettasks - информация о задаче""",
    )


def main() -> None:
    application = Updater(TOKEN)
    application.dispatcher.add_handler(CommandHandler("start", start))
    application.dispatcher.add_handler(CommandHandler("help", help_command))
    application.dispatcher.add_handler(CommandHandler("login", login))
    application.dispatcher.add_handler(CommandHandler("logout", logout))
    application.dispatcher.add_handler(CommandHandler("getinfo", getinfo))
    application.dispatcher.add_handler(CommandHandler("gettasks", gettasks))
    application.dispatcher.add_handler(MessageHandler(Filters.text, checkText))
    application.start_polling()
    application.idle()


if __name__ == "__main__":
    main()
