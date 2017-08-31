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
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


/// Represents the declaration of an Objective-C type parameter.
///
/// \code
/// @interface NSDictionary<Key : id<NSCopying>, Value>
/// @end
/// \endcode
///
/// In the example above, both \c Key and \c Value are represented by
/// \c ObjCTypeParamDecl. \c Key has an explicit bound of \c id<NSCopying>,
/// while \c Value gets an implicit bound of \c id.
///
/// Objective-C type parameters are typedef-names in the grammar,
//<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 532,
 FQN="clang::ObjCTypeParamDecl", NM="_ZN5clang17ObjCTypeParamDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDeclE")
//</editor-fold>
public class ObjCTypeParamDecl extends /*public*/ TypedefNameDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCTypeParamDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1313,
   FQN="clang::ObjCTypeParamDecl::anchor", NM="_ZN5clang17ObjCTypeParamDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// Index of this type parameter in the type parameter list.
  /*friend*/public /*JCHAR unsigned int*/ char Index /*: 14*/;
  
  /// The variance of the type parameter.
  /*friend*/public /*JBYTE unsigned int*/ byte Variance /*: 2*/;
  
  /// The location of the variance, if any.
  /*friend*/public SourceLocation VarianceLoc;
  
  /// The location of the ':', which will be valid when the bound was
  /// explicitly specified.
  /*friend*/public SourceLocation ColonLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::ObjCTypeParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 548,
   FQN="clang::ObjCTypeParamDecl::ObjCTypeParamDecl", NM="_ZN5clang17ObjCTypeParamDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_21ObjCTypeParamVarianceENS_14SourceLocationEjS6_PNS_14IdentifierInfoES6_PNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_21ObjCTypeParamVarianceENS_14SourceLocationEjS6_PNS_14IdentifierInfoES6_PNS_14TypeSourceInfoE")
  //</editor-fold>
  private ObjCTypeParamDecl(final ASTContext /*&*/ ctx, DeclContext /*P*/ dc, 
      ObjCTypeParamVariance variance, SourceLocation varianceLoc, 
      /*uint*/int index, 
      SourceLocation nameLoc, IdentifierInfo /*P*/ name, 
      SourceLocation colonLoc, TypeSourceInfo /*P*/ boundInfo) {
    // : TypedefNameDecl(ObjCTypeParam, ctx, dc, nameLoc, nameLoc, name, boundInfo), Index(index), Variance(static_cast<unsigned int>(variance)), VarianceLoc(varianceLoc), ColonLoc(colonLoc) 
    //START JInit
    super(Kind.ObjCTypeParam, ctx, dc, new SourceLocation(nameLoc), new SourceLocation(nameLoc), name, 
        boundInfo);
    this.Index = $uint2uint_14bits(index);
    this.Variance = $uint2uint_2bits(((/*static_cast*//*uint*/int)variance.getValue()));
    this.VarianceLoc = new SourceLocation(varianceLoc);
    this.ColonLoc = new SourceLocation(colonLoc);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1315,
   FQN="clang::ObjCTypeParamDecl::Create", NM="_ZN5clang17ObjCTypeParamDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_21ObjCTypeParamVarianceENS_14SourceLocationEjS6_PNS_14IdentifierInfoES6_PNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_21ObjCTypeParamVarianceENS_14SourceLocationEjS6_PNS_14IdentifierInfoES6_PNS_14TypeSourceInfoE")
  //</editor-fold>
  public static ObjCTypeParamDecl /*P*/ Create(final ASTContext /*&*/ ctx, DeclContext /*P*/ dc, 
        ObjCTypeParamVariance variance, 
        SourceLocation varianceLoc, 
        /*uint*/int index, 
        SourceLocation nameLoc, 
        IdentifierInfo /*P*/ name, 
        SourceLocation colonLoc, 
        TypeSourceInfo /*P*/ boundInfo) {
    return /*NEW_EXPR [Decl::new]*//*new (ctx, dc)*/ Decl.$new(ctx, dc, (type$ptr<?> Mem)->{
        return new ObjCTypeParamDecl(ctx, dc, variance, new SourceLocation(varianceLoc), index, 
                new SourceLocation(nameLoc), name, new SourceLocation(colonLoc), boundInfo);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1327,
   FQN="clang::ObjCTypeParamDecl::CreateDeserialized", NM="_ZN5clang17ObjCTypeParamDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCTypeParamDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ ctx, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (ctx, ID)*/ Decl.$new(ctx, ID, (type$ptr<?> Mem)->{
        return new ObjCTypeParamDecl(ctx, (DeclContext /*P*/ )null, 
                ObjCTypeParamVariance.Invariant, 
                new SourceLocation(), 0, new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, new SourceLocation(), (TypeSourceInfo /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1335,
   FQN="clang::ObjCTypeParamDecl::getSourceRange", NM="_ZNK5clang17ObjCTypeParamDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation startLoc = new SourceLocation(VarianceLoc);
    if (startLoc.isInvalid()) {
      startLoc.$assignMove(getLocation());
    }
    if (hasExplicitBound()) {
      return new SourceRange(/*NO_COPY*/startLoc, 
          getTypeSourceInfo().getTypeLoc().getEndLoc());
    }
    
    return new SourceRange(/*NO_COPY*/startLoc);
  }

  
  /// Determine the variance of this type parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::getVariance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 572,
   FQN="clang::ObjCTypeParamDecl::getVariance", NM="_ZNK5clang17ObjCTypeParamDecl11getVarianceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamDecl11getVarianceEv")
  //</editor-fold>
  public ObjCTypeParamVariance getVariance() /*const*/ {
    return /*static_cast*/ObjCTypeParamVariance.valueOf(Variance);
  }

  
  /// Set the variance of this type parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::setVariance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 577,
   FQN="clang::ObjCTypeParamDecl::setVariance", NM="_ZN5clang17ObjCTypeParamDecl11setVarianceENS_21ObjCTypeParamVarianceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDecl11setVarianceENS_21ObjCTypeParamVarianceE")
  //</editor-fold>
  public void setVariance(ObjCTypeParamVariance variance) {
    Variance = $uint2uint_2bits(((/*static_cast*//*uint*/int)variance.getValue()));
  }

  
  /// Retrieve the location of the variance keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::getVarianceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 582,
   FQN="clang::ObjCTypeParamDecl::getVarianceLoc", NM="_ZNK5clang17ObjCTypeParamDecl14getVarianceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamDecl14getVarianceLocEv")
  //</editor-fold>
  public SourceLocation getVarianceLoc() /*const*/ {
    return new SourceLocation(VarianceLoc);
  }

  
  /// Retrieve the index into its type parameter list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 585,
   FQN="clang::ObjCTypeParamDecl::getIndex", NM="_ZNK5clang17ObjCTypeParamDecl8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamDecl8getIndexEv")
  //</editor-fold>
  public /*uint*/int getIndex() /*const*/ {
    return Index;
  }

  
  /// Whether this type parameter has an explicitly-written type bound, e.g.,
  /// "T : NSView".
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::hasExplicitBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 589,
   FQN="clang::ObjCTypeParamDecl::hasExplicitBound", NM="_ZNK5clang17ObjCTypeParamDecl16hasExplicitBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamDecl16hasExplicitBoundEv")
  //</editor-fold>
  public boolean hasExplicitBound() /*const*/ {
    return ColonLoc.isValid();
  }

  
  /// Retrieve the location of the ':' separating the type parameter name
  /// from the explicitly-specified bound.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 593,
   FQN="clang::ObjCTypeParamDecl::getColonLoc", NM="_ZNK5clang17ObjCTypeParamDecl11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCTypeParamDecl11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 596,
   FQN="clang::ObjCTypeParamDecl::classof", NM="_ZN5clang17ObjCTypeParamDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 597,
   FQN="clang::ObjCTypeParamDecl::classofKind", NM="_ZN5clang17ObjCTypeParamDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCTypeParam;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCTypeParamDecl::~ObjCTypeParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 532,
   FQN="clang::ObjCTypeParamDecl::~ObjCTypeParamDecl", NM="_ZN5clang17ObjCTypeParamDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCTypeParamDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Index=" + $ushort2uint(Index) // NOI18N
              + ", Variance=" + $uchar2uint(Variance) // NOI18N
              + ", VarianceLoc=" + VarianceLoc // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
