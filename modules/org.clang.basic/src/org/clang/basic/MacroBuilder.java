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

package org.clang.basic;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="clang::MacroBuilder">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", line = 24,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", old_line = 24,
 FQN = "clang::MacroBuilder", NM = "_ZN5clang12MacroBuilderE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN5clang12MacroBuilderE")
//</editor-fold>
public class MacroBuilder {
  private raw_ostream /*&*/ Out;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MacroBuilder::MacroBuilder">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", line = 27,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", old_line = 27,
   FQN = "clang::MacroBuilder::MacroBuilder", NM = "_ZN5clang12MacroBuilderC1ERN4llvm11raw_ostreamE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN5clang12MacroBuilderC1ERN4llvm11raw_ostreamE")
  //</editor-fold>
  public MacroBuilder(raw_ostream /*&*/ Output) {
    /* : Out(Output)*/ 
    //START JInit
    this.Out = Output;
    //END JInit
  }

  
  /// Append a \#define line for macro of the form "\#define Name Value\n".
  //<editor-fold defaultstate="collapsed" desc="clang::MacroBuilder::defineMacro">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", line = 30,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", old_line = 30,
   FQN = "clang::MacroBuilder::defineMacro", NM = "_ZN5clang12MacroBuilder11defineMacroERKN4llvm5TwineES4_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN5clang12MacroBuilder11defineMacroERKN4llvm5TwineES4_")
  //</editor-fold>
  public void defineMacro(/*const*/Twine /*&*/ Name) {
    defineMacro(Name, Twine.T$1);
  }
  public void defineMacro(/*const*/Twine /*&*/ Name, /*const*/Twine /*&*/ Value/*= "1"*/) {
    $out_raw_ostream_Twine($out_raw_ostream_Twine(Out.$out(DEFINE_STRING_REF), Name).$out_char($$SPACE), Value).$out_char($$LF);
  }
  private static final StringRef DEFINE_STRING_REF = new StringRef("#define ");

  
  /// Append a \#undef line for Name.  Name should be of the form XXX
  /// and we emit "\#undef XXX".
  //<editor-fold defaultstate="collapsed" desc="clang::MacroBuilder::undefineMacro">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", line = 36,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", old_line = 36,
   FQN = "clang::MacroBuilder::undefineMacro", NM = "_ZN5clang12MacroBuilder13undefineMacroERKN4llvm5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN5clang12MacroBuilder13undefineMacroERKN4llvm5TwineE")
  //</editor-fold>
  public void undefineMacro(/*const*/Twine /*&*/ Name) {
    $out_raw_ostream_Twine(Out.$out(UNDEF_STRING_REF), Name).$out_char($$LF);
  }
  private static final StringRef UNDEF_STRING_REF = new StringRef("#undef ");

  
  /// Directly append Str and a newline to the underlying buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::MacroBuilder::append">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/MacroBuilder.h", old_line = 41,
   FQN = "clang::MacroBuilder::append", NM = "_ZN5clang12MacroBuilder6appendERKN4llvm5TwineE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN5clang12MacroBuilder6appendERKN4llvm5TwineE")
  //</editor-fold>
  public void append(/*const*/Twine /*&*/ Str) {
    $out_raw_ostream_Twine(Out, Str).$out_char($$LF);
  }

  @Override
  public String toString() {
    return "" + Out;
  }
}
