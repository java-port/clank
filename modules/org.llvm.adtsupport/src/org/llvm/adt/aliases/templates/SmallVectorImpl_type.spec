PACKAGE = org.llvm.adt.aliases
IMPORT = 
FILE_NAME = SmallVectorImpl
CLASS_SPECIFIER = abstract
CONSTRUCTOR_VISIBILITY = protected
INNER_METHOD_VISIBILITY = public
CLASS_SUFFIX = <T>
TYPE = T
BOXED_TYPE = T
ARRAY_TYPE = Object
NEW_ZERO_ARRAY = new Object[0]
NEW_CAPACITY_ARRAY = new Object[(int)capacity]
POINTER_TYPE = type$ptr<T>
POINTER_FACTORY_MTD = create_type$ptr
REFERENCE_TYPE = type$ref<T>
REFERENCE_FACTORY_MTD = create_type$ref
ITERATOR_TYPE = type$ptr<T>
GENERIC_ITERATOR = type$iterator<?, ? extends T>
REV_ITERATOR_TYPE = std.reverse_iterator<T>
SET_IMPL = if (defaultValue == null) {array[(int) idx] = value; } else {array[(int) idx] = $tryAssign(array[(int) idx], value, isDataPointerLike()); } return array[(int) idx];
SET_MOVE_IMPL = if (defaultValue == null) {array[(int) idx] = value; } else {array[(int) idx] = $tryMove(array[(int) idx], value, isDataPointerLike()); } return array[(int) idx];
REF_SET_IMPL = if (defaultValue == null) {array[index] = value; } else {array[index] = $tryAssign(array[index], value, isDataPointerLike()); } return array[index];
DESTROY_RANGE_IMPL = \
    for (/*uint*/int i = from; i < to; i++) {\n\
\t\t\tif (defaultValue != null) { \n\
\t\t\t\tNative.destroy(array[(int) i]);\n\
\t\t\t}\n\
\t\t\tarray[(int) i] = null;\n\
\t\t}
DESTROY_IMPL = // PODs and Ptrs must not be destroyed, see SmallVectorTemplateBase<T, true> specialization\n\
\t\t// otherwise data() pointer kept in ArrayRefs created from SmallVector will be corrupted\n\
\t\t// see clang::Sema::EvaluateImplicitExceptionSpec how temp ImplicitExceptionSpecification is destroyed by cleaner\n\
\t\tif (defaultValue instanceof Destructors.ClassWithDestructor) {\n\
\t\t  destroy_range(0, this.size());\n\
\t\t}
DEFAULT_VALUE = null
SB_APPEND_ELEMENT_I=out.append(isDataPointerLike() ? NativeTrace.getIdentityStr(element) : "" + element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return defaultValue == null;
ASSERT_DEFAULT_VALUE=NativeTrace.assertDefaultValue(defaultValue)
FINAL_DESTROY=/*final*/
NATIVE_CONTAINER = NativeContainer<T>
JAVA_ITERATOR = JavaIterator
COMMA_SMALL_VECTOR_IMPL_COMMON = , SmallVectorImplCommon<T>
STD_COPY_TRAILING_ARG=, isDataPointerLike()
