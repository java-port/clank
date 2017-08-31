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
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.CommandLineStatics.*;

/**
 *
 * @author vkvashin
 */
//--------------------------------------------------
// parser<boolOrDefault>
//<editor-fold defaultstate="collapsed" desc="llvm::cl::parser">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 772,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser")
//</editor-fold>
public class parserBoolOrDefault extends /*public*/ basic_parser<boolOrDefault> {
/*public:*/
  // parse - Return true on error.

  // parser<boolOrDefault> implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<llvm::cl::boolOrDefault>::parse">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1156,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<llvm::cl::boolOrDefault>::parse")
  //</editor-fold>
  @Override
  public boolean parse(Option /*&*/ O, StringRef ArgName,
       StringRef Arg, type$ref<boolOrDefault> /*&*/ Value) {
    if ($eq_StringRef(Arg, "") || $eq_StringRef(Arg, "true") || $eq_StringRef(Arg, "TRUE") || $eq_StringRef(Arg, "True")
       || $eq_StringRef(Arg, "1")) {
      Value.$set(boolOrDefault.BOU_TRUE);
      return false;
    }
    if ($eq_StringRef(Arg, "false") || $eq_StringRef(Arg, "FALSE") || $eq_StringRef(Arg, "False") || $eq_StringRef(Arg, "0")) {
      Value.$set(boolOrDefault.BOU_FALSE);
      return false;
    }

    return O.error($add_Twine($add_T_StringRef("'", Arg),
            new Twine("' is invalid value for boolean argument! Try 0 or 1")));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<llvm::cl::boolOrDefault>::getValueExpectedFlagDefault">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 778,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<llvm::cl::boolOrDefault>::getValueExpectedFlagDefault",
   notes = Converted.Notes.FAILED)
  //</editor-fold>
  public  ValueExpected getValueExpectedFlagDefault() /*const*/ {
    return ValueExpected.ValueOptional;
  }


  // getValueName - Do not print =<value> at all.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<llvm::cl::boolOrDefault>::getValueName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 783,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<llvm::cl::boolOrDefault>::getValueName",
   notes = Converted.Notes.FIXME)
  //</editor-fold>
  @Override public /*virtual*/ /*const*/char$ptr/*char P*/ getValueName() /*const*/ {
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<llvm::cl::boolOrDefault>::printOptionDiff">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1342,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser<llvm::cl::boolOrDefault>::printOptionDiff",
   notes = Converted.Notes.FAILED)
  //</editor-fold>
  public void printOptionDiff(/*const*/ Option /*&*/ O, boolOrDefault V, OptionValue<boolOrDefault> D, /*size_t*/int GlobalWidth) /*const*/ {
    std.string Str = null;
    try {
      printOptionName(O, GlobalWidth);
      Str/*J*/= new std.string();
      {
        raw_string_ostream SS = null;
        try {
          SS/*J*/= new raw_string_ostream(Str);
          SS.$out_int(V.getValue());
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
      }
      outs().$out("= ").$out(Str);
      /*size_t*/int NumSpaces = MaxOptWidth > Str.size() ? MaxOptWidth - Str.size() : 0;
      outs().indent(NumSpaces).$out(" (default: ");
      if (D.hasValue()) {
        outs().$out_int(D.getValue().getValue());
      } else {
        outs().$out("*no default*");
      }
      outs().$out(")\n");
    } finally {
      if (Str != null) { Str.$destroy(); }
    }
  }


  // An out-of-line virtual method to provide a 'home' for this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser<llvm::cl::boolOrDefault>::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 70,
   FQN = "llvm::cl::OptionValue<std::basic_string<char> >::anchor", NM = "_ZN4llvm2cl11OptionValueISsE6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl11OptionValueISsE6anchorEv")
  //</editor-fold>
  @Override public void anchor() {
  }

}