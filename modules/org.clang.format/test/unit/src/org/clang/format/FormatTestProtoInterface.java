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

package org.clang.format;

import org.clang.tooling.ToolingGlobals;
import org.clang.tooling.core.Range;
import org.clang.tooling.core.Replacement;
import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.literal_constants;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.support.Expected;
import org.llvm.support.llvm;

//JAVA: namespace clang {

//JAVA: namespace format {
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto">
//</editor-fold>
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 20, FQN = "clang::format::FormatTestProto", NM = "_ZN5clang6format15FormatTestProtoE", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProtoE")
public abstract interface FormatTestProtoInterface {

  /*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::format">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 22, FQN = "clang::format::FormatTestProto::format", NM = "_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE")
  public static std.string format(StringRef Code, /*uint*/ int Offset, /*uint*/ int Length, final FormatStyle Style) {
    std.vector<Range> Ranges = null;
    std.setType<Replacement> Replaces = null;
    Expected<std.string> Result = null;
    try {
      do {
        if ( /*::*/ llvm.DebugFlag && /*::*/ llvm.isCurrentDebugType( /*KEEP_STR*/ "format-test")) {
          llvm.errs().$out( /*KEEP_STR*/ "---\n");
        }
      } while (false);
      do {
        if ( /*::*/ llvm.DebugFlag && /*::*/ llvm.isCurrentDebugType( /*KEEP_STR*/ "format-test")) {
          llvm.errs().$out( /*NO_COPY*/ Code).$out( /*KEEP_STR*/ "\n\n");
        }
      } while (false);
      Ranges /*J*/ = new std.vector<Range>(1, new Range(Offset, Length), new Range());
      Replaces = FormatGlobals.reformat(Style, new StringRef(Code), new ArrayRef<Range>(Ranges, false));
      Result = ToolingGlobals.applyAllReplacements(new StringRef(Code), Replaces);
      assert(Result.$bool());
//      switch (0) {
//        case 0:
//        default:
//          {
//            /*const*/
//            AssertionResult gtest_ar_ = null;
//            try {
//              gtest_ar_ = new AssertionResult((boolean) (Result.$bool()));
//              if (gtest_ar_.$bool()) {
//                ;
//              } else {
//                JavaCleaner $c$ = Native.$createJavaCleaner();
//                try {
//                  $c$.track(new AssertHelper(TestPartResult.Type.kNonFatalFailure, literal_constants.$("${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp"), 29, $c$.track(internal.GetBoolAssertionFailureMessage(gtest_ar_, literal_constants.$("static_cast<bool>(Result)"), literal_constants.$false, literal_constants.$true)).c_str())).$assign($c$.track(new Message()));
//                  $c$.clean();
//                } finally {
//                  $c$.$destroy();
//                }
//              }
//            } finally {
//              if (gtest_ar_ != null) {
//                gtest_ar_.$destroy();
//              }
//            }
//          }
//      }
      do {
        if ( /*::*/ llvm.DebugFlag && /*::*/ llvm.isCurrentDebugType( /*KEEP_STR*/ "format-test")) {
          llvm.errs().$out(literal_constants.$LF).$out(Result.$star()).$out( /*KEEP_STR*/ "\n\n");
        }
      } while (false);
      return new std.string(Result.$star());
    } finally {
      if (Result != null) {
        Result.$destroy();
      }
      if (Replaces != null) {
        Replaces.$destroy();
      }
      if (Ranges != null) {
        Ranges.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::format">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 34, FQN = "clang::format::FormatTestProto::format", NM = "_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefE", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefE")
  public static std.string format(StringRef Code) {
    FormatStyle Style = null;
    try {
      Style = FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_Proto);
      Style.ColumnLimit = 60; // To make writing tests easier.
      return FormatTestProtoInterface.format(new StringRef(Code), 0, Code.size(), Style);
    } finally {
      if (Style != null) {
        Style.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::verifyFormat">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 40, FQN = "clang::format::FormatTestProto::verifyFormat", NM = "_ZN5clang6format15FormatTestProto12verifyFormatEN4llvm9StringRefE", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProto12verifyFormatEN4llvm9StringRefE")
  public static void verifyFormat(StringRef Code) {
    FormatTestProtoInterface.format(Code);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::~FormatTestProto">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 20, FQN = "clang::format::FormatTestProto::~FormatTestProto", NM = "_ZN5clang6format15FormatTestProtoD0Ev", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProtoD0Ev")
  public default void $destroy$FormatTestProto() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::FormatTestProto">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 20, FQN = "clang::format::FormatTestProto::FormatTestProto", NM = "_ZN5clang6format15FormatTestProtoC1Ev", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProtoC1Ev")
  public default void $FormatTestProto() {
  }
  
}
