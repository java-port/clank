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
package org.clang.lex;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type Preprocessor_NestedEnums">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -split-class=clang::Preprocessor@this ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor12CurLexerKindE;_ZN5clang12PreprocessorE_Unnamed_enum;_ZN5clang12PreprocessorE_Unnamed_enum2; -static-type=Preprocessor_NestedEnums -package=org.clang.lex")
//</editor-fold>
public class Preprocessor_NestedEnums extends RefCountedBase<Preprocessor> {
private final /*split clang::Preprocessor*/ Preprocessor $this() { return (Preprocessor)this; }

// Next __COUNTER__ value.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 146,
   FQN="clang::Preprocessor::(anonymous)", NM="_ZN5clang12PreprocessorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12PreprocessorE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// \brief Maximum depth of \#includes.
    public static final /*uint*/int MaxAllowedIncludeStackDepth = 200;
/*}*/

/// \brief The kind of lexer we're currently working with.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::CurLexerKind">
@Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 311,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 310,
   FQN="clang::Preprocessor::CurLexerKind", NM="_ZN5clang12Preprocessor12CurLexerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPDirectives.cpp -nm=_ZN5clang12Preprocessor12CurLexerKindE")
  //</editor-fold>
  public enum CurLexerKindEnum/*CHANGED NAME*/ implements Native.ComparableLower {
    CLK_Lexer(0),
    CLK_PTHLexer(CLK_Lexer.getValue() + 1),
    CLK_TokenLexer(CLK_PTHLexer.getValue() + 1),
    CLK_CachingLexer(CLK_TokenLexer.getValue() + 1),
    CLK_LexAfterModuleImport(CLK_CachingLexer.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CurLexerKindEnum valueOf(int val) {
      CurLexerKindEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    protected /*private*/ static final class Values {
      protected /*private*/ static final CurLexerKindEnum[] VALUES;
      protected /*private*/ static final CurLexerKindEnum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CurLexerKindEnum kind : CurLexerKindEnum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CurLexerKindEnum[min < 0 ? (1-min) : 0];
        VALUES = new CurLexerKindEnum[max >= 0 ? (1+max) : 0];
        for (CurLexerKindEnum kind : CurLexerKindEnum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    protected /*private*/ final /*uint*/int value;
    private CurLexerKindEnum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CurLexerKindEnum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CurLexerKindEnum)obj).value);}
    //</editor-fold>
  }

/// \{
/// \brief Cache of macro expanders to reduce malloc traffic.
//<editor-fold defaultstate="collapsed" desc="clang::Preprocessor::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", line = 594,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Preprocessor.h", old_line = 587,
   FQN="clang::Preprocessor::(anonymous)", NM="_ZN5clang12PreprocessorE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPCaching.cpp -nm=_ZN5clang12PreprocessorE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int TokenLexerCacheSize = 8;
/*}*/
} // END OF class Preprocessor_NestedEnums
