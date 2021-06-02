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
- [Slow Cooker :sweat_drops:](#slowpressure-cooker-recipes)
"""
emojis = {"Beef":":cow2:"}  # Slow cooker category emojis
slow_cooker = []

for category in sorted(os.listdir('r')):
    if category == 'template.md': continue
    readme += f'\n## {category}'
    for recipe_file in sorted(os.listdir('r/' + category)):
        link = f"r/{category}/{recipe_file}"
        recipe_name = recipe_file[:-3].replace('_', ' ')
        if (recipe_name[:11] == "Slow-Cooker"): 
            slow_cooker.append({"title": f"{recipe_name} ({emojis[category]})", "link":link})
        readme += f'\n- [{recipe_name}]({link})'
readme += "\n## Slow/Pressure Cooker recipes:"
for recipe in slow_cooker:
    readme += f"\n- [{recipe['title']}]({recipe['link']})"

with open('README.md', 'w') as f:
    f.write(readme)
f.close()