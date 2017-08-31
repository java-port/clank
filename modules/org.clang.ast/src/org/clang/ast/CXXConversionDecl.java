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
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;

/// \brief Represents a C++ conversion function within a class.
///
/// For example:
///
/// \code
/// class X {
/// public:
///   operator bool();
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2461,
 FQN="clang::CXXConversionDecl", NM="_ZN5clang17CXXConversionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDeclE")
//</editor-fold>
public class CXXConversionDecl extends /*public*/ CXXMethodDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1993,
   FQN="clang::CXXConversionDecl::anchor", NM="_ZN5clang17CXXConversionDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /// Whether this conversion function declaration is marked
  /// "explicit", meaning that it can only be applied when the user
  /// explicitly wrote a cast. This is a C++11 feature.
  /*friend*/public /*JBIT bool*/ boolean IsExplicitSpecified /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::CXXConversionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2468,
   FQN="clang::CXXConversionDecl::CXXConversionDecl", NM="_ZN5clang17CXXConversionDeclC1ERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDeclC1ERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbS5_")
  //</editor-fold>
  private CXXConversionDecl(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, SourceLocation StartLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      QualType T, TypeSourceInfo /*P*/ TInfo, 
      boolean isInline, boolean isExplicitSpecified, 
      boolean isConstexpr, SourceLocation EndLocation) {
    // : CXXMethodDecl(CXXConversion, C, RD, StartLoc, NameInfo, T, TInfo, SC_None, isInline, isConstexpr, EndLocation), IsExplicitSpecified(isExplicitSpecified) 
    //START JInit
    super(Kind.CXXConversion, C, RD, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
        StorageClass.SC_None, isInline, isConstexpr, new SourceLocation(EndLocation));
    this.IsExplicitSpecified = isExplicitSpecified;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2003,
   FQN="clang::CXXConversionDecl::Create", NM="_ZN5clang17CXXConversionDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbbbS5_")
  //</editor-fold>
  public static CXXConversionDecl /*P*/ Create(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, 
        SourceLocation StartLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        boolean isInline, boolean isExplicit, 
        boolean isConstexpr, SourceLocation EndLocation) {
    assert (NameInfo.getName().getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName) : "Name must refer to a conversion function";
    return /*NEW_EXPR [Decl::new]*//*new (C, RD)*/ Decl.$new(C, RD, (type$ptr<?> Mem)->{
        return new CXXConversionDecl(C, RD, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
                isInline, isExplicit, isConstexpr, 
                new SourceLocation(EndLocation));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1995,
   FQN="clang::CXXConversionDecl::CreateDeserialized", NM="_ZN5clang17CXXConversionDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static CXXConversionDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new CXXConversionDecl(C, (CXXRecordDecl /*P*/ )null, new SourceLocation(), 
                new DeclarationNameInfo(), new QualType(), 
                (TypeSourceInfo /*P*/ )null, false, false, false, 
                new SourceLocation());
     });
  }

  
  /// Whether this conversion function declaration is marked
  /// "explicit", meaning that it can only be used for direct initialization
  /// (including explitly written casts).  This is a C++11 feature.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::isExplicitSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2490,
   FQN="clang::CXXConversionDecl::isExplicitSpecified", NM="_ZNK5clang17CXXConversionDecl19isExplicitSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang17CXXConversionDecl19isExplicitSpecifiedEv")
  //</editor-fold>
  public boolean isExplicitSpecified() /*const*/ {
    return IsExplicitSpecified;
  }

  
  /// \brief Whether this is an explicit conversion operator (C++11 and later).
  ///
  /// Explicit conversion operators are only considered for direct
  /// initialization, e.g., when the user has explicitly written a cast.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::isExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2496,
   FQN="clang::CXXConversionDecl::isExplicit", NM="_ZNK5clang17CXXConversionDecl10isExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang17CXXConversionDecl10isExplicitEv")
  //</editor-fold>
  public boolean isExplicit() /*const*/ {
    return cast_CXXConversionDecl(getFirstDecl$Const()).isExplicitSpecified();
  }

  
  /// \brief Returns the type that this conversion function is converting to.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::getConversionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2501,
   FQN="clang::CXXConversionDecl::getConversionType", NM="_ZNK5clang17CXXConversionDecl17getConversionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang17CXXConversionDecl17getConversionTypeEv")
  //</editor-fold>
  public QualType getConversionType() /*const*/ {
    return getType().$arrow().getAs(FunctionType.class).getReturnType();
  }

  
  /// \brief Determine whether this conversion function is a conversion from
  /// a lambda closure type to a block pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::isLambdaToBlockPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2018,
   FQN="clang::CXXConversionDecl::isLambdaToBlockPointerConversion", NM="_ZNK5clang17CXXConversionDecl32isLambdaToBlockPointerConversionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang17CXXConversionDecl32isLambdaToBlockPointerConversionEv")
  //</editor-fold>
  public boolean isLambdaToBlockPointerConversion() /*const*/ {
    return isImplicit() && getParent$Const().isLambda()
       && getConversionType().$arrow().isBlockPointerType();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2510,
   FQN="clang::CXXConversionDecl::classof", NM="_ZN5clang17CXXConversionDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2511,
   FQN="clang::CXXConversionDecl::classofKind", NM="_ZN5clang17CXXConversionDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.CXXConversion;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConversionDecl::~CXXConversionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2461,
   FQN="clang::CXXConversionDecl::~CXXConversionDecl", NM="_ZN5clang17CXXConversionDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXConversionDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "IsExplicitSpecified=" + IsExplicitSpecified // NOI18N
              + super.toString(); // NOI18N
  }
}
