FILE_NAME = SmallVectorToken
CLASS_SPECIFIER = final
CONSTRUCTOR_VISIBILITY = public
INNER_METHOD_VISIBILITY = /*friend*/
CLASS_SUFFIX = 
TYPE = Token
ARRAY_TYPE = Token
POINTER_TYPE = type$ptr<Token>
POINTER_FACTORY_MTD = create_type$ptr
REFERENCE_TYPE = type$ref<Token>
REFERENCE_FACTORY_MTD = create_type$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = type$iterator<iterator, Token>
GENERIC_ITERATOR = type$iterator<?, Token>
REV_ITERATOR_TYPE = std.reverse_iterator<Token>
SET_IMPL = if (defaultValue == null) { array[(int) idx] = value; } else { if (array[(int) idx] == null) { array[(int) idx] = value.clone(); } else { array[(int) idx].$assign(value); } } return value;
REF_SET_IMPL = if (stored instanceof assignable) { ((assignable<Token>) stored).$assign(value); } else { array[index] = $tryClone(value); } return value;
DESTROY_RANGE_IMPL = // for (/*uint*/int i = from; i < to; i++) { Native.destroy(array[(int) i]); }
DEFAULT_VALUE = null
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
