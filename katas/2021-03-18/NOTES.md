# Notes

## Legend

- ⚠ TODO
- 🚧 IN PROGRESS
- ✅ DONE

## Plans

- boundaries
  - all numbers will be valid
  - at least one number will be present
  - numbers will be separated with a single space
- validation
  - no validation is required, the input will be valid (see boundaries)
- ✅ edge cases
  - ✅ single number -> return it as both max and min
- ✅ general cases (number `A` is greater than number `a`)
  - ✅ `"A a"` -> `"A a"`
  - ✅ `"a A"` -> `"A a"`
  - ✅ multiple numbers -> `"max min"`

## Techdebt
- repetitive code
- hard to read
