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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;


/// DeclarationNameTable - Used to store and retrieve DeclarationName
/// instances for the various kinds of declaration names, e.g., normal
/// identifiers, C++ constructor names, etc. This class contains
/// uniqued versions of each of the C++ special names, which can be
/// retrieved using its member functions (e.g.,
/// getCXXConstructorName).
//<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 344,
 FQN="clang::DeclarationNameTable", NM="_ZN5clang20DeclarationNameTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTableE")
//</editor-fold>
public class DeclarationNameTable implements Destructors.ClassWithDestructor {
  private final /*const*/ ASTContext /*&*/ Ctx;
  private Object/*void P*/ CXXSpecialNamesImpl; // Actually a FoldingSet<CXXSpecialName> *
  private final CXXOperatorIdName /*P*/ CXXOperatorNames[]; // Operator names
  private Object/*void P*/ CXXLiteralOperatorNames; // Actually a CXXOperatorIdName*
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::DeclarationNameTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 350,
   FQN="clang::DeclarationNameTable::DeclarationNameTable", NM="_ZN5clang20DeclarationNameTableC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTableC1ERKS0_")
  //</editor-fold>
  private DeclarationNameTable(final /*const*/ DeclarationNameTable /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 351,
   FQN="clang::DeclarationNameTable::operator=", NM="_ZN5clang20DeclarationNameTableaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTableaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ DeclarationNameTable /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::DeclarationNameTable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 361,
   FQN="clang::DeclarationNameTable::DeclarationNameTable", NM="_ZN5clang20DeclarationNameTableC1ERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTableC1ERKNS_10ASTContextE")
  //</editor-fold>
  public DeclarationNameTable(final /*const*/ ASTContext /*&*/ C) {
    // : Ctx(C) 
    //START JInit
    this./*&*/Ctx=/*&*/C;
    //END JInit
    CXXSpecialNamesImpl = new FoldingSet<CXXSpecialName>(CXXSpecialName.$Trait());
    CXXLiteralOperatorNames = new FoldingSet<CXXLiteralOperatorIdName>(CXXLiteralOperatorIdName.$Trait());
    
    // Initialize the overloaded operator names.
    CXXOperatorNames = /*FIXME:*//*new (Ctx)*/ new CXXOperatorIdName [OverloadedOperatorKind.NUM_OVERLOADED_OPERATORS.getValue()];
    for (/*uint*/int Op = 0; $less_uint(Op, OverloadedOperatorKind.NUM_OVERLOADED_OPERATORS.getValue()); ++Op) {
      CXXOperatorNames[Op] = new CXXOperatorIdName();
      CXXOperatorNames[Op].ExtraKindOrNumArgs
         = Op + DeclarationNameExtra.ExtraKind.CXXConversionFunction.getValue();
      CXXOperatorNames[Op].FETokenInfo = null;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::~DeclarationNameTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 374,
   FQN="clang::DeclarationNameTable::~DeclarationNameTable", NM="_ZN5clang20DeclarationNameTableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTableD0Ev")
  //</editor-fold>
  public void $destroy() {
    FoldingSet<CXXSpecialName> /*P*/ SpecialNames = ((/*static_cast*/FoldingSet<CXXSpecialName> /*P*/)(CXXSpecialNamesImpl));
    FoldingSet<CXXLiteralOperatorIdName> /*P*/ LiteralNames = ((/*static_cast*/FoldingSet<CXXLiteralOperatorIdName> /*P*/)(CXXLiteralOperatorNames));
    
    if (SpecialNames != null) { SpecialNames.$destroy();};
    if (LiteralNames != null) { LiteralNames.$destroy();};
  }

  
  /// getIdentifier - Create a declaration name that is a simple
  /// identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 359,
   FQN="clang::DeclarationNameTable::getIdentifier", NM="_ZN5clang20DeclarationNameTable13getIdentifierEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTable13getIdentifierEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public DeclarationName getIdentifier(/*const*/ IdentifierInfo /*P*/ ID) {
    return new DeclarationName(ID);
  }

  
  /// getCXXConstructorName - Returns the name of a C++ constructor
  /// for the given Type.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::getCXXConstructorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 385,
   FQN="clang::DeclarationNameTable::getCXXConstructorName", NM="_ZN5clang20DeclarationNameTable21getCXXConstructorNameENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTable21getCXXConstructorNameENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public DeclarationName getCXXConstructorName(CanQual<Type> Ty) {
    return getCXXSpecialName(DeclarationName.NameKind.CXXConstructorName, 
        Ty.getUnqualifiedType());
  }

  
  /// getCXXDestructorName - Returns the name of a C++ destructor
  /// for the given Type.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::getCXXDestructorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 390,
   FQN="clang::DeclarationNameTable::getCXXDestructorName", NM="_ZN5clang20DeclarationNameTable20getCXXDestructorNameENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTable20getCXXDestructorNameENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public DeclarationName getCXXDestructorName(CanQual<Type> Ty) {
    return getCXXSpecialName(DeclarationName.NameKind.CXXDestructorName, 
        Ty.getUnqualifiedType());
  }

  
  /// getCXXConversionFunctionName - Returns the name of a C++
  /// conversion function for the given Type.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::getCXXConversionFunctionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 395,
   FQN="clang::DeclarationNameTable::getCXXConversionFunctionName", NM="_ZN5clang20DeclarationNameTable28getCXXConversionFunctionNameENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTable28getCXXConversionFunctionNameENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public DeclarationName getCXXConversionFunctionName(CanQual<Type> Ty) {
    return getCXXSpecialName(DeclarationName.NameKind.CXXConversionFunctionName, new CanQual<Type>(Ty));
  }

  
  /// getCXXSpecialName - Returns a declaration name for special kind
  /// of C++ name, e.g., for a constructor, destructor, or conversion
  /// function.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::getCXXSpecialName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use JD$Private*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 400,
   FQN="clang::DeclarationNameTable::getCXXSpecialName", NM="_ZN5clang20DeclarationNameTable17getCXXSpecialNameENS_15DeclarationName8NameKindENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTable17getCXXSpecialNameENS_15DeclarationName8NameKindENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public DeclarationName getCXXSpecialName(DeclarationName.NameKind Kind, 
                   CanQual<Type> Ty) {
    FoldingSetNodeID ID = null;
    try {
      assert (Kind.getValue() >= DeclarationName.NameKind.CXXConstructorName.getValue() && Kind.getValue() <= DeclarationName.NameKind.CXXConversionFunctionName.getValue()) : "Kind must be a C++ special name kind";
      FoldingSet<CXXSpecialName> /*P*/ SpecialNames = ((/*static_cast*/FoldingSet<CXXSpecialName> /*P*/)(CXXSpecialNamesImpl));
      
      DeclarationNameExtra.ExtraKind EKind;
      switch (Kind) {
       case CXXConstructorName:
        EKind = DeclarationNameExtra.ExtraKind.CXXConstructor;
        assert (!Ty.hasQualifiers()) : "Constructor type must be unqualified";
        break;
       case CXXDestructorName:
        EKind = DeclarationNameExtra.ExtraKind.CXXDestructor;
        assert (!Ty.hasQualifiers()) : "Destructor type must be unqualified";
        break;
       case CXXConversionFunctionName:
        EKind = DeclarationNameExtra.ExtraKind.CXXConversionFunction;
        break;
       default:
        return new DeclarationName();
      }
      
      // Unique selector, to guarantee there is one per name.
      ID/*J*/= new FoldingSetNodeID();
      ID.AddInteger_int(EKind.getValue());
      ID.AddPointer(Ty.getAsOpaquePtr());
      
      final type$ref<type$ptr<CXXSpecialName /*P*/>/*void P*/> InsertPos = create_type$ref(null);
      {
        CXXSpecialName /*P*/ Name = SpecialNames.FindNodeOrInsertPos(ID, InsertPos);
        if ((Name != null)) {
          return new DeclarationName(JD$Private.INSTANCE, Name);
        }
      }
      
      CXXSpecialName /*P*/ SpecialName = /*FIXME:*//*new (Ctx)*/ new CXXSpecialName();
      SpecialName.ExtraKindOrNumArgs = EKind.getValue();
      SpecialName.Type.$assignMove(Ty.$QualType());
      SpecialName.FETokenInfo = null;
      
      SpecialNames.InsertNode(SpecialName, InsertPos.$deref());
      return new DeclarationName(JD$Private.INSTANCE, SpecialName);
    } finally {
      if (ID != null) { ID.$destroy(); }
    }
  }

  
  /// getCXXOperatorName - Get the name of the overloadable C++
  /// operator corresponding to Op.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::getCXXOperatorName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use JD$Private*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 444,
   FQN="clang::DeclarationNameTable::getCXXOperatorName", NM="_ZN5clang20DeclarationNameTable18getCXXOperatorNameENS_22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTable18getCXXOperatorNameENS_22OverloadedOperatorKindE")
  //</editor-fold>
  public DeclarationName getCXXOperatorName(OverloadedOperatorKind Op) {
    return new DeclarationName(JD$Private.INSTANCE, $AddrOf(CXXOperatorNames[(/*uint*/int)Op.getValue()]));
  }

  
  /// getCXXLiteralOperatorName - Get the name of the literal operator function
  /// with II as the identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclarationNameTable::getCXXLiteralOperatorName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use JD$Private*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 449,
   FQN="clang::DeclarationNameTable::getCXXLiteralOperatorName", NM="_ZN5clang20DeclarationNameTable25getCXXLiteralOperatorNameEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clang20DeclarationNameTable25getCXXLiteralOperatorNameEPNS_14IdentifierInfoE")
  //</editor-fold>
  public DeclarationName getCXXLiteralOperatorName(IdentifierInfo /*P*/ II) {
    FoldingSetNodeID ID = null;
    try {
      FoldingSet<CXXLiteralOperatorIdName> /*P*/ LiteralNames = ((/*static_cast*/FoldingSet<CXXLiteralOperatorIdName> /*P*/)(CXXLiteralOperatorNames));
      
      ID/*J*/= new FoldingSetNodeID();
      ID.AddPointer(II);
      
      final type$ref<type$ptr<CXXLiteralOperatorIdName /*P*/>/*void P*/> InsertPos = create_type$ref(null);
      {
        CXXLiteralOperatorIdName /*P*/ Name = LiteralNames.FindNodeOrInsertPos(ID, InsertPos);
        if ((Name != null)) {
          return new DeclarationName(JD$Private.INSTANCE, Name);
        }
      }
      
      CXXLiteralOperatorIdName /*P*/ LiteralName = /*FIXME:*//*new (Ctx)*/ new CXXLiteralOperatorIdName();
      LiteralName.ExtraKindOrNumArgs = DeclarationNameExtra.ExtraKind.CXXLiteralOperator.getValue();
      LiteralName.ID = II;
      LiteralName.FETokenInfo = null;
      
      LiteralNames.InsertNode(LiteralName, InsertPos.$deref());
      return new DeclarationName(JD$Private.INSTANCE, LiteralName);
    } finally {
      if (ID != null) { ID.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", CXXSpecialNamesImpl=" + CXXSpecialNamesImpl // NOI18N
              + ", CXXOperatorNames=" + CXXOperatorNames // NOI18N
              + ", CXXLiteralOperatorNames=" + CXXLiteralOperatorNames; // NOI18N
  }
}
