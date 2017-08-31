PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplChar
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = byte
BOXED_TYPE = Byte
ARRAY_TYPE = byte
NEW_ZERO_ARRAY = new$char(0)
NEW_CAPACITY_ARRAY = new$char(capacity)
POINTER_TYPE = char$ptr
POINTER_FACTORY_MTD = create_char$ptr
REFERENCE_TYPE = char$ref
REFERENCE_FACTORY_MTD = create_char$ref
ITERATOR_TYPE = char$ptr
GENERIC_ITERATOR = char$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorChar
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DESTROY_IMPL = // No need to destroy primitive types
DEFAULT_VALUE = 0
SB_APPEND_ELEMENT_I=out.append(element == 0 ? "<EOF>" : (char)element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
FINAL_DESTROY=final
NATIVE_CONTAINER = NativeContainerChar
JAVA_ITERATOR = JavaIteratorChar
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=
EXTRA_APPEND_MEMBERS=\n\
\tpublic final void append(char$ptr a, int fromIndex, int count) {\n\
\t  assert checkAlive();\n\
\t  if (count > (this.capacity() - this.size()))\n\
\t    this.grow(this.size()+count);\n\
\t  while (count-- > 0) {\n\
\t    byte el = a.$at(fromIndex++);\n\
\t    $set(end, el);\n\
\t    ++end;\n\
\t  }\n\
\t}\n