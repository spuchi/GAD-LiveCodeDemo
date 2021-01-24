from flask import Flask
from .data import *
import json

app = Flask(__name__)

@app.route("/task")
def demo_call():
    return json.dumps(sample_todo)

@app.route("/tasks")
def get_all_todos():
    return json.dumps(todo_store)

@app.route("/check")
def healthcheck():
    return "Server is running!"