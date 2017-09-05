from flask import Flask, request, redirect, url_for, jsonify
from flask_cors import CORS
from pymongo import MongoClient
from bson.json_util import dumps

app = Flask(__name__)
CORS(app)
###### Database configuration ####
client = MongoClient()
db     = client.MyAppDB

@app.route('/')
def welcome():
    return 'welcome to my flask application.'

@app.route('/saveCustomer', methods=['POST'])
def saveCustomer():
    db.customers.insert_one({
        'company': request.form.get('company'),
        'username': request.form.get('username'),
        'email':  request.form.get('email'),
        'firstname': request.form.get('firstname'),
        'lastname': request.form.get('lastname'),
        'country': request.form.get('country'),
        'aboutme': request.form.get('aboutme')
    })

    return redirect('http://localhost:3000/')

@app.route('/getCustomers')
def getCustomers():
    return dumps(db.customers.find())

if __name__ == "__main__":
    app.run(debug=True)