import os

readme = """# kschutter Culinary Recipes
- [Beef :cow2:](#beef)
- [Beverage :tropical_drink:](#beverage)
- [Breakfast :egg:](#breakfast)
- [Pork :pig2:](#pork)
- [Poultry :chicken:](#poultry)
- [Seafood :fish:](#seafood)
- [Sides :bread:](#sides)
- [Treats :cake:](#treats)
- [Vegetable :herb:](#vegetable)
- [Slow Cooker :sweat_drops:](#Slow/Pressure Cooker recipes:)
"""
slow_cooker = [{"title": "Chili Mac (:cow2:)", "link": "r/beef/Chili_Mac.md"}]

for category in sorted(os.listdir('r')):
    if category == 'template.md': continue
    readme += f'\n## {category}'
    for recipe_file in sorted(os.listdir('r/' + category)):
        recipe_name = recipe_file[:-3].replace('_', ' ')
        readme += f'\n- [{recipe_name}](r/{category}/{recipe_file})'
readme += "\n## Slow/Pressure Cooker recipes:"
for recipe in slow_cooker:
    readme += f"\n- [{recipe['title']}]({recipe['link']})"

with open('README.md', 'w') as f:
    f.write(readme)
f.close()