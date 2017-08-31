FILE_NAME = SmallVector
CLASS_SUFFIX = <T>
SMALL_VECTOR_IMPL = SmallVectorImpl<T>
TYPE = T
ITERATOR_TYPE = type$iterator<?, ? extends T>
BASE_ITERATOR_TYPE = type$iterator<?, T>
DEFAULT_VALUE = null
CUNSTRUCTOR_WITH_CONVERTER=\n\
\tpublic <U> SmallVector(JD$T _dparam, int capacity, type$iterator<?, ? extends U> begin, type$iterator<?, ? extends U> end, T defaultValue, NativeCallback.Converter<U,T> conv) {\n\
\t  super(capacity, new convert_iterator(begin, conv), new convert_iterator(end, conv), defaultValue);\n\
\t}\n\
