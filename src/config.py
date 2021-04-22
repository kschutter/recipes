import os

readme = """# kschutter Culinary Recipes
- [Beef :cow2:](#beef)
- [Beverage :tropical_drink:](#beverage)
- [Pork :pig2:](#pork)
- [Poultry :chicken:](#poultry)
- [Seafood :fish:](#seafood)
- [Sides :bread:](#sides)
- [Treats :cake:](#treats)
- [Vegetable :herb:](#vegetable)
"""

for category in sorted(os.listdir('r')):
    if category == 'template.md': continue
    readme += f'\n## {category}'
    for recipe_file in sorted(os.listdir('r/' + category)):
        recipe_name = recipe_file[:-3].replace('_', ' ')
        readme += f'\n- [{recipe_name}](r/{category}/{recipe_file})'

with open('README.md', 'w') as f:
    f.write(readme)
f.close()