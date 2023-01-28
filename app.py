import os
from flask import Flask, request, render_template
from flask_wtf import FlaskForm as Form
from wtforms import SelectField, validators
from markdown import markdown
from src.config import get_recipes

app = Flask(__name__)
app.config["SECRET_KEY"] = "YOUR SECRET KEY"

@app.route("/")

def index():
    _, recipes = get_recipes()

    class ReusableForm(Form):
        name = SelectField(
            "Enter a Name",
            choices=[("", "")]
            + [
                name for name in recipes
            ],  # [("", "")] is needed for a placeholder
            validators=[validators.InputRequired()],
        )

    readme = open("README.md", "r")
    
    # return render_template(markdown(readme.read()), recipes=recipes)
    return render_template("index.html", recipes=recipes, form=Form)
