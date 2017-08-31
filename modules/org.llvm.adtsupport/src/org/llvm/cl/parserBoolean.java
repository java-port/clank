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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.CommandLineStatics.*;

/**
 * @author vkvashin
 */
//--------------------------------------------------
// parser<bool>
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::parser">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 741,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser",
 notes = Converted.Notes.FAILED)
//</editor-fold>
public class parserBoolean extends /*public*/ basic_parser<Boolean> {
  private /*const*/char$ptr/*char P*/ ArgStr;
/*public:*/

  // parse - Return true on error.

  // parser<bool> implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::parse">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1138,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<boolean>::parse")
  //</editor-fold>
  @Override
  public boolean parse(Option /*&*/ O, StringRef ArgName,
       StringRef Arg, type$ref<Boolean>/*bool &*/ Value) {
    if ($eq_StringRef(Arg, "") || $eq_StringRef(Arg, "true") || $eq_StringRef(Arg, "TRUE") || $eq_StringRef(Arg, "True")
       || $eq_StringRef(Arg, "1")) {
      Value.$set(true);
      return false;
    }
    if ($eq_StringRef(Arg, "false") || $eq_StringRef(Arg, "FALSE") || $eq_StringRef(Arg, "False") || $eq_StringRef(Arg, "0")) {
      Value.$set(false);
      return false;
    }
    return O.error($add_Twine($add_T_StringRef("'", Arg),
            new Twine("' is invalid value for boolean argument! Try 0 or 1")));
  }


  /*template <class Opt> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::initialize">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 750,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<boolean>::initialize")
  //</editor-fold>
  public void initialize(Option /*&*/ O) {
    ArgStr = $tryConstClone(O.ArgStr.data());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::getValueExpectedFlagDefault">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 754,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<boolean>::getValueExpectedFlagDefault")
  //</editor-fold>
  public  ValueExpected getValueExpectedFlagDefault() /*const*/ {
    return ValueExpected.ValueOptional;
  }


  // getValueName - Do not print =<value> at all.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::getValueName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 759,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<boolean>::getValueName",
   notes = Converted.Notes.FIXME)
  //</editor-fold>
  @Override public /*virtual*/ /*const*/char$ptr/*char P*/ getValueName() /*const*/ {
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::printOptionDiff">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1341,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<boolean>::printOptionDiff")
  //</editor-fold>
  public void printOptionDiff(/*const*/ Option /*&*/ O, boolean V, OptionValue<Boolean> D, /*size_t*/int GlobalWidth) /*const*/ {
    std.string Str = null;
    try {
      printOptionName(O, GlobalWidth);
      Str/*J*/= new std.string();
      {
        raw_string_ostream SS = null;
        try {
          SS/*J*/= new raw_string_ostream(Str);
          SS.$out_int((V ? 1 : 0));
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
      }
      outs().$out("= ").$out(Str);
      /*size_t*/int NumSpaces = MaxOptWidth > Str.size() ? MaxOptWidth - Str.size() : 0;
      outs().indent(NumSpaces).$out(" (default: ");
      if (D.hasValue()) {
        outs().$out_int((D.getValue() ? 1 : 0));
      } else {
        outs().$out("*no default*");
      }
      outs().$out(")\n");
    } finally {
      if (Str != null) { Str.$destroy(); }
    }
  }


  // An out-of-line virtual method to provide a 'home' for this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 69,
   FQN = "llvm::cl::OptionValue<llvm::cl::boolOrDefault>::anchor", NM = "_ZN4llvm2cl11OptionValueINS0_13boolOrDefaultEE6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl11OptionValueINS0_13boolOrDefaultEE6anchorEv")
  //</editor-fold>
  @Override public void anchor() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::parser">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 742,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<boolean>::parser")
  //</editor-fold>
  public /*inline*/ parserBoolean()/* throw()*/ {
    /* : basic_parser<bool>()*/
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<boolean>::parser">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 742,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<boolean>::parser")
  //</editor-fold>
  public /*inline*/ parserBoolean(/*const*/ parserBoolean /*&*/ $Prm0)/* throw()*/ {
    /* : basic_parser<bool>(), ArgStr(.ArgStr)*/
    //START JInit
    super($Prm0);
    this.ArgStr = $tryClone($Prm0.ArgStr);
    //END JInit
  }

}