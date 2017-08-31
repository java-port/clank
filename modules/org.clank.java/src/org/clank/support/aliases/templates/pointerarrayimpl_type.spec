FILE_NAME = type$ptr$array
CLASS_SUFFIX = <T>
POINTER_NAME = type$ptr<T>
REFERENCE_NAME = type$ref<T>
TYPE = T
SB_APPEND_ELEMENT_I=sb.append((i == this.index) ? "*[" : " [").append(String.format(fmt, i)).append("]");\n\t\t\t\tsb.append(b).append(NEW_LINE)
SET_IMPL=if(true) return array[(int)(this.index + index)] = value;\n\
\t\t\tint idx = (int) (this.index + index);\n\
\t\t\tT ourVal = array[idx];\n\
\t\t\tif (ourVal == null || value == null) {\n\
\t\t\t\tarray[idx] = (value instanceof org.clank.support.NativeCloneable ? ((org.clank.support.NativeCloneable<T>) value).clone() : value);\n\
\t\t\t} else if (ourVal instanceof org.clank.support.Native.assignable && ourVal.getClass() == value.getClass()) {\n\
\t\t\t\t((org.clank.support.Native.assignable<T>) ourVal).$assign(value);\n\
\t\t\t} else {\n\
\t\t\t\tarray[idx] = (value instanceof org.clank.support.NativeCloneable ? ((org.clank.support.NativeCloneable<T>) value).clone() : value);\n\
\t\t\t}\n\
\t\t\treturn value;
ADDITIONAL_ASSIGNMENTS=
ADDITIONAL_MODIFY_VALUE_SECTION_START = /*
ADDITIONAL_MODIFY_VALUE_SECTION_END = */
BUILTIN_TYPE_MODIFY_VALUE_SECTION_START= /*
BUILTIN_TYPE_MODIFY_VALUE_SECTION_END= */
