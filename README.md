The mod modifies mechanism of armor and armor toughness, and only consumes one durability per injured.

## Calculation formula for damage:

`equivalentArmor` = `armor` * (`toughness` / `baseToughness` + 1)

`sufferDamage` = `damage` * `baseArmor` / (`equivalentArmor` + `baseArmor`)

The default value for `baseArmor` and `baseToughness` is 10.

## Configuration file:

```toml
#The armor value of equivalent to twice health
#The Larger the value,the weaker the defense
# Default: 10
# Range: 1 ~ 32768
baseArmor = 10
#The toughness value of equivalent to twice armor
#The Larger the value,the weaker the defense
# Default: 10
# Range: 1 ~ 32768
baseToughness = 10
#Only consume one durability
isOnlyConsumeOneDurability = true
```
