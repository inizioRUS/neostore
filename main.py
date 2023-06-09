import logging
from config import *
from telegram import ForceReply, Update, InlineKeyboardButton, InlineKeyboardMarkup, KeyboardButton, \
    ReplyKeyboardMarkup, ReplyKeyboardRemove
from telegram.ext import Updater, CommandHandler, CallbackContext, MessageHandler, Filters, CallbackQueryHandler
import random

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
    if not context.chat_data["islogin"]:
        context.chat_data["islogin"] = False
    context.chat_data["CheckLogin"] = False
    user = update.effective_user
    update.message.reply_html(
        rf"""Привет {user.mention_html()}!
        Это бот для отслеживания своих задач, пожалйста авторизуйся""",
        reply_markup=reply_markup
    )


def login(update: Update, context: CallbackContext):
    if context.chat_data["islogin"]:
        update.message.reply_html(
            rf"""Вы уже авторизываны""",
        )
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


def getinfo(update: Update, context: CallbackContext):
    if context.chat_data["islogin"]:
        update.message.reply_html(
            rf"""Пожалуйста авторизуйтесь""",
        )
    else:
        pass


def gettasks(update: Update, context: CallbackContext):
    if context.chat_data["islogin"]:
        update.message.reply_html(
            rf"""Пожалуйста авторизуйтесь""",
        )
    else:
        pass


def checkText(update: Update, context: CallbackContext):
    if context.chat_data["CheckLogin"]:
        if update.message.text:
            # запрос update.message.text
            user = "fafaf"
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
/login
/logout
/getinfo
/gettasks""",
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
