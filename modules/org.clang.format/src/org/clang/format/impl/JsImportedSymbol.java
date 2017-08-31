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

package org.clang.format.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.basic.*;


// An imported symbol in a JavaScript ES6 import/export, possibly aliased.
//<editor-fold defaultstate="collapsed" desc="clang::format::JsImportedSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 41,
 FQN="clang::format::JsImportedSymbol", NM="_ZN5clang6format16JsImportedSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format16JsImportedSymbolE")
//</editor-fold>
public class/*struct*/ JsImportedSymbol implements Native.NativePOD<JsImportedSymbol>, Native.NativeComparable<JsImportedSymbol> {
  public StringRef Symbol;
  public StringRef Alias;
  public SourceRange Range;
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::JsImportedSymbol::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 46,
   FQN="clang::format::JsImportedSymbol::operator==", NM="_ZNK5clang6format16JsImportedSymboleqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZNK5clang6format16JsImportedSymboleqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ JsImportedSymbol /*&*/ RHS) /*const*/ {
    // Ignore Range for comparison, it is only used to stitch code together,
    // but imports at different code locations are still conceptually the same.
    return $eq_StringRef(/*NO_COPY*/Symbol, /*NO_COPY*/RHS.Symbol) && $eq_StringRef(/*NO_COPY*/Alias, /*NO_COPY*/RHS.Alias);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsImportedSymbol::JsImportedSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 41,
   FQN="clang::format::JsImportedSymbol::JsImportedSymbol", NM="_ZN5clang6format16JsImportedSymbolC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format16JsImportedSymbolC1Ev")
  //</editor-fold>
  public /*inline*/ JsImportedSymbol() {
    // : Symbol(), Alias(), Range() 
    //START JInit
    this.Symbol = new StringRef();
    this.Alias = new StringRef();
    this.Range = new SourceRange();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsImportedSymbol::JsImportedSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 41,
   FQN="clang::format::JsImportedSymbol::JsImportedSymbol", NM="_ZN5clang6format16JsImportedSymbolC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format16JsImportedSymbolC1EOS1_")
  //</editor-fold>
  public /*inline*/ JsImportedSymbol(JD$Move _dparam, final JsImportedSymbol /*&&*/$Prm0) {
    // : Symbol(static_cast<JsImportedSymbol &&>().Symbol), Alias(static_cast<JsImportedSymbol &&>().Alias), Range(static_cast<JsImportedSymbol &&>().Range) 
    //START JInit
    this.Symbol = new StringRef(JD$Move.INSTANCE, $Prm0.Symbol);
    this.Alias = new StringRef(JD$Move.INSTANCE, $Prm0.Alias);
    this.Range = new SourceRange(JD$Move.INSTANCE, $Prm0.Range);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsImportedSymbol::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 41,
   FQN="clang::format::JsImportedSymbol::operator=", NM="_ZN5clang6format16JsImportedSymbolaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format16JsImportedSymbolaSERKS1_")
  //</editor-fold>
  public /*inline*/ JsImportedSymbol /*&*/ $assign(final /*const*/ JsImportedSymbol /*&*/ $Prm0) {
    this.Symbol.$assign($Prm0.Symbol);
    this.Alias.$assign($Prm0.Alias);
    this.Range.$assign($Prm0.Range);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsImportedSymbol::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 41,
   FQN="clang::format::JsImportedSymbol::operator=", NM="_ZN5clang6format16JsImportedSymbolaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format16JsImportedSymbolaSEOS1_")
  //</editor-fold>
  public /*inline*/ JsImportedSymbol /*&*/ $assignMove(final JsImportedSymbol /*&&*/$Prm0) {
    this.Symbol.$assignMove($Prm0.Symbol);
    this.Alias.$assignMove($Prm0.Alias);
    this.Range.$assignMove($Prm0.Range);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public JsImportedSymbol(JsImportedSymbol other) {
    this.Symbol = new StringRef(other.Symbol);
    this.Alias = new StringRef(other.Alias);
    this.Range = new SourceRange(other.Range);
  }

  @Override
  public JsImportedSymbol clone() {
    return new JsImportedSymbol(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Symbol=" + Symbol // NOI18N
              + ", Alias=" + Alias // NOI18N
              + ", Range=" + Range; // NOI18N
  }
}
