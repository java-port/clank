FILE_NAME = optChar
DATA_TYPE = Byte
PARSER = parserChar
EXTRA_OPT_IMPLEMENTS=
EXTRA_OPT_METHODS=\n\tpublic /*char*/byte $char() { return $DataType(); }\n
DEFAULT_VALUE = Byte.valueOf((/*char*/byte)0)
