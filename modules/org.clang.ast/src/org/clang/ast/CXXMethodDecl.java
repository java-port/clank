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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.impl.DeclCXXStatics.*;


/// \brief Represents a static or instance method of a struct/union/class.
///
/// In the terminology of the C++ Standard, these are the (static and
/// non-static) member functions, whether virtual or not.
//<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1736,
 FQN="clang::CXXMethodDecl", NM="_ZN5clang13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDeclE")
//</editor-fold>
public class CXXMethodDecl extends /*public*/ FunctionDecl implements Destructors.ClassWithDestructor, org.clang.basic.java.CXXMethodDeclImplementation {
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1473,
   FQN="clang::CXXMethodDecl::anchor", NM="_ZN5clang13CXXMethodDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::CXXMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1739,
   FQN="clang::CXXMethodDecl::CXXMethodDecl", NM="_ZN5clang13CXXMethodDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbS7_")
  //</editor-fold>
  protected CXXMethodDecl(Kind DK, final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, 
      SourceLocation StartLoc, final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      QualType T, TypeSourceInfo /*P*/ TInfo, 
      StorageClass SC, boolean isInline, 
      boolean isConstexpr, SourceLocation EndLocation) {
    // : FunctionDecl(DK, C, RD, StartLoc, NameInfo, T, TInfo, SC, isInline, isConstexpr) 
    //START JInit
    super(DK, C, RD, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
        SC, isInline, isConstexpr);
    //END JInit
    if (EndLocation.isValid()) {
      setRangeEnd(new SourceLocation(EndLocation));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1539,
   FQN="clang::CXXMethodDecl::Create", NM="_ZN5clang13CXXMethodDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassEbbS5_")
  //</editor-fold>
  public static CXXMethodDecl /*P*/ Create(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, 
        SourceLocation StartLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        StorageClass SC, boolean isInline, 
        boolean isConstexpr, SourceLocation EndLocation) {
    return /*NEW_EXPR [Decl::new]*//*new (C, RD)*/ Decl.$new(C, RD, (type$ptr<?> Mem)->{
        return new CXXMethodDecl(Kind.CXXMethod, C, RD, new SourceLocation(StartLoc), NameInfo, 
                new QualType(T), TInfo, SC, isInline, isConstexpr, 
                new SourceLocation(EndLocation));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1551,
   FQN="clang::CXXMethodDecl::CreateDeserialized", NM="_ZN5clang13CXXMethodDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static CXXMethodDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new CXXMethodDecl(Kind.CXXMethod, C, (CXXRecordDecl /*P*/ )null, new SourceLocation(), 
                new DeclarationNameInfo(), new QualType(), (TypeSourceInfo /*P*/ )null, 
                StorageClass.SC_None, false, false, new SourceLocation());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isStatic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1475,
   FQN="clang::CXXMethodDecl::isStatic", NM="_ZNK5clang13CXXMethodDecl8isStaticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl8isStaticEv")
  //</editor-fold>
  public boolean isStatic() /*const*/ {
    /*const*/ CXXMethodDecl /*P*/ MD = getCanonicalDecl$Const();
    if (MD.getStorageClass() == StorageClass.SC_Static) {
      return true;
    }
    
    OverloadedOperatorKind OOK = getDeclName().getCXXOverloadedOperator();
    return isStaticOverloadedOperator(OOK);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1763,
   FQN="clang::CXXMethodDecl::isInstance", NM="_ZNK5clang13CXXMethodDecl10isInstanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl10isInstanceEv")
  //</editor-fold>
  public boolean isInstance() /*const*/ {
    return !isStatic();
  }

  
  /// Returns true if the given operator is implicitly static in a record
  /// context.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isStaticOverloadedOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1767,
   FQN="clang::CXXMethodDecl::isStaticOverloadedOperator", NM="_ZN5clang13CXXMethodDecl26isStaticOverloadedOperatorENS_22OverloadedOperatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl26isStaticOverloadedOperatorENS_22OverloadedOperatorKindE")
  //</editor-fold>
  public static boolean isStaticOverloadedOperator(OverloadedOperatorKind OOK) {
    // [class.free]p1:
    // Any allocation function for a class T is a static member
    // (even if not explicitly declared static).
    // [class.free]p6 Any deallocation function for a class X is a static member
    // (even if not explicitly declared static).
    return OOK == OverloadedOperatorKind.OO_New || OOK == OverloadedOperatorKind.OO_Array_New || OOK == OverloadedOperatorKind.OO_Delete
       || OOK == OverloadedOperatorKind.OO_Array_Delete;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1777,
   FQN="clang::CXXMethodDecl::isConst", NM="_ZNK5clang13CXXMethodDecl7isConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl7isConstEv")
  //</editor-fold>
  public boolean isConst() /*const*/ {
    return getType().$arrow().castAs(FunctionType.class).isConst();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1778,
   FQN="clang::CXXMethodDecl::isVolatile", NM="_ZNK5clang13CXXMethodDecl10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return getType().$arrow().castAs(FunctionType.class).isVolatile();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1780,
   FQN="clang::CXXMethodDecl::isVirtual", NM="_ZNK5clang13CXXMethodDecl9isVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl9isVirtualEv")
  //</editor-fold>
  public boolean isVirtual() /*const*/ {
    CXXMethodDecl /*P*/ CD = cast_CXXMethodDecl(((/*const_cast*/CXXMethodDecl /*P*/ )(this)).getCanonicalDecl());
    
    // Member function is virtual if it is marked explicitly so, or if it is
    // declared in __interface -- then it is automatically pure virtual.
    if (CD.isVirtualAsWritten() || CD.isPure()) {
      return true;
    }
    
    return ($noteq_ptr(CD.begin_overridden_methods(), CD.end_overridden_methods()));
  }

  
  /// \brief Determine whether this is a usual deallocation function
  /// (C++ [basic.stc.dynamic.deallocation]p2), which is an overloaded
  /// delete or delete[] operator with a particular signature.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isUsualDeallocationFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1557,
   FQN="clang::CXXMethodDecl::isUsualDeallocationFunction", NM="_ZNK5clang13CXXMethodDecl27isUsualDeallocationFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl27isUsualDeallocationFunctionEv")
  //</editor-fold>
  public boolean isUsualDeallocationFunction() /*const*/ {
    if (getOverloadedOperator() != OverloadedOperatorKind.OO_Delete
       && getOverloadedOperator() != OverloadedOperatorKind.OO_Array_Delete) {
      return false;
    }
    
    // C++ [basic.stc.dynamic.deallocation]p2:
    //   A template instance is never a usual deallocation function,
    //   regardless of its signature.
    if ((getPrimaryTemplate() != null)) {
      return false;
    }
    
    // C++ [basic.stc.dynamic.deallocation]p2:
    //   If a class T has a member deallocation function named operator delete 
    //   with exactly one parameter, then that function is a usual (non-placement)
    //   deallocation function. [...]
    if (getNumParams() == 1) {
      return true;
    }
    
    // C++ [basic.stc.dynamic.deallocation]p2:
    //   [...] If class T does not declare such an operator delete but does 
    //   declare a member deallocation function named operator delete with 
    //   exactly two parameters, the second of which has type std::size_t (18.1),
    //   then this function is a usual deallocation function.
    final ASTContext /*&*/ Context = getASTContext();
    if (getNumParams() != 2
       || !Context.hasSameUnqualifiedType(getParamDecl$Const(1).getType(), 
        Context.getSizeType().$QualType())) {
      return false;
    }
    
    // This function is a usual deallocation function if there are no 
    // single-parameter deallocation functions of the same kind.
    DeclContextLookupResult R = getDeclContext$Const().lookup(getDeclName());
    for (DeclContextLookupResult.iterator I = R.begin(), E = R.end();
         I.$noteq(E); I.$preInc()) {
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(I.$star());
        if ((FD != null)) {
          if (FD.getNumParams() == 1) {
            return false;
          }
        }
      }
    }
    
    return true;
  }

  
  /// \brief Determine whether this is a copy-assignment operator, regardless
  /// of whether it was declared implicitly or explicitly.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isCopyAssignmentOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1599,
   FQN="clang::CXXMethodDecl::isCopyAssignmentOperator", NM="_ZNK5clang13CXXMethodDecl24isCopyAssignmentOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl24isCopyAssignmentOperatorEv")
  //</editor-fold>
  public boolean isCopyAssignmentOperator() /*const*/ {
    // C++0x [class.copy]p17:
    //  A user-declared copy assignment operator X::operator= is a non-static 
    //  non-template member function of class X with exactly one parameter of 
    //  type X, X&, const X&, volatile X& or const volatile X&.
    if (/*operator=*/ getOverloadedOperator() != OverloadedOperatorKind.OO_Equal
      /*non-static*/  || isStatic()
      /*non-template*/  || (getPrimaryTemplate() != null) || (getDescribedFunctionTemplate() != null)
       || getNumParams() != 1) {
      return false;
    }
    
    QualType ParamType = getParamDecl$Const(0).getType();
    {
      /*const*/ LValueReferenceType /*P*/ Ref = ParamType.$arrow().getAs(LValueReferenceType.class);
      if ((Ref != null)) {
        ParamType.$assignMove(Ref.getPointeeType());
      }
    }
    
    final ASTContext /*&*/ Context = getASTContext();
    QualType ClassType = Context.getCanonicalType(Context.getTypeDeclType(getParent$Const())).$QualType();
    return Context.hasSameUnqualifiedType(new QualType(ClassType), new QualType(ParamType));
  }

  
  /// \brief Determine whether this is a move assignment operator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isMoveAssignmentOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1620,
   FQN="clang::CXXMethodDecl::isMoveAssignmentOperator", NM="_ZNK5clang13CXXMethodDecl24isMoveAssignmentOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl24isMoveAssignmentOperatorEv")
  //</editor-fold>
  public boolean isMoveAssignmentOperator() /*const*/ {
    // C++0x [class.copy]p19:
    //  A user-declared move assignment operator X::operator= is a non-static
    //  non-template member function of class X with exactly one parameter of type
    //  X&&, const X&&, volatile X&&, or const volatile X&&.
    if (getOverloadedOperator() != OverloadedOperatorKind.OO_Equal || isStatic()
       || (getPrimaryTemplate() != null) || (getDescribedFunctionTemplate() != null)
       || getNumParams() != 1) {
      return false;
    }
    
    QualType ParamType = getParamDecl$Const(0).getType();
    if (!isa_RValueReferenceType(ParamType)) {
      return false;
    }
    ParamType.$assignMove(ParamType.$arrow().getPointeeType());
    
    final ASTContext /*&*/ Context = getASTContext();
    QualType ClassType = Context.getCanonicalType(Context.getTypeDeclType(getParent$Const())).$QualType();
    return Context.hasSameUnqualifiedType(new QualType(ClassType), new QualType(ParamType));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1804,
   FQN="clang::CXXMethodDecl::getCanonicalDecl", NM="_ZN5clang13CXXMethodDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public CXXMethodDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_CXXMethodDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1807,
   FQN="clang::CXXMethodDecl::getCanonicalDecl", NM="_ZNK5clang13CXXMethodDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ CXXMethodDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/CXXMethodDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1811,
   FQN="clang::CXXMethodDecl::getMostRecentDecl", NM="_ZN5clang13CXXMethodDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl17getMostRecentDeclEv")
  //</editor-fold>
  public CXXMethodDecl /*P*/ getMostRecentDecl() {
    return cast_CXXMethodDecl(/*JCast:FunctionDecl * */super.getMostRecentDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1815,
   FQN="clang::CXXMethodDecl::getMostRecentDecl", NM="_ZNK5clang13CXXMethodDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ CXXMethodDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/CXXMethodDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  /// True if this method is user-declared and was not
  /// deleted or defaulted on its first declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isUserProvided">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1821,
   FQN="clang::CXXMethodDecl::isUserProvided", NM="_ZNK5clang13CXXMethodDecl14isUserProvidedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl14isUserProvidedEv")
  //</editor-fold>
  public boolean isUserProvided() /*const*/ {
    return !(isDeleted() || getCanonicalDecl$Const().isDefaulted());
  }

  
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::addOverriddenMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1641,
   FQN="clang::CXXMethodDecl::addOverriddenMethod", NM="_ZN5clang13CXXMethodDecl19addOverriddenMethodEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl19addOverriddenMethodEPKS0_")
  //</editor-fold>
  public void addOverriddenMethod(/*const*/ CXXMethodDecl /*P*/ MD) {
    assert (MD.isCanonicalDecl()) : "Method is not canonical!";
    assert (!MD.getParent$Const().isDependentContext()) : "Can't add an overridden method to a class template!";
    assert (MD.isVirtual()) : "Method is not virtual!";
    
    getASTContext().addOverriddenMethod(this, MD);
  }

  
  /*typedef const CXXMethodDecl *const *method_iterator*/
//  public final class method_iterator extends type$ptr</*const*/ CXXMethodDecl /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::begin_overridden_methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1650,
   FQN="clang::CXXMethodDecl::begin_overridden_methods", NM="_ZNK5clang13CXXMethodDecl24begin_overridden_methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl24begin_overridden_methodsEv")
  //</editor-fold>
  public type$ptr<CXXMethodDecl>/*method_iterator*/ begin_overridden_methods() /*const*/ {
    if (isa_CXXConstructorDecl(this)) {
      return null;
    }
    return getASTContext().overridden_methods_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::end_overridden_methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1655,
   FQN="clang::CXXMethodDecl::end_overridden_methods", NM="_ZNK5clang13CXXMethodDecl22end_overridden_methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl22end_overridden_methodsEv")
  //</editor-fold>
  public type$ptr<CXXMethodDecl>/*method_iterator*/ end_overridden_methods() /*const*/ {
    if (isa_CXXConstructorDecl(this)) {
      return null;
    }
    return getASTContext().overridden_methods_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::size_overridden_methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1660,
   FQN="clang::CXXMethodDecl::size_overridden_methods", NM="_ZNK5clang13CXXMethodDecl23size_overridden_methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl23size_overridden_methodsEv")
  //</editor-fold>
  public /*uint*/int size_overridden_methods() /*const*/ {
    if (isa_CXXConstructorDecl(this)) {
      return 0;
    }
    return getASTContext().overridden_methods_size(this);
  }

  /*typedef ASTContext::overridden_method_range overridden_method_range*/
//  public final class overridden_method_range extends iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::overridden_methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1665,
   FQN="clang::CXXMethodDecl::overridden_methods", NM="_ZNK5clang13CXXMethodDecl18overridden_methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl18overridden_methodsEv")
  //</editor-fold>
  public iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/> overridden_methods() /*const*/ {
    if (isa_CXXConstructorDecl(this)) {
      return new iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>((type$ptr</*const*/ CXXMethodDecl /*P*/ /*const*/ /*P*/>)null, (type$ptr</*const*/ CXXMethodDecl /*P*/ /*const*/ /*P*/>)null);
    }
    return getASTContext().overridden_methods(this);
  }

  
  /// Returns the parent of this method declaration, which
  /// is the class in which this method is defined.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1838,
   FQN="clang::CXXMethodDecl::getParent", NM="_ZNK5clang13CXXMethodDecl9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl9getParentEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getParent$Const() /*const*/ {
    return cast_CXXRecordDecl(super.getParent$Const());
  }

  
  /// Returns the parent of this method declaration, which
  /// is the class in which this method is defined.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1844,
   FQN="clang::CXXMethodDecl::getParent", NM="_ZN5clang13CXXMethodDecl9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl9getParentEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getParent() {
    return ((/*const_cast*/CXXRecordDecl /*P*/ )(cast_CXXRecordDecl(super.getParent())));
  }

  
  /// \brief Returns the type of the \c this pointer.
  ///
  /// Should only be called for instance (i.e., non-static) methods.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getThisType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1672,
   FQN="clang::CXXMethodDecl::getThisType", NM="_ZNK5clang13CXXMethodDecl11getThisTypeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl11getThisTypeERNS_10ASTContextE")
  //</editor-fold>
  public QualType getThisType(final ASTContext /*&*/ C) /*const*/ {
    // C++ 9.3.2p1: The type of this in a member function of a class X is X*.
    // If the member function is declared const, the type of this is const X*,
    // if the member function is declared volatile, the type of this is
    // volatile X*, and if the member function is declared const volatile,
    // the type of this is const volatile X*.
    assert (isInstance()) : "No 'this' for static methods!";
    
    QualType ClassTy = C.getTypeDeclType(getParent$Const());
    ClassTy.$assignMove(C.getQualifiedType(new QualType(ClassTy), 
            Qualifiers.fromCVRUMask(getTypeQualifiers())));
    return C.getPointerType(new QualType(ClassTy));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getTypeQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1854,
   FQN="clang::CXXMethodDecl::getTypeQualifiers", NM="_ZNK5clang13CXXMethodDecl17getTypeQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl17getTypeQualifiersEv")
  //</editor-fold>
  public /*uint*/int getTypeQualifiers() /*const*/ {
    return getType().$arrow().getAs(FunctionProtoType.class).getTypeQuals();
  }

  
  /// \brief Retrieve the ref-qualifier associated with this method.
  ///
  /// In the following example, \c f() has an lvalue ref-qualifier, \c g()
  /// has an rvalue ref-qualifier, and \c h() has no ref-qualifier.
  /// @code
  /// struct X {
  ///   void f() &;
  ///   void g() &&;
  ///   void h();
  /// };
  /// @endcode
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getRefQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1869,
   FQN="clang::CXXMethodDecl::getRefQualifier", NM="_ZNK5clang13CXXMethodDecl15getRefQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl15getRefQualifierEv")
  //</editor-fold>
  public RefQualifierKind getRefQualifier() /*const*/ {
    return getType().$arrow().getAs(FunctionProtoType.class).getRefQualifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::hasInlineBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1687,
   FQN="clang::CXXMethodDecl::hasInlineBody", NM="_ZNK5clang13CXXMethodDecl13hasInlineBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl13hasInlineBodyEv")
  //</editor-fold>
  public boolean hasInlineBody() /*const*/ {
    // If this function is a template instantiation, look at the template from 
    // which it was instantiated.
    /*const*/ FunctionDecl /*P*/ CheckFn = getTemplateInstantiationPattern();
    if (!(CheckFn != null)) {
      CheckFn = this;
    }
    
    type$ref</*const*/ FunctionDecl /*P*/ > fn = create_type$ref();
    return CheckFn.hasBody(fn) && !fn.$deref().isOutOfLine();
  }

  
  /// \brief Determine whether this is a lambda closure type's static member
  /// function that is used for the result of the lambda's conversion to
  /// function pointer (for a lambda with no captures).
  ///
  /// The function itself, if used, will have a placeholder body that will be
  /// supplied by IR generation to either forward to the function call operator
  /// or clone the function call operator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::isLambdaStaticInvoker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1698,
   FQN="clang::CXXMethodDecl::isLambdaStaticInvoker", NM="_ZNK5clang13CXXMethodDecl21isLambdaStaticInvokerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl21isLambdaStaticInvokerEv")
  //</editor-fold>
  public boolean isLambdaStaticInvoker() /*const*/ {
    /*const*/ CXXRecordDecl /*P*/ P = getParent$Const();
    if (P.isLambda()) {
      {
        /*const*/ CXXMethodDecl /*P*/ StaticInvoker = P.getLambdaStaticInvoker();
        if ((StaticInvoker != null)) {
          if (StaticInvoker == this) {
            return true;
          }
          if (P.isGenericLambda() && this.isFunctionTemplateSpecialization()) {
            return StaticInvoker == this.getPrimaryTemplate().getTemplatedDecl();
          }
        }
      }
    }
    return false;
  }

  
  /// \brief Find the method in \p RD that corresponds to this one.
  ///
  /// Find if \p RD or one of the classes it inherits from override this method.
  /// If so, return it. \p RD is assumed to be a subclass of the class defining
  /// this method (or be the class itself), unless \p MayBeBase is set to true.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getCorrespondingMethodInClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1498,
   FQN="clang::CXXMethodDecl::getCorrespondingMethodInClass", NM="_ZN5clang13CXXMethodDecl29getCorrespondingMethodInClassEPKNS_13CXXRecordDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl29getCorrespondingMethodInClassEPKNS_13CXXRecordDeclEb")
  //</editor-fold>
  public CXXMethodDecl /*P*/ getCorrespondingMethodInClass(/*const*/ CXXRecordDecl /*P*/ RD) {
    return getCorrespondingMethodInClass(RD, 
                               false);
  }
  public CXXMethodDecl /*P*/ getCorrespondingMethodInClass(/*const*/ CXXRecordDecl /*P*/ RD, 
                               boolean MayBeBase/*= false*/) {
    if (this.getParent().getCanonicalDecl() == RD.getCanonicalDecl$Const()) {
      return this;
    }
    
    // Lookup doesn't work for destructors, so handle them separately.
    if (isa_CXXDestructorDecl(this)) {
      CXXMethodDecl /*P*/ MD = RD.getDestructor();
      if ((MD != null)) {
        if (recursivelyOverrides(MD, this)) {
          return MD;
        }
        if (MayBeBase && recursivelyOverrides(this, MD)) {
          return MD;
        }
      }
      return null;
    }
    
    for (NamedDecl /*P*/ ND : RD.lookup(getDeclName())) {
      CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(ND);
      if (!(MD != null)) {
        continue;
      }
      if (recursivelyOverrides(MD, this)) {
        return MD;
      }
      if (MayBeBase && recursivelyOverrides(this, MD)) {
        return MD;
      }
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      /*const*/ RecordType /*P*/ RT = I.getType().$arrow().<RecordType>getAs$RecordType();
      if (!(RT != null)) {
        continue;
      }
      /*const*/ CXXRecordDecl /*P*/ Base = cast_CXXRecordDecl(RT.getDecl());
      CXXMethodDecl /*P*/ T = this.getCorrespondingMethodInClass(Base);
      if ((T != null)) {
        return T;
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::getCorrespondingMethodInClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1893,
   FQN="clang::CXXMethodDecl::getCorrespondingMethodInClass", NM="_ZNK5clang13CXXMethodDecl29getCorrespondingMethodInClassEPKNS_13CXXRecordDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXMethodDecl29getCorrespondingMethodInClassEPKNS_13CXXRecordDeclEb")
  //</editor-fold>
  public /*const*/ CXXMethodDecl /*P*/ getCorrespondingMethodInClass$Const(/*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    return getCorrespondingMethodInClass$Const(RD, 
                                     false);
  }
  public /*const*/ CXXMethodDecl /*P*/ getCorrespondingMethodInClass$Const(/*const*/ CXXRecordDecl /*P*/ RD, 
                                     boolean MayBeBase/*= false*/) /*const*/ {
    return ((/*const_cast*/CXXMethodDecl /*P*/ )(this)).
        getCorrespondingMethodInClass(RD, MayBeBase);
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1901,
   FQN="clang::CXXMethodDecl::classof", NM="_ZN5clang13CXXMethodDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1902,
   FQN="clang::CXXMethodDecl::classofKind", NM="_ZN5clang13CXXMethodDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstCXXMethod.getValue() && K.getValue() <= Kind.lastCXXMethod.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXMethodDecl::~CXXMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1736,
   FQN="clang::CXXMethodDecl::~CXXMethodDecl", NM="_ZN5clang13CXXMethodDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXMethodDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
