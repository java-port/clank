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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


// An ES6 module reference.
//
// ES6 implements a module system, where individual modules (~= source files)
// can reference other modules, either importing symbols from them, or exporting
// symbols from them:
//   import {foo} from 'foo';
//   export {foo};
//   export {bar} from 'bar';
//
// `export`s with URLs are syntactic sugar for an import of the symbol from the
// URL, followed by an export of the symbol, allowing this code to treat both
// statements more or less identically, with the exception being that `export`s
// are sorted last.
//
// imports and exports support individual symbols, but also a wildcard syntax:
//   import * as prefix from 'foo';
//   export * from 'bar';
//
// This struct represents both exports and imports to build up the information
// required for sorting module references.
//<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 73,
 FQN="clang::format::JsModuleReference", NM="_ZN5clang6format17JsModuleReferenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReferenceE")
//</editor-fold>
public class/*struct*/ JsModuleReference implements Destructors.ClassWithDestructor, Native.NativePOD<JsModuleReference> {
  public boolean IsExport/* = false*/;
  // Module references are sorted into these categories, in order.
  //<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference::ReferenceCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 76,
   FQN="clang::format::JsModuleReference::ReferenceCategory", NM="_ZN5clang6format17JsModuleReference17ReferenceCategoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReference17ReferenceCategoryE")
  //</editor-fold>
  public enum ReferenceCategory implements Native.NativeUIntEnum {
    SIDE_EFFECT(0), // "import 'something';"
    ABSOLUTE(SIDE_EFFECT.getValue() + 1), // from 'something'
    RELATIVE_PARENT(ABSOLUTE.getValue() + 1), // from '../*'
    RELATIVE(RELATIVE_PARENT.getValue() + 1); // from './*'

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ReferenceCategory valueOf(int val) {
      ReferenceCategory out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ReferenceCategory[] VALUES;
      private static final ReferenceCategory[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ReferenceCategory kind : ReferenceCategory.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ReferenceCategory[min < 0 ? (1-min) : 0];
        VALUES = new ReferenceCategory[max >= 0 ? (1+max) : 0];
        for (ReferenceCategory kind : ReferenceCategory.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ReferenceCategory(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  public ReferenceCategory Category/* = ReferenceCategory::SIDE_EFFECT*/;
  // The URL imported, e.g. `import .. from 'url';`. Empty for `export {a, b};`.
  public StringRef URL;
  // Prefix from "import * as prefix". Empty for symbol imports and `export *`.
  // Implies an empty names list.
  public StringRef Prefix;
  // Symbols from `import {SymbolA, SymbolB, ...} from ...;`.
  public SmallVector<JsImportedSymbol> Symbols;
  // Textual position of the import/export, including preceding and trailing
  // comments.
  public SourceRange Range;
  //<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference::JsModuleReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 73,
   FQN="clang::format::JsModuleReference::JsModuleReference", NM="_ZN5clang6format17JsModuleReferenceC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReferenceC1EOS1_")
  //</editor-fold>
  public /*inline*/ JsModuleReference(JD$Move _dparam, final JsModuleReference /*&&*/$Prm0) {
    // : IsExport(static_cast<JsModuleReference &&>().IsExport), Category(static_cast<JsModuleReference &&>().Category), URL(static_cast<JsModuleReference &&>().URL), Prefix(static_cast<JsModuleReference &&>().Prefix), Symbols(static_cast<JsModuleReference &&>().Symbols), Range(static_cast<JsModuleReference &&>().Range) 
    //START JInit
    this.IsExport = $Prm0.IsExport;
    this.Category = $Prm0.Category;
    this.URL = new StringRef(JD$Move.INSTANCE, $Prm0.URL);
    this.Prefix = new StringRef(JD$Move.INSTANCE, $Prm0.Prefix);
    this.Symbols = new SmallVector<JsImportedSymbol>(JD$Move.INSTANCE, $Prm0.Symbols);
    this.Range = new SourceRange(JD$Move.INSTANCE, $Prm0.Range);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 73,
   FQN="clang::format::JsModuleReference::operator=", NM="_ZN5clang6format17JsModuleReferenceaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReferenceaSEOS1_")
  //</editor-fold>
  public /*inline*/ JsModuleReference /*&*/ $assignMove(final JsModuleReference /*&&*/$Prm0) {
    this.IsExport = $Prm0.IsExport;
    this.Category = $Prm0.Category;
    this.URL.$assignMove($Prm0.URL);
    this.Prefix.$assignMove($Prm0.Prefix);
    this.Symbols.$assignMove($Prm0.Symbols);
    this.Range.$assignMove($Prm0.Range);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference::JsModuleReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 73,
   FQN="clang::format::JsModuleReference::JsModuleReference", NM="_ZN5clang6format17JsModuleReferenceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReferenceC1Ev")
  //</editor-fold>
  public /*inline*/ JsModuleReference() {
    // : IsExport(false), Category(ReferenceCategory::SIDE_EFFECT), URL(), Prefix(), Symbols(), Range() 
    //START JInit
    /*InClass*/this.IsExport = false;
    /*InClass*/this.Category = ReferenceCategory.SIDE_EFFECT;
    this.URL = new StringRef();
    this.Prefix = new StringRef();
    this.Symbols = new SmallVector<JsImportedSymbol>(1, new JsImportedSymbol());
    this.Range = new SourceRange();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference::JsModuleReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 73,
   FQN="clang::format::JsModuleReference::JsModuleReference", NM="_ZN5clang6format17JsModuleReferenceC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReferenceC1ERKS1_")
  //</editor-fold>
  public /*inline*/ JsModuleReference(final /*const*/ JsModuleReference /*&*/ $Prm0) {
    // : IsExport(.IsExport), Category(.Category), URL(.URL), Prefix(.Prefix), Symbols(.Symbols), Range(.Range) 
    //START JInit
    this.IsExport = $Prm0.IsExport;
    this.Category = $Prm0.Category;
    this.URL = new StringRef($Prm0.URL);
    this.Prefix = new StringRef($Prm0.Prefix);
    this.Symbols = new SmallVector<JsImportedSymbol>($Prm0.Symbols);
    this.Range = new SourceRange($Prm0.Range);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference::~JsModuleReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 73,
   FQN="clang::format::JsModuleReference::~JsModuleReference", NM="_ZN5clang6format17JsModuleReferenceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReferenceD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Symbols.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::JsModuleReference::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp", line = 73,
   FQN="clang::format::JsModuleReference::operator=", NM="_ZN5clang6format17JsModuleReferenceaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/SortJavaScriptImports.cpp -nm=_ZN5clang6format17JsModuleReferenceaSERKS1_")
  //</editor-fold>
  public /*inline*/ JsModuleReference /*&*/ $assign(final /*const*/ JsModuleReference /*&*/ $Prm0) {
    this.IsExport = $Prm0.IsExport;
    this.Category = $Prm0.Category;
    this.URL.$assign($Prm0.URL);
    this.Prefix.$assign($Prm0.Prefix);
    this.Symbols.$assign($Prm0.Symbols);
    this.Range.$assign($Prm0.Range);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public JsModuleReference clone() {
    JsModuleReference res = new JsModuleReference();
    res.$assign(this);
    return res;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "IsExport=" + IsExport // NOI18N
              + ", Category=" + Category // NOI18N
              + ", URL=" + URL // NOI18N
              + ", Prefix=" + Prefix // NOI18N
              + ", Symbols=" + Symbols // NOI18N
              + ", Range=" + Range; // NOI18N
  }
}
