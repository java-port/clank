FILE_NAME = optBool
DATA_TYPE = Boolean
PARSER = parserBoolean
EXTRA_OPT_IMPLEMENTS=implements org.clank.support.Native.Native$Bool
EXTRA_OPT_METHODS=\n\t@Override public boolean $bool() { return $DataType(); }\n
DEFAULT_VALUE = Boolean.FALSE
