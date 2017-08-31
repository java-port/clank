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

package org.clang.lex.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// PPValue - Represents the value of a subexpression of a preprocessor
/// conditional and the source range covered by it.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 34,
 FQN="(anonymous namespace)::PPValue", NM="_ZN12_GLOBAL__N_17PPValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValueE")
//</editor-fold>
public class PPValue implements Destructors.ClassWithDestructor {
  private SourceRange Range;
  private IdentifierInfo /*P*/ II;
/*public:*/
  public APSInt Val;
  
  // Default ctor - Construct an 'invalid' PPValue.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::PPValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 41,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 40,
   FQN="(anonymous namespace)::PPValue::PPValue", NM="_ZN12_GLOBAL__N_17PPValueC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValueC1Ej")
  //</editor-fold>
  public PPValue(/*uint*/int BitWidth) {
    /* : Range(), Val(BitWidth)*/ 
    //START JInit
    this.Range = new SourceRange();
    this.Val = new APSInt(BitWidth);
    //END JInit
  }

  
  // If this value was produced by directly evaluating an identifier, produce
  // that identifier.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 45,
   FQN="(anonymous namespace)::PPValue::getIdentifier", NM="_ZNK12_GLOBAL__N_17PPValue13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZNK12_GLOBAL__N_17PPValue13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return II;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::setIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 46,
   FQN="(anonymous namespace)::PPValue::setIdentifier", NM="_ZN12_GLOBAL__N_17PPValue13setIdentifierEPN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValue13setIdentifierEPN5clang14IdentifierInfoE")
  //</editor-fold>
  public void setIdentifier(IdentifierInfo /*P*/ II) {
    this.II = II;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::getBitWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 48,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 42,
   FQN="(anonymous namespace)::PPValue::getBitWidth", NM="_ZNK12_GLOBAL__N_17PPValue11getBitWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZNK12_GLOBAL__N_17PPValue11getBitWidthEv")
  //</editor-fold>
  public /*uint*/int getBitWidth() /*const*/ {
    return Val.getBitWidth();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::isUnsigned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 49,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 43,
   FQN="(anonymous namespace)::PPValue::isUnsigned", NM="_ZNK12_GLOBAL__N_17PPValue10isUnsignedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZNK12_GLOBAL__N_17PPValue10isUnsignedEv")
  //</editor-fold>
  public boolean isUnsigned() /*const*/ {
    return Val.isUnsigned();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::getRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 45,
   FQN="(anonymous namespace)::PPValue::getRange", NM="_ZNK12_GLOBAL__N_17PPValue8getRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZNK12_GLOBAL__N_17PPValue8getRangeEv")
  //</editor-fold>
  public SourceRange getRange() /*const*/ {
    return Range;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::setRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 53,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 47,
   FQN="(anonymous namespace)::PPValue::setRange", NM="_ZN12_GLOBAL__N_17PPValue8setRangeEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValue8setRangeEN5clang14SourceLocationE")
  //</editor-fold>
  public void setRange(SourceLocation L) {
    Range.setBegin(/*NO_COPY*/L);
    Range.setEnd(/*NO_COPY*/L);
  }
  public void setRange(/*SourceLocation*/int L) {
    Range.setBegin(L);
    Range.setEnd(L);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::setRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 54,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 48,
   FQN="(anonymous namespace)::PPValue::setRange", NM="_ZN12_GLOBAL__N_17PPValue8setRangeEN5clang14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValue8setRangeEN5clang14SourceLocationES2_")
  //</editor-fold>
  public void setRange(SourceLocation B, SourceLocation E) {
    Range.setBegin(/*NO_COPY*/B);
    Range.setEnd(/*NO_COPY*/E);
  }
  public void setRange(/*SourceLocation*/int B, /*SourceLocation*/int E) {
    Range.setBegin(B);
    Range.setEnd(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::setBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 57,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 51,
   FQN="(anonymous namespace)::PPValue::setBegin", NM="_ZN12_GLOBAL__N_17PPValue8setBeginEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValue8setBeginEN5clang14SourceLocationE")
  //</editor-fold>
  public void setBegin(SourceLocation L) {
    Range.setBegin(/*NO_COPY*/L);
  }
  public void setBegin(/*SourceLocation*/int L) {
    Range.setBegin(L);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::setEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 58,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", old_line = 52,
   FQN="(anonymous namespace)::PPValue::setEnd", NM="_ZN12_GLOBAL__N_17PPValue6setEndEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValue6setEndEN5clang14SourceLocationE")
  //</editor-fold>
  public void setEnd(SourceLocation L) {
    Range.setEnd(/*NO_COPY*/L);
  }
  public void setEnd(/*SourceLocation*/int L) {  
    Range.setEnd(L);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPValue::~PPValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp", line = 34,
   FQN="(anonymous namespace)::PPValue::~PPValue", NM="_ZN12_GLOBAL__N_17PPValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPExpressions.cpp -nm=_ZN12_GLOBAL__N_17PPValueD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Val.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", II=" + II // NOI18N
              + ", Val=" + Val; // NOI18N
  }
}
