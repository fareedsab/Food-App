from flask import Flask
app = Flask(__name__)
@app.route("/getdata")
def get_mock_data():
    return {"data": [
        {
            "title":"Pizza",
            "pic":"https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_960_720.jpg"
        },
        {
            "title":"Burger",
            "pic":"https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_960_720.jpg"
        
        }

    ]}

if __name__ == "__main__":
    app.run(debug=True)    