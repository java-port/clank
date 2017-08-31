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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.CommandLineStatics.*;

/**
 * @author vkvashin
 */
//--------------------------------------------------
// parser<char>
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::parser">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 928,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser")
//</editor-fold>
public class parserChar extends /*public*/ basic_parser</*char*/Byte> {
/*public:*/
  // parse - Return true on error.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser</*char*/byte>::parse">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 932,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser</*char*/byte>::parse")
  //</editor-fold>
  @Override
  public boolean parse(Option /*&*/ $Prm0, StringRef $Prm1, StringRef Arg, type$ref<Byte>/*char &*/ Value) {
    Value.$set(Arg.$at(0));
    return false;
  }


  // getValueName - Overload in subclass to provide a better default value.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser</*char*/byte>::getValueName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 938,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser</*char*/byte>::getValueName")
  //</editor-fold>
  @Override public /*virtual*/ /*const*/char$ptr/*char P*/ getValueName() /*const*/ {
    return $("char");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser</*char*/byte>::printOptionDiff">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1348,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::parser</*char*/byte>::printOptionDiff")
  //</editor-fold>
  public void printOptionDiff(/*const*/ Option /*&*/ O, /*char*/byte V, OptionValue</*char*/Byte> D, /*size_t*/int GlobalWidth) /*const*/ {
    std.string Str = null;
    try {
      printOptionName(O, GlobalWidth);
      Str/*J*/= new std.string();
      {
        raw_string_ostream SS = null;
        try {
          SS/*J*/= new raw_string_ostream(Str);
          SS.$out_char(V);
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
      }
      outs().$out("= ").$out(Str);
      /*size_t*/int NumSpaces = MaxOptWidth > Str.size() ? MaxOptWidth - Str.size() : 0;
      outs().indent(NumSpaces).$out(" (default: ");
      if (D.hasValue()) {
        outs().$out_char(D.getValue());
      } else {
        outs().$out("*no default*");
      }
      outs().$out(")\n");
    } finally {
      if (Str != null) { Str.$destroy(); }
    }
  }


  // An out-of-line virtual method to provide a 'home' for this class.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::parser</*char*/byte>::anchor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 77,
   FQN = "llvm::cl::parser<unsigned long long>::anchor", NM = "_ZN4llvm2cl6parserIyE6anchorEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6parserIyE6anchorEv")
  //</editor-fold>
  @Override public void anchor() {
  }

}