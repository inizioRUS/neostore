from flask import Flask
import requests
import json
from sklearn.metrics.pairwise import cosine_similarity
import catboost
import numpy as np

app = Flask(__name__)


def sklearn_cosine(x, y):
    return 1 - cosine_similarity(x, y)


@app.route('/goodssrec/<id>')
def getrecgoods(id):
    li = []
    goods_add = []
    workers = json.loads(requests.get("http://5.101.51.166:8080/workers").text)
    all_goods = json.loads(requests.get("http://5.101.51.166:8080/goods/getAllGoods").text)
    this_workers = json.loads(requests.get(f"http://5.101.51.166:8080/workers/worker/id/{int(id)}").text)
    print(this_workers)
    for i in workers:
        row = []
        print(i)
        for j in all_goods:
            print(j)
            if j in i['goods']:
                row.append(1)
            else:
                row.append(0)
        goods_add.append(row)
    for peroson in workers:
        if peroson['id'] != id:
            li.append((sklearn_cosine(np.array(peroson[0], ), np.array(peroson[1]))))
    li = sorted(li, key=lambda x: -x)


@app.route('/tasksrec/<id>')
def gettaskrec(id):
    li = []
    tasks = json.loads(requests.get("http://5.101.51.166:8080/task").text)
    this_workers = json.loads(requests.get(f"http://5.101.51.166:8080/workers/{id}").text)
    for task in tasks:
        from_file = catboost.CatBoostRegressor(this_workers, task)
        from_file.load_model("model")
        li.append(from_file.predict([this_workers, task]))
        li = sorted(li, key=lambda x: -x)
    return li[0]


if __name__ == '__main__':
    app.run()
