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

package org.clang.ast;

import java.util.Comparator;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.impl.DeclarationNameClangStatics.*;


/// DeclarationName - The name of a declaration. In the common case,
/// this just stores an IdentifierInfo pointer to a normal
/// name. However, it also provides encodings for Objective-C
/// selectors (optimizing zero- and one-argument selectors, which make
/// up 78% percent of all selectors in Cocoa.h) and special C++ names
/// for constructors, destructors, and conversion functions.
//<editor-fold defaultstate="collapsed" desc="clang::DeclarationName">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use $Ptr & $PtrBits*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 48,
 FQN="clang::DeclarationName", NM="_ZN5clang15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameE")
//</editor-fold>
public class DeclarationName implements Native.Native$Bool, NativeCloneable<DeclarationName>, NativeHashable, ComparableLower {

/*public:*/
  /// NameKind - The kind of name this object contains.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::NameKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 51,
   FQN="clang::DeclarationName::NameKind", NM="_ZN5clang15DeclarationName8NameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationName8NameKindE")
  //</editor-fold>
  public enum NameKind implements Native.ComparableLower {
    Identifier(0),
    ObjCZeroArgSelector(Identifier.getValue() + 1),
    ObjCOneArgSelector(ObjCZeroArgSelector.getValue() + 1),
    ObjCMultiArgSelector(ObjCOneArgSelector.getValue() + 1),
    CXXConstructorName(ObjCMultiArgSelector.getValue() + 1),
    CXXDestructorName(CXXConstructorName.getValue() + 1),
    CXXConversionFunctionName(CXXDestructorName.getValue() + 1),
    CXXOperatorName(CXXConversionFunctionName.getValue() + 1),
    CXXLiteralOperatorName(CXXOperatorName.getValue() + 1),
    CXXUsingDirective(CXXLiteralOperatorName.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NameKind valueOf(int val) {
      NameKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NameKind[] VALUES;
      private static final NameKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NameKind kind : NameKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NameKind[min < 0 ? (1-min) : 0];
        VALUES = new NameKind[max >= 0 ? (1+max) : 0];
        for (NameKind kind : NameKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NameKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NameKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NameKind)obj).value);}
    //</editor-fold>
  };
  public static /*const*//*uint*/int NumNameKinds = NameKind.CXXUsingDirective.getValue() + 1;
/*private:*/
  /// StoredNameKind - The kind of name that is actually stored in the
  /// upper bits of the Ptr field. This is only used internally.
  ///
  /// Note: The entries here are synchronized with the entries in Selector,
  /// for efficient translation between the two.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::StoredNameKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 71,
   FQN="clang::DeclarationName::StoredNameKind", NM="_ZN5clang15DeclarationName14StoredNameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationName14StoredNameKindE")
  //</editor-fold>
  private static final class/*enum*/ StoredNameKind {
    public static final /*uint*/int StoredIdentifier = 0;
    public static final /*uint*/int StoredObjCZeroArgSelector = 0x01;
    public static final /*uint*/int StoredObjCOneArgSelector = 0x02;
    public static final /*uint*/int StoredDeclarationNameExtra = 0x03;
    public static final /*uint*/int PtrMask = 0x03;
  };
  
  /// Ptr - The lowest two bits are used to express what kind of name
  /// we're actually storing, using the values of NameKind. Depending
  /// on the kind of name this is, the upper bits of Ptr may have one
  /// of several different meanings:
  ///
  ///   StoredIdentifier - The name is a normal identifier, and Ptr is
  ///   a normal IdentifierInfo pointer.
  ///
  ///   StoredObjCZeroArgSelector - The name is an Objective-C
  ///   selector with zero arguments, and Ptr is an IdentifierInfo
  ///   pointer pointing to the selector name.
  ///
  ///   StoredObjCOneArgSelector - The name is an Objective-C selector
  ///   with one argument, and Ptr is an IdentifierInfo pointer
  ///   pointing to the selector name.
  ///
  ///   StoredDeclarationNameExtra - Ptr is actually a pointer to a
  ///   DeclarationNameExtra structure, whose first value will tell us
  ///   whether this is an Objective-C selector, C++ operator-id name,
  ///   or special C++ name.
  // JAVA: decompose
  private Object/*uintptr_t*/ $Ptr;
  private /*uint*/byte $PtrBits;
  
  /// getStoredNameKind - Return the kind of object that is stored in
  /// Ptr.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getStoredNameKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use $PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 103,
   FQN="clang::DeclarationName::getStoredNameKind", NM="_ZNK5clang15DeclarationName17getStoredNameKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName17getStoredNameKindEv")
  //</editor-fold>
  private /*StoredNameKind*//*uint*/int getStoredNameKind() /*const*/ {
    return ((/*static_cast*//*StoredNameKind*//*uint*/int)($PtrBits & StoredNameKind.PtrMask));
  }

  
  /// getExtra - Get the "extra" information associated with this
  /// multi-argument selector or C++ special name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getExtra">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 109,
   FQN="clang::DeclarationName::getExtra", NM="_ZNK5clang15DeclarationName8getExtraEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName8getExtraEv")
  //</editor-fold>
  private DeclarationNameExtra /*P*/ getExtra() /*const*/ {
    assert (getStoredNameKind() == StoredNameKind.StoredDeclarationNameExtra) : "Declaration name does not store an Extra structure";
    return reinterpret_cast(DeclarationNameExtra /*P*/ .class, $Ptr/* & ~StoredNameKind.PtrMask*/);
  }

  
  /// getAsCXXSpecialName - If the stored pointer is actually a
  /// CXXSpecialName, returns a pointer to it. Otherwise, returns
  /// a NULL pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getAsCXXSpecialName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use $Ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 118,
   FQN="clang::DeclarationName::getAsCXXSpecialName", NM="_ZNK5clang15DeclarationName19getAsCXXSpecialNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName19getAsCXXSpecialNameEv")
  //</editor-fold>
  private CXXSpecialName /*P*/ getAsCXXSpecialName() /*const*/ {
    NameKind Kind = getNameKind();
    if (Kind.getValue() >= NameKind.CXXConstructorName.getValue() && Kind.getValue() <= NameKind.CXXConversionFunctionName.getValue()) {
      return reinterpret_cast(CXXSpecialName /*P*/ .class, $Ptr/* & ~StoredNameKind.PtrMask*/);
    }
    return null;
  }

  
  /// getAsCXXOperatorIdName
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getAsCXXOperatorIdName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 126,
   FQN="clang::DeclarationName::getAsCXXOperatorIdName", NM="_ZNK5clang15DeclarationName22getAsCXXOperatorIdNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName22getAsCXXOperatorIdNameEv")
  //</editor-fold>
  private CXXOperatorIdName /*P*/ getAsCXXOperatorIdName() /*const*/ {
    if (getNameKind() == NameKind.CXXOperatorName) {
      return reinterpret_cast(CXXOperatorIdName /*P*/ .class, $Ptr/* & ~StoredNameKind.PtrMask*/);
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getAsCXXLiteralOperatorIdName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 132,
   FQN="clang::DeclarationName::getAsCXXLiteralOperatorIdName", NM="_ZNK5clang15DeclarationName29getAsCXXLiteralOperatorIdNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName29getAsCXXLiteralOperatorIdNameEv")
  //</editor-fold>
  private CXXLiteralOperatorIdName /*P*/ getAsCXXLiteralOperatorIdName() /*const*/ {
    if (getNameKind() == NameKind.CXXLiteralOperatorName) {
      return reinterpret_cast(CXXLiteralOperatorIdName /*P*/ .class, $Ptr/* & ~StoredNameKind.PtrMask*/);
    }
    return null;
  }

  
  // Construct a declaration name from the name of a C++ constructor,
  // destructor, or conversion function.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits; and JD$Private*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 140,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1EPNS_14CXXSpecialNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1EPNS_14CXXSpecialNameE")
  //</editor-fold>
  /*friend*/ DeclarationName(JD$Private _dparam, CXXSpecialName /*P*/ Name) {
    // : Ptr(reinterpret_cast<uintptr_t>(Name)) 
    //START JInit
    this.$Ptr = reinterpret_cast_Object/*uintptr_t*/(Name);
    //END JInit
    assert (($PtrBits & StoredNameKind.PtrMask) == 0) : "Improperly aligned CXXSpecialName";
    $PtrBits |= StoredNameKind.StoredDeclarationNameExtra;
  }

  
  // Construct a declaration name from the name of a C++ overloaded
  // operator.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits; and JD$Private*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 148,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1EPNS_17CXXOperatorIdNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1EPNS_17CXXOperatorIdNameE")
  //</editor-fold>
  /*friend*/ DeclarationName(JD$Private _dparam, CXXOperatorIdName /*P*/ Name) {
    // : Ptr(reinterpret_cast<uintptr_t>(Name)) 
    //START JInit
    this.$Ptr = reinterpret_cast_Object/*uintptr_t*/(Name);
    //END JInit
    assert (($PtrBits & StoredNameKind.PtrMask) == 0) : "Improperly aligned CXXOperatorId";
    $PtrBits |= StoredNameKind.StoredDeclarationNameExtra;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits; and JD$Private*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 154,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1EPNS_24CXXLiteralOperatorIdNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1EPNS_24CXXLiteralOperatorIdNameE")
  //</editor-fold>
  /*friend*/ DeclarationName(JD$Private _dparam, CXXLiteralOperatorIdName /*P*/ Name) {
    // : Ptr(reinterpret_cast<uintptr_t>(Name)) 
    //START JInit
    this.$Ptr = reinterpret_cast_Object/*uintptr_t*/(Name);
    //END JInit
    assert (($PtrBits & StoredNameKind.PtrMask) == 0) : "Improperly aligned CXXLiteralOperatorId";
    $PtrBits |= StoredNameKind.StoredDeclarationNameExtra;
  }

  
  /// Construct a declaration name from a raw pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 161,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1Ej")
  //</editor-fold>
  /*friend*/ DeclarationName(Object/*uintptr_t*/ Ptr, /*uint*/int Bits) {
    // : Ptr(Ptr) 
    //START JInit
    this.$Ptr = Ptr;
    //END JInit
    $PtrBits = $uint2uchar(Bits);
  }

  
  /*friend  class DeclarationNameTable*/
  /*friend  class NamedDecl*/
  
  /// getFETokenInfoAsVoidSlow - Retrieves the front end-specified pointer
  /// for this name as a void pointer if it's not an identifier.
  
  /// getFETokenInfoAsVoidSlow - Retrieves the front end-specified pointer
  /// for this name as a void pointer if it's not an identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getFETokenInfoAsVoidSlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 300,
   FQN="clang::DeclarationName::getFETokenInfoAsVoidSlow", NM="_ZNK5clang15DeclarationName24getFETokenInfoAsVoidSlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName24getFETokenInfoAsVoidSlowEv")
  //</editor-fold>
  private Object/*void P*/ getFETokenInfoAsVoidSlow() /*const*/ {
    switch (getNameKind()) {
     case Identifier:
      throw new llvm_unreachable("Handled by getFETokenInfo()");
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      return getAsCXXSpecialName().FETokenInfo;
     case CXXOperatorName:
      return getAsCXXOperatorIdName().FETokenInfo;
     case CXXLiteralOperatorName:
      return getAsCXXLiteralOperatorIdName().FETokenInfo;
     default:
      throw new llvm_unreachable("Declaration name has no FETokenInfo");
    }
  }


/*public:*/
  /// DeclarationName - Used to create an empty selector.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 172,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1Ev")
  //</editor-fold>
  public DeclarationName() {
    // : Ptr(0) 
    //START JInit
    this.$Ptr = null;
    //END JInit
    this.$PtrBits = 0;
  }

  // Construct a declaration name from an IdentifierInfo *.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 175,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1EPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1EPKNS_14IdentifierInfoE")
  //</editor-fold>
  public DeclarationName(/*const*/ IdentifierInfo /*P*/ II) {
    // : Ptr(reinterpret_cast<uintptr_t>(II)) 
    //START JInit
    this.$Ptr = reinterpret_cast_Object/*uintptr_t*/(II);
    //END JInit
    assert (($PtrBits & StoredNameKind.PtrMask) == 0) : "Improperly aligned IdentifierInfo";
  }

  
  // Construct a declaration name from an Objective-C selector.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 181,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1ENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1ENS_8SelectorE")
  //</editor-fold>
  public DeclarationName(Selector Sel) {
    // : Ptr(Sel.InfoPtr) 
    //START JInit
    this.$Ptr = Sel.$InfoPtr;
    //END JInit
    this.$PtrBits = Sel.$InfoPtrBits;
  }

  
  /// getUsingDirectiveName - Return name for all using-directives.
  
  /// getUsingDirectiveName - Return name for all using-directives.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getUsingDirectiveName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 346,
   FQN="clang::DeclarationName::getUsingDirectiveName", NM="_ZN5clang15DeclarationName21getUsingDirectiveNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang15DeclarationName21getUsingDirectiveNameEv")
  //</editor-fold>
  public static DeclarationName getUsingDirectiveName() {
    // Single instance of DeclarationNameExtra for using-directive
    final/*static*/ /*const*/ DeclarationNameExtra UDirExtra = getUsingDirectiveName$$.UDirExtra;
    
    Object/*uintptr_t*/ Ptr = reinterpret_cast_Object/*uintptr_t*/($AddrOf(UDirExtra));
    /*uint*/int PtrBits = StoredNameKind.StoredDeclarationNameExtra;
    
    return new DeclarationName(Ptr, PtrBits);
  }
  private static final class getUsingDirectiveName$$ {
    static final/*static*/ /*const*/ DeclarationNameExtra UDirExtra = new DeclarationNameExtra(DeclarationNameExtra.ExtraKind.CXXUsingDirective.getValue());
  }


  
  // operator bool() - Evaluates true when this declaration name is
  // non-empty.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::operator bool">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 188,
   FQN="clang::DeclarationName::operator bool", NM="_ZNK5clang15DeclarationNamecvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationNamecvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (($PtrBits & StoredNameKind.PtrMask) != 0)
       || ((reinterpret_cast(IdentifierInfo /*P*/ .class, $Ptr/* & ~StoredNameKind.PtrMask*/)) != null);
  }

  
  /// \brief Evaluates true when this declaration name is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 194,
   FQN="clang::DeclarationName::isEmpty", NM="_ZNK5clang15DeclarationName7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return !$Deref(this.$bool());
  }

  
  /// Predicate functions for querying what type of name this is.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::isIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 199,
   FQN="clang::DeclarationName::isIdentifier", NM="_ZNK5clang15DeclarationName12isIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName12isIdentifierEv")
  //</editor-fold>
  public boolean isIdentifier() /*const*/ {
    return getStoredNameKind() == StoredNameKind.StoredIdentifier;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::isObjCZeroArgSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 200,
   FQN="clang::DeclarationName::isObjCZeroArgSelector", NM="_ZNK5clang15DeclarationName21isObjCZeroArgSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName21isObjCZeroArgSelectorEv")
  //</editor-fold>
  public boolean isObjCZeroArgSelector() /*const*/ {
    return getStoredNameKind() == StoredNameKind.StoredObjCZeroArgSelector;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::isObjCOneArgSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 203,
   FQN="clang::DeclarationName::isObjCOneArgSelector", NM="_ZNK5clang15DeclarationName20isObjCOneArgSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName20isObjCOneArgSelectorEv")
  //</editor-fold>
  public boolean isObjCOneArgSelector() /*const*/ {
    return getStoredNameKind() == StoredNameKind.StoredObjCOneArgSelector;
  }

  
  /// getNameKind - Determine what kind of name this is.
  
  /// getNameKind - Determine what kind of name this is.
  // end namespace clang
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getNameKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*split switch()*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 227,
   FQN="clang::DeclarationName::getNameKind", NM="_ZNK5clang15DeclarationName11getNameKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName11getNameKindEv")
  //</editor-fold>
  public DeclarationName.NameKind getNameKind() /*const*/ {
    switch (getStoredNameKind()) {
     case StoredNameKind.StoredIdentifier:
      return NameKind.Identifier;
     case StoredNameKind.StoredObjCZeroArgSelector:
      return NameKind.ObjCZeroArgSelector;
     case StoredNameKind.StoredObjCOneArgSelector:
      return NameKind.ObjCOneArgSelector;
     case StoredNameKind.StoredDeclarationNameExtra:
       // JAVA: we can not uncoditionally use ExtraKind.valueOf here, because
       // value kept in ExtraKindOrNumArgs could be out of range for ExtraKind enum
       // this case is handled in the 'default' branch of this case;
       // emulate this in Java by splitting switch/case/default
       /*uint*/int $val = getExtra().ExtraKindOrNumArgs;
       if ($val < DeclarationNameExtra.ExtraKind.NUM_EXTRA_KINDS.getValue()) {
        switch (DeclarationNameExtra.ExtraKind.valueOf($val)) {
         case CXXConstructor:
          return NameKind.CXXConstructorName;
         case CXXDestructor:
          return NameKind.CXXDestructorName;
         case CXXConversionFunction:
          return NameKind.CXXConversionFunctionName;
         case CXXLiteralOperator:
          return NameKind.CXXLiteralOperatorName;
         case CXXUsingDirective:
          return NameKind.CXXUsingDirective;
         default:
          // Check if we have one of the CXXOperator* enumeration values.
          if ($less_uint(getExtra().ExtraKindOrNumArgs
            , DeclarationNameExtra.ExtraKind.CXXUsingDirective.getValue())) {
            return NameKind.CXXOperatorName;
          }

          return NameKind.ObjCMultiArgSelector;
        }
       } else {
         // all above DeclarationNameExtra.ExtraKind.NUM_EXTRA_KINDS are ObjC-specific
         return NameKind.ObjCMultiArgSelector;
       }
    }
    
    // Can't actually get here.
    throw new llvm_unreachable("This should be unreachable!");
  }


  
  /// \brief Determines whether the name itself is dependent, e.g., because it 
  /// involves a C++ type that is itself dependent.
  ///
  /// Note that this does not capture all of the notions of "dependent name",
  /// because an identifier can be a dependent name if it is used as the 
  /// callee in a call expression with dependent arguments.
  
  /// \brief Determines whether the name itself is dependent, e.g., because it 
  /// involves a C++ type that is itself dependent.
  ///
  /// Note that this does not capture all of the notions of "dependent name",
  /// because an identifier can be a dependent name if it is used as the 
  /// callee in a call expression with dependent arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::isDependentName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 264,
   FQN="clang::DeclarationName::isDependentName", NM="_ZNK5clang15DeclarationName15isDependentNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName15isDependentNameEv")
  //</editor-fold>
  public boolean isDependentName() /*const*/ {
    QualType T = getCXXNameType();
    return !T.isNull() && T.$arrow().isDependentType();
  }


  
  /// getNameAsString - Retrieve the human-readable string for this name.
  
  /// getNameAsString - Retrieve the human-readable string for this name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 269,
   FQN="clang::DeclarationName::getAsString", NM="_ZNK5clang15DeclarationName11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    raw_string_ostream OS = null;
    try {
      std.string Result/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Result);
      $out_raw_ostream_DeclarationName(OS, /*NO_COPY*//*Deref*/this);
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


  
  /// getAsIdentifierInfo - Retrieve the IdentifierInfo * stored in
  /// this declaration name, or NULL if this declaration name isn't a
  /// simple identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getAsIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 224,
   FQN="clang::DeclarationName::getAsIdentifierInfo", NM="_ZNK5clang15DeclarationName19getAsIdentifierInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName19getAsIdentifierInfoEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getAsIdentifierInfo() /*const*/ {
    if (isIdentifier()) {
      return reinterpret_cast(IdentifierInfo /*P*/ .class, $Ptr);
    }
    return null;
  }

  
  /// getAsOpaqueInteger - Get the representation of this declaration
  /// name as an opaque integer.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getAsOpaqueInteger">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 232,
   FQN="clang::DeclarationName::getAsOpaqueInteger", NM="_ZNK5clang15DeclarationName18getAsOpaqueIntegerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName18getAsOpaqueIntegerEv")
  //</editor-fold>
  public Object/*uintptr_t*/ getAsOpaqueInteger() /*const*/ {
    return new PointerIntPair($Ptr, $uchar2uint($PtrBits));
  }

  
  /// getAsOpaquePtr - Get the representation of this declaration name as
  /// an opaque pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getAsOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 236,
   FQN="clang::DeclarationName::getAsOpaquePtr", NM="_ZNK5clang15DeclarationName14getAsOpaquePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName14getAsOpaquePtrEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePtr() /*const*/ {
    return new PointerIntPair($Ptr, $uchar2uint($PtrBits));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getFromOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 238,
   FQN="clang::DeclarationName::getFromOpaquePtr", NM="_ZN5clang15DeclarationName16getFromOpaquePtrEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationName16getFromOpaquePtrEPv")
  //</editor-fold>
  public static DeclarationName getFromOpaquePtr(Object/*void P*/ P) {
    assert P instanceof PointerIntPair : "" + NativeTrace.getIdentityStr(P);
    PointerIntPair Pair = (PointerIntPair) P;
    DeclarationName N/*J*/= new DeclarationName(Pair.getPointer(), Pair.getInt());
//    N.$Ptr = reinterpret_cast_Object/*uintptr_t*/(P);
    return N;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getFromOpaqueInteger">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 244,
   FQN="clang::DeclarationName::getFromOpaqueInteger", NM="_ZN5clang15DeclarationName20getFromOpaqueIntegerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationName20getFromOpaqueIntegerEj")
  //</editor-fold>
  public static DeclarationName getFromOpaqueInteger(Object/*uintptr_t*/ P) {
    assert P instanceof PointerIntPair : "" + NativeTrace.getIdentityStr(P);
    PointerIntPair Pair = (PointerIntPair) P;
    DeclarationName N/*J*/= new DeclarationName(Pair.getPointer(), Pair.getInt());
//    N.$Ptr = P;
    return N;
  }

  
  /// getCXXNameType - If this name is one of the C++ names (of a
  /// constructor, destructor, or conversion function), return the
  /// type associated with that name.
  
  /// getCXXNameType - If this name is one of the C++ names (of a
  /// constructor, destructor, or conversion function), return the
  /// type associated with that name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getCXXNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 276,
   FQN="clang::DeclarationName::getCXXNameType", NM="_ZNK5clang15DeclarationName14getCXXNameTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName14getCXXNameTypeEv")
  //</editor-fold>
  public QualType getCXXNameType() /*const*/ {
    {
      CXXSpecialName /*P*/ CXXName = getAsCXXSpecialName();
      if ((CXXName != null)) {
        return new QualType(CXXName.Type);
      } else {
        return new QualType();
      }
    }
  }


  
  /// getCXXOverloadedOperator - If this name is the name of an
  /// overloadable operator in C++ (e.g., @c operator+), retrieve the
  /// kind of overloaded operator.
  
  /// getCXXOverloadedOperator - If this name is the name of an
  /// overloadable operator in C++ (e.g., @c operator+), retrieve the
  /// kind of overloaded operator.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getCXXOverloadedOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 283,
   FQN="clang::DeclarationName::getCXXOverloadedOperator", NM="_ZNK5clang15DeclarationName24getCXXOverloadedOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName24getCXXOverloadedOperatorEv")
  //</editor-fold>
  public OverloadedOperatorKind getCXXOverloadedOperator() /*const*/ {
    {
      CXXOperatorIdName /*P*/ CXXOp = getAsCXXOperatorIdName();
      if ((CXXOp != null)) {
        /*uint*/int value = CXXOp.ExtraKindOrNumArgs - DeclarationNameExtra.ExtraKind.CXXConversionFunction.getValue();
        return /*static_cast*/OverloadedOperatorKind.valueOf(value);
      } else {
        return OverloadedOperatorKind.OO_None;
      }
    }
  }


  
  /// getCXXLiteralIdentifier - If this name is the name of a literal
  /// operator, retrieve the identifier associated with it.
  
  /// getCXXLiteralIdentifier - If this name is the name of a literal
  /// operator, retrieve the identifier associated with it.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getCXXLiteralIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 293,
   FQN="clang::DeclarationName::getCXXLiteralIdentifier", NM="_ZNK5clang15DeclarationName23getCXXLiteralIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName23getCXXLiteralIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getCXXLiteralIdentifier() /*const*/ {
    {
      CXXLiteralOperatorIdName /*P*/ CXXLit = getAsCXXLiteralOperatorIdName();
      if ((CXXLit != null)) {
        return CXXLit.ID;
      } else {
        return null;
      }
    }
  }


  
  /// getObjCSelector - Get the Objective-C selector stored in this
  /// declaration name.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getObjCSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 266,
   FQN="clang::DeclarationName::getObjCSelector", NM="_ZNK5clang15DeclarationName15getObjCSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang15DeclarationName15getObjCSelectorEv")
  //</editor-fold>
  public Selector getObjCSelector() /*const*/ {
    assert ((getNameKind() == NameKind.ObjCZeroArgSelector || getNameKind() == NameKind.ObjCOneArgSelector || getNameKind() == NameKind.ObjCMultiArgSelector || 
            ($Ptr == null && $PtrBits == 0))) : "Not a selector!";
    return new Selector(new std.pairPtrUChar($Ptr, $PtrBits));
  }

  
  /// getFETokenInfo/setFETokenInfo - The language front-end is
  /// allowed to associate arbitrary metadata with some kinds of
  /// declaration names, including normal identifiers and C++
  /// constructors, destructors, and conversion functions.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getFETokenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 279,
   FQN="clang::DeclarationName::getFETokenInfo", NM="Tpl__ZNK5clang15DeclarationName14getFETokenInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=Tpl__ZNK5clang15DeclarationName14getFETokenInfoEv")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ getFETokenInfo() /*const*/ {
    {
      /*const*/ IdentifierInfo /*P*/ Info = getAsIdentifierInfo();
      if ((Info != null)) {
        return Info.<T>getFETokenInfo();
      }
    }
    return ((/*static_cast*/T /*P*/ )(getFETokenInfoAsVoidSlow()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::setFETokenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 321,
   FQN="clang::DeclarationName::setFETokenInfo", NM="_ZN5clang15DeclarationName14setFETokenInfoEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang15DeclarationName14setFETokenInfoEPv")
  //</editor-fold>
  public void setFETokenInfo(Object/*void P*/ T) {
    switch (getNameKind()) {
     case Identifier:
      getAsIdentifierInfo().setFETokenInfo(T);
      break;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      getAsCXXSpecialName().FETokenInfo = T;
      break;
     case CXXOperatorName:
      getAsCXXOperatorIdName().FETokenInfo = T;
      break;
     case CXXLiteralOperatorName:
      getAsCXXLiteralOperatorIdName().FETokenInfo = T;
      break;
     default:
      throw new llvm_unreachable("Declaration name has no FETokenInfo");
    }
  }


  
  /// operator== - Determine whether the specified names are identical..
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 288,
   FQN="clang::operator==", NM="_ZN5clangeqENS_15DeclarationNameES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clangeqENS_15DeclarationNameES0_")
  //</editor-fold>
  public static boolean $eq_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
    return LHS.$Ptr == RHS.$Ptr && LHS.$PtrBits == RHS.$PtrBits;
  }

  
  /// operator!= - Determine whether the specified names are different.
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 293,
   FQN="clang::operator!=", NM="_ZN5clangneENS_15DeclarationNameES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clangneENS_15DeclarationNameES0_")
  //</editor-fold>
  public static boolean $noteq_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
    return !$eq_DeclarationName(LHS, RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getEmptyMarker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 297,
   FQN="clang::DeclarationName::getEmptyMarker", NM="_ZN5clang15DeclarationName14getEmptyMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationName14getEmptyMarkerEv")
  //</editor-fold>
  public static DeclarationName getEmptyMarker() {
    return new DeclarationName(((Object/*uintptr_t*/)(null)), $uchar2uint((byte)-1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::getTombstoneMarker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 301,
   FQN="clang::DeclarationName::getTombstoneMarker", NM="_ZN5clang15DeclarationName18getTombstoneMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationName18getTombstoneMarkerEv")
  //</editor-fold>
  public static DeclarationName getTombstoneMarker() {
    return new DeclarationName(((Object/*uintptr_t*/)(null)), $uchar2uint((byte)-2));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::compare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 80,
   FQN="clang::DeclarationName::compare", NM="_ZN5clang15DeclarationName7compareES0_S0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang15DeclarationName7compareES0_S0_")
  //</editor-fold>
  public static int compare(DeclarationName LHS, DeclarationName RHS) {
    if (LHS.getNameKind() != RHS.getNameKind()) {
      return (LHS.getNameKind().getValue() < RHS.getNameKind().getValue() ? -1 : 1);
    }
    switch (LHS.getNameKind()) {
     case Identifier:
      {
        IdentifierInfo /*P*/ LII = LHS.getAsIdentifierInfo();
        IdentifierInfo /*P*/ RII = RHS.getAsIdentifierInfo();
        if (!(LII != null)) {
          return (RII != null) ? -1 : 0;
        }
        if (!(RII != null)) {
          return 1;
        }
        
        return LII.getName().compare(RII.getName());
      }
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      {
        Selector LHSSelector = LHS.getObjCSelector();
        Selector RHSSelector = RHS.getObjCSelector();
        /*uint*/int LN = LHSSelector.getNumArgs(), RN = RHSSelector.getNumArgs();
        for (/*uint*/int I = 0, N = std.min_uint(LN, RN); I != N; ++I) {
          switch (LHSSelector.getNameForSlot(I).compare(RHSSelector.getNameForSlot(I))) {
           case -1:
            return /*true*/1;
           case 1:
            return /*false*/0;
           default:
            break;
          }
        }
        
        return compareInt(LN, RN);
      }
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      if (new QualTypeOrdering().$call(LHS.getCXXNameType(), RHS.getCXXNameType())) {
        return -1;
      }
      if (new QualTypeOrdering().$call(RHS.getCXXNameType(), LHS.getCXXNameType())) {
        return 1;
      }
      return 0;
     case CXXOperatorName:
      return compareInt(LHS.getCXXOverloadedOperator().getValue(), 
          RHS.getCXXOverloadedOperator().getValue());
     case CXXLiteralOperatorName:
      return LHS.getCXXLiteralIdentifier().getName().compare(RHS.getCXXLiteralIdentifier().getName());
     case CXXUsingDirective:
      return 0;
    }
    throw new llvm_unreachable("Invalid DeclarationName Kind!");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 155,
   FQN="clang::DeclarationName::print", NM="_ZN5clang15DeclarationName5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang15DeclarationName5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) {
    final DeclarationName /*&*/ N = /*Deref*/this;
    switch (N.getNameKind()) {
     case Identifier:
      {
        /*const*/ IdentifierInfo /*P*/ II = N.getAsIdentifierInfo();
        if ((II != null)) {
          OS.$out(II.getName());
        }
      }
      return;
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      N.getObjCSelector().print(OS);
      return;
     case CXXConstructorName:
      printCXXConstructorDestructorName(N.getCXXNameType(), OS, new PrintingPolicy(Policy));
      return;
     case CXXDestructorName:
      {
        OS.$out_char($$TILDE);
        printCXXConstructorDestructorName(N.getCXXNameType(), OS, new PrintingPolicy(Policy));
        return;
      }
     case CXXOperatorName:
      {
        final/*static*/ /*const*/char$ptr/*char P*//*const*/ OperatorNames[/*45*/] = print$$.OperatorNames;
        /*const*/char$ptr/*char P*/ OpName = $tryClone(OperatorNames[N.getCXXOverloadedOperator().getValue()]);
        assert ((OpName != null)) : "not an overloaded operator";
        
        OS.$out(/*KEEP_STR*/$operator);
        if (OpName.$at(0) >= $$a && OpName.$at(0) <= $$z) {
          OS.$out_char($$SPACE);
        }
        OS.$out(OpName);
        return;
      }
     case CXXLiteralOperatorName:
      OS.$out(/*KEEP_STR*/"operator\"\"").$out(N.getCXXLiteralIdentifier().getName());
      return;
     case CXXConversionFunctionName:
      {
        OS.$out(/*KEEP_STR*/"operator ");
        QualType Type = N.getCXXNameType();
        {
          /*const*/ RecordType /*P*/ Rec = Type.$arrow().<RecordType>getAs$RecordType();
          if ((Rec != null)) {
            $out_raw_ostream_NamedDecl$C(OS, $Deref(Rec.getDecl()));
            return;
          }
        }
        // We know we're printing C++ here, ensure we print 'bool' properly.
        PrintingPolicy CXXPolicy = new PrintingPolicy(Policy);
        CXXPolicy.adjustForCPlusPlus();
        Type.print(OS, CXXPolicy);
        return;
      }
     case CXXUsingDirective:
      OS.$out(/*KEEP_STR*/"<using-directive>");
      return;
    }
    throw new llvm_unreachable("Unexpected declaration name kind");
  }
  private static final class print$$ {
    static final/*static*/ /*const*/char$ptr/*char P*//*const*/ OperatorNames[/*45*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*45*/] {
    (/*const*/char$ptr/*char P*//*const*/)null, 
    $new, 
    $delete, 
    $new_LSQUARE_RSQUARE, 
    $delete_LSQUARE_RSQUARE, 
    $PLUS, 
    $MINUS, 
    $STAR, 
    $SLASH, 
    $PERCENT, 
    $CARET, 
    $AMP, 
    $PIPE, 
    $TILDE, 
    $EXCLAIM, 
    $EQ, 
    $LT, 
    $GT, 
    $PLUS_EQ, 
    $MINUS_EQ, 
    $STAR_EQ, 
    $SLASH_EQ, 
    $PERCENT_EQ, 
    $CARET_EQ, 
    $AMP_EQ, 
    $PIPE_EQ, 
    $LT_LT, 
    $GT_GT, 
    $LT_LT_EQ, 
    $GT_GT_EQ, 
    $EQ_EQ, 
    $EXCLAIM_EQ, 
    $LT_EQ, 
    $GT_EQ, 
    $AMP_AMP, 
    $PIPE_PIPE, 
    $PLUS_PLUS, 
    $MINUS_MINUS, 
    $COMMA, 
    $ARROW_STAR, 
    $ARROW, 
    $LPAREN_RPAREN, 
    $LSQUARE_RSQUARE, 
    // ?: can *not* be overloaded, but we need the overload
    // resolution machinery for it.
    $QMARK, 
    $co_await
  });
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 357,
   FQN="clang::DeclarationName::dump", NM="_ZNK5clang15DeclarationName4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZNK5clang15DeclarationName4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    $out_raw_ostream_DeclarationName(llvm.errs(), /*NO_COPY*//*Deref*/this).$out_char($$LF);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 48,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclarationName(final /*const*/ DeclarationName /*&*/ $Prm0) {
    // : Ptr(.Ptr) 
    //START JInit
    this.$Ptr = $Prm0.$Ptr;
    this.$PtrBits = $Prm0.$PtrBits;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::DeclarationName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 48,
   FQN="clang::DeclarationName::DeclarationName", NM="_ZN5clang15DeclarationNameC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameC1EOS0_")
  //</editor-fold>
  /*friend*/public /*inline*/ DeclarationName(JD$Move _dparam, final DeclarationName /*&&*/$Prm0) {
    // : Ptr(static_cast<DeclarationName &&>().Ptr) 
    //START JInit
    this.$Ptr = $Prm0.$Ptr;
    this.$PtrBits = $Prm0.$PtrBits;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 48,
   FQN="clang::DeclarationName::operator=", NM="_ZN5clang15DeclarationNameaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameaSERKS0_")
  //</editor-fold>
  public /*inline*/ DeclarationName /*&*/ $assign(final /*const*/ DeclarationName /*&*/ $Prm0) {
    this.$Ptr = $Prm0.$Ptr;
    this.$PtrBits = $Prm0.$PtrBits;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationName::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use Ptr & PtrBits*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 48,
   FQN="clang::DeclarationName::operator=", NM="_ZN5clang15DeclarationNameaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang15DeclarationNameaSEOS0_")
  //</editor-fold>
  public /*inline*/ DeclarationName /*&*/ $assignMove(final DeclarationName /*&&*/$Prm0) {
    this.$Ptr = $Prm0.$Ptr;
    this.$PtrBits = $Prm0.$PtrBits;
    $Prm0.$Ptr = null;
    $Prm0.$PtrBits = 0;
    return /*Deref*/this;
  }

  @Override public DeclarationName clone() { return new DeclarationName(this.$Ptr, $uchar2uint(this.$PtrBits)); }
  
  @Override public int $hashcode() { return DenseMapInfoPair.combineTwoHashes(System.identityHashCode(this.$Ptr), this.$PtrBits); }

  @Override
  public boolean $less(Object obj) {
    return compare(this, (DeclarationName) obj) < 0;
  }

  public static final DeclarationName DEFAULT = new DeclarationName();
  
  public static final Comparator<DeclarationName> COMPARATOR = new Comparator<DeclarationName>() {
    @Override
    public int compare(DeclarationName o1, DeclarationName o2) {
      if (o1.$less(o2)) {
        return -1;
      } else if (o2.$less(o1)) {
        return 1;
      }
      return 0;
    }
  };
  
  @Override public String toString() {
    return "" + "Ptr=" + $Ptr + "; Bits = " + $uchar2uint($PtrBits); // NOI18N
  }
}
