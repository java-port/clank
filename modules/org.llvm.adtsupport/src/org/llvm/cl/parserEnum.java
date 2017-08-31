/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.llvm.cl;

import org.clank.support.Converted;
import org.clank.java.*;
import static org.clank.java.std.strcmp;
import org.clank.support.Native;
import org.clank.support.Native.NativeIntEnum;
import org.clank.support.Native.NativeUIntEnum;
import org.clank.support.NativeCallback;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.cl.parser.OptionInfo;
import org.llvm.support.impl.CommandLineStatics;
import static org.llvm.support.impl.CommandLineStatics.*;

/**
 * @author vkvashin
 */
//--------------------------------------------------
// parser<int>
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::parser">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 797,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser")
//</editor-fold>
public class parserEnum</*class*/ EnumDataType extends java.lang.Enum<EnumDataType>> extends /*public*/ basic_parser<EnumDataType> {
/*public:*/
  // parse - Return true on error.

  // parser<int> implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<int>::parse">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1174,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<int>::parse")
  //</editor-fold>
  @Override
  public boolean parse(Option /*&*/ O, StringRef ArgName,
       StringRef Arg, type$ref<EnumDataType>/*int &*/ Value) {
    EnumDataType $deref = Value.$deref();
    assert $deref != null;
    int intValue = getIntValue($deref);
    int$ref tmp = create_int$ref(intValue);
    if (Arg.getAsInteger(0, tmp)) {
      Value.$set(getEnumValue(tmp.$deref()));
      return O.error($add_Twine($add_T_StringRef("'", Arg), new Twine("' value invalid for enum argument!")));
    }
    Value.$set(getEnumValue(tmp.$deref()));
    return false;
  }

  // getValueName - Overload in subclass to provide a better default value.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<int>::getValueName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 804,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<int>::getValueName")
  //</editor-fold>
  @Override public /*virtual*/ /*const*/char$ptr/*char P*/ getValueName() /*const*/ {
    return $("enum");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<int>::printOptionDiff">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1343,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<int>::printOptionDiff")
  //</editor-fold>
  public void printOptionDiff(/*const*/ Option /*&*/ O, int V, OptionValue<EnumDataType> D, /*size_t*/int GlobalWidth) /*const*/ {
    std.string Str = null;
    try {
      printOptionName(O, GlobalWidth);
      Str/*J*/= new std.string();
      {
        raw_string_ostream SS = null;
        try {
          SS/*J*/= new raw_string_ostream(Str);
          SS.$out_int(V);
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
      }
      outs().$out("= ").$out(Str);
      /*size_t*/int NumSpaces = MaxOptWidth > Str.size() ? MaxOptWidth - Str.size() : 0;
      outs().indent(NumSpaces).$out(" (default: ");
      if (D.hasValue()) {
        outs().$out_int(getIntValue(D.getValue()));
      } else {
        outs().$out("*no default*");
      }
      outs().$out(")\n");
    } finally {
      if (Str != null) { Str.$destroy(); }
    }
  }


  // An out-of-line virtual method to provide a 'home' for this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<int>::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 71,
   FQN = "llvm::cl::Option::anchor", NM = "_ZN4llvm2cl6Option6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option6anchorEv")
  //</editor-fold>
  @Override public void anchor() {
  }
  
  /// addLiteralOption - Add an entry to the mapping table.
  ///
  /*template <class DT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::addLiteralOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 759,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 695,
   FQN="llvm::cl::parser::addLiteralOption", NM="Tpl__ZN4llvm2cl6parser16addLiteralOptionEPKcRKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl6parser16addLiteralOptionEPKcRKT_S3_")
  //</editor-fold>
  @Override public void addLiteralOption(Option Owner, char$ptr Name, /*EnumDataType*/Object V, char$ptr HelpStr) {
    assert Native.$bool(Native.$eq(findOption(Name), Values.size())) : "Option already exists!";
    OptionInfo X/*J*/= /*ParenList*/new OptionInfo(Name, ((/*static_cast*/EnumDataType)getEnumValue((Integer)V)), HelpStr);
    Values.push_back(X);
    if (CommandLineStatics.USE_NEW_CL_PARSER) {
      // if we uncomment this lines, then GlobalParser initialized and old code 
      // will cause issues in tests    
      ClGlobals.AddLiteralOption(Owner, Name);
    }
  }

  private EnumDataType getEnumValue(int arg) {
    return int2enum.$call(arg);
  }
  
  private int getIntValue(EnumDataType arg) {
    int out = 0;
    if (arg instanceof NativeUIntEnum) {
      out = ((NativeUIntEnum) arg).getValue();
    } else if (arg instanceof NativeIntEnum) {
      out = ((NativeIntEnum) arg).getValue();
    } else {
      assert false : "unhandled [" + arg.getClass() + "] " + arg;
    }
    return out;
  }

  private final NativeCallback.Int2Type<EnumDataType> int2enum;
  public parserEnum(NativeCallback.Int2Type<EnumDataType> int2enum) {
    this.int2enum = int2enum;
    this.Values = new SmallVector<parser.OptionInfo<EnumDataType>>(8, null/*?*/);
  }  
  
  //////////////////////////////////////////////////////////////////////////////
  // it's better to derived from parser, but let's first make it workable in old infra
  
  protected SmallVector<parser.OptionInfo<EnumDataType>> Values;

    // Implement virtual functions needed by generic_parser_base
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::getNumOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 728,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 665,
   FQN="llvm::cl::parser::getNumOptions", NM="_ZNK4llvm2cl6parser13getNumOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6parser13getNumOptionsEv")
  //</editor-fold>
  /*@Override*/ public /*uint*/int getNumOptions() /*const*//* override*/ {
    return Values.size();//new /*uint*/int(Values.size());
  }
  

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser::getOption">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 729,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 666,
   FQN="llvm::cl::parser::getOption", NM="_ZNK4llvm2cl6parser9getOptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6parser9getOptionEj")
  //</editor-fold>
  /*@Override */public /*const*/char$ptr/*char P*/ getOption(/*uint*/int N) /*const*//* override*/ {
    return Values.$at(N).Name;
  }  
  
  // findOption - Return the option number corresponding to the specified
  // argument string.  If the option is not found, getNumOptions() is returned.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::findOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1532,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1305,
   FQN="llvm::cl::generic_parser_base::findOption", NM="_ZN4llvm2cl19generic_parser_base10findOptionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_base10findOptionEPKc")
  //</editor-fold>
  public /*uint*/int findOption(/*const*/char$ptr/*char P*/ Name) {
    /*uint*/int e = getNumOptions();
    
    for (/*uint*/int i = 0; i != e; ++i) {
      if (strcmp(getOption(i), Name) == 0) {
        return i;
      }
    }
    return e;
  }  
}