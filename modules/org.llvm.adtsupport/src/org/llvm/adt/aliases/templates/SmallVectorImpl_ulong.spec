PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImplULong
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX =
TYPE = long
BOXED_TYPE = Long
ARRAY_TYPE = long
NEW_ZERO_ARRAY = new$ulong(0)
NEW_CAPACITY_ARRAY = new$ulong(capacity)
POINTER_TYPE = ulong$ptr
POINTER_FACTORY_MTD = create_ulong$ptr
REFERENCE_TYPE = ulong$ref
REFERENCE_FACTORY_MTD = create_ulong$ref
ITERATOR_TYPE = ulong$ptr
GENERIC_ITERATOR = ulong$iterator<?>
REV_ITERATOR_TYPE = std.reverse_iteratorULong
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DESTROY_IMPL = // No need to destroy primitive types
DEFAULT_VALUE = 0L
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
FINAL_DESTROY=final
NATIVE_CONTAINER = NativeContainerULong
JAVA_ITERATOR = JavaIteratorULong
COMMA_SMALL_VECTOR_IMPL_COMMON = 
STD_COPY_TRAILING_ARG=
ADDITIONAL_APPEND_INSERT = \n\
\tpublic final void append_T(uint$iterator<?> in_start, uint$iterator<?> in_end) {\n\
\t  append_T(CollectionUtils.transform_uint2ulong$ptr(in_start), CollectionUtils.transform_uint2ulong$ptr(in_end));\n\
\t}\n\
\n\
\tpublic final void append_T(char$iterator<?> in_start, char$iterator<?> in_end) {\n\
\t  append_T(CollectionUtils.transform_char2ulong$ptr(in_start), CollectionUtils.transform_char2ulong$ptr(in_end));\n\
\t}\n\
\n\
\tpublic void insert_iterator$T_T(ulong$ptr I, char$iterator<?> From, char$iterator<?> To) {\n\
\t  insert_iterator$T$value_T(I, CollectionUtils.transform_char2ulong$ptr(From), CollectionUtils.transform_char2ulong$ptr(To));\n\
\t}\n\
