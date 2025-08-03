The mod modifies mechanism of armor and armor toughness, and only consumes one durability per injured.

### Calculation formula for damage:

equivalentArmor = armor * (toughness / baseToughness + 1)

sufferDamage = damage * baseArmor / (equivalentArmor + baseArmor)

The default value for baseArmor and baseToughness is 10.

### Configuration file:
