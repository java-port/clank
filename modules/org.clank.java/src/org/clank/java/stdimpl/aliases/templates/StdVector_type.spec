FILE_NAME = StdVector
CLASS_SUFFIX = <T>
MAIN_CLASS = std.vector<T>
TYPE = T
BOXED_TYPE = T
ARRAY_TYPE = Object
NEW_ZERO_ARRAY = new Object[0]
COPY_OF_ARRAY = copyOf$Object
POINTER_TYPE = type$ptr<T>
POINTER_FACTORY_MTD = create_type$ptr
REFERENCE_TYPE = type$ref<T>
REFERENCE_FACTORY_MTD = create_type$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator<T>
ITERATOR_INTERFACE = type$iterator<iterator<T>, T>
GENERIC_ITERATOR = type$iterator<?, T>
JAVA_ITERATOR = JavaIterator
NATIVE_CONTAINER = NativeContainer<T>
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
DEFAULT_VALUE = null
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return defaultValue == null;
ASSERT_DEFAULT_VALUE=NativeTrace.assertDefaultValue(defaultValue)
SUPPLIER = java.util.function.Supplier<T>
RESIZE_WITH_SUPPLIER = public void resize(int newSize, java.util.function.Supplier<T> defaultValue) {\
    if (newSize < end) {\
      destroy_range(newSize, end);\
    } else if (newSize > end) {\
      if (this.capacity() < newSize)\
        this.grow(newSize);\
      for (int i = end; i < newSize; i++) {\
        assert NativeTrace.assertArrayHasMutableContent(array, this);\
        array[i] = $getDefaultVal();\
      }\
    }\
    this.setEnd(newSize);\
  }

DEFVAL_WITH_SUPPLIER = if (defaultValue != null) {\
      final T res = defaultValue.get();\
      assert res != null : "If stored type is pointer then pass null as a supplier! Nonnull supplier must provide nonull values.";\
      return res;\
    }\
    return null
USE_OF_SUPPLIER = (Supplier == null) ? null : Supplier.get()
ELEMENT_BOOL_PREDICATE=NativeCallback.BoolPredicate<T>
INSERT_WITH_CONVERSION=\n\
  public final <U> iterator insert$T(iterator I, type$iterator<?, U> From, type$iterator<?, U> To, NativeCallback.Converter<U,T> convertor) {\n\
    throw new UnsupportedOperationException();\n\
  }

