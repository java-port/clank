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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.ASTContextGlobals.*;


/// Base class for declarations which introduce a typedef-name.
//<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2609,
 FQN="clang::TypedefNameDecl", NM="_ZN5clang15TypedefNameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDeclE")
//</editor-fold>
public class TypedefNameDecl extends /*public*/ TypeDecl implements /*public*/ Redeclarable<TypedefNameDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4135,
   FQN="clang::TypedefNameDecl::anchor", NM="_ZN5clang15TypedefNameDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /*typedef std::pair<TypeSourceInfo *, QualType> ModedTInfo*/
//  public final class ModedTInfo extends std.pair<TypeSourceInfo /*P*/ , QualType>{ };
  private PointerUnion<TypeSourceInfo /*P*/ , std.pair<TypeSourceInfo /*P*/ , QualType> /*P*/ > MaybeModedTInfo;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::TypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2615,
   FQN="clang::TypedefNameDecl::TypedefNameDecl", NM="_ZN5clang15TypedefNameDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  protected TypedefNameDecl(Kind DK, final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation StartLoc, SourceLocation IdLoc, 
      IdentifierInfo /*P*/ Id, TypeSourceInfo /*P*/ TInfo) {
    // : TypeDecl(DK, DC, IdLoc, Id, StartLoc), redeclarable_base(C), MaybeModedTInfo(TInfo) 
    //START JInit
    super(DK, DC, new SourceLocation(IdLoc), Id, new SourceLocation(StartLoc));
    this.Redeclarable$Flds = $Redeclarable(C);
    this.MaybeModedTInfo = new PointerUnion<TypeSourceInfo /*P*/ , std.pair<TypeSourceInfo /*P*/ , QualType> /*P*/ >(JD$T.INSTANCE, TypeSourceInfo /*P*/.class, TInfo);
    //END JInit
  }

  
  /*typedef Redeclarable<TypedefNameDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<TypedefNameDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2622,
   FQN="clang::TypedefNameDecl::getNextRedeclarationImpl", NM="_ZN5clang15TypedefNameDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected TypedefNameDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2625,
   FQN="clang::TypedefNameDecl::getPreviousDeclImpl", NM="_ZN5clang15TypedefNameDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected TypedefNameDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2628,
   FQN="clang::TypedefNameDecl::getMostRecentDeclImpl", NM="_ZN5clang15TypedefNameDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected TypedefNameDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*public:*/
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<redecl_iterator>{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<TypedefNameDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<TypedefNameDecl>::redecls_begin;
  //JAVA: using Redeclarable<TypedefNameDecl>::redecls_end;
  //JAVA: using Redeclarable<TypedefNameDecl>::redecls;
  //JAVA: using Redeclarable<TypedefNameDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<TypedefNameDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<TypedefNameDecl>::isFirstDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::isModed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2642,
   FQN="clang::TypedefNameDecl::isModed", NM="_ZNK5clang15TypedefNameDecl7isModedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang15TypedefNameDecl7isModedEv")
  //</editor-fold>
  public boolean isModed() /*const*/ {
    return (MaybeModedTInfo.is(std.pair /*P*/.class) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2644,
   FQN="clang::TypedefNameDecl::getTypeSourceInfo", NM="_ZNK5clang15TypedefNameDecl17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang15TypedefNameDecl17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return isModed() ? (TypeSourceInfo)MaybeModedTInfo.get(std.pair /*P*/.class).first : MaybeModedTInfo.get(TypeSourceInfo /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getUnderlyingType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2649,
   FQN="clang::TypedefNameDecl::getUnderlyingType", NM="_ZNK5clang15TypedefNameDecl17getUnderlyingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang15TypedefNameDecl17getUnderlyingTypeEv")
  //</editor-fold>
  public QualType getUnderlyingType() /*const*/ {
    return isModed() ? new QualType((QualType)MaybeModedTInfo.get(std.pair /*P*/.class).second) : MaybeModedTInfo.get(TypeSourceInfo /*P*/.class).getType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::setTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2654,
   FQN="clang::TypedefNameDecl::setTypeSourceInfo", NM="_ZN5clang15TypedefNameDecl17setTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl17setTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeSourceInfo(TypeSourceInfo /*P*/ newType) {
    MaybeModedTInfo.$assign_T$C$R(TypeSourceInfo /*P*/ /*const*/ /*&*/.class, newType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::setModedTypeSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2657,
   FQN="clang::TypedefNameDecl::setModedTypeSourceInfo", NM="_ZN5clang15TypedefNameDecl22setModedTypeSourceInfoEPNS_14TypeSourceInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl22setModedTypeSourceInfoEPNS_14TypeSourceInfoENS_8QualTypeE")
  //</editor-fold>
  public void setModedTypeSourceInfo(TypeSourceInfo /*P*/ unmodedTSI, QualType modedTy) {
    ((PointerUnion)MaybeModedTInfo).$assign_T1$C$R(pair /*P*/ /*const*/ /*&*/.class, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (getASTContext())*/ $new_uint_ASTContext$C_uint(getASTContext(), (type$ptr<?> New$Mem)->{
            return new std.pairPtrType<TypeSourceInfo /*P*/ , QualType>(JD$T$RR_T1$RR.INSTANCE, unmodedTSI, modedTy);
         }));
  }

  
  /// Retrieves the canonical declaration of this typedef-name.
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2662,
   FQN="clang::TypedefNameDecl::getCanonicalDecl", NM="_ZN5clang15TypedefNameDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public TypedefNameDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2663,
   FQN="clang::TypedefNameDecl::getCanonicalDecl", NM="_ZNK5clang15TypedefNameDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang15TypedefNameDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ TypedefNameDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  /// Retrieves the tag declaration for which this is the typedef name for
  /// linkage purposes, if any.
  ///
  /// \param AnyRedecl Look for the tag declaration in any redeclaration of
  /// this typedef declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::getAnonDeclWithTypedefName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4137,
   FQN="clang::TypedefNameDecl::getAnonDeclWithTypedefName", NM="_ZNK5clang15TypedefNameDecl26getAnonDeclWithTypedefNameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang15TypedefNameDecl26getAnonDeclWithTypedefNameEb")
  //</editor-fold>
  public TagDecl /*P*/ getAnonDeclWithTypedefName() /*const*/ {
    return getAnonDeclWithTypedefName(false);
  }
  public TagDecl /*P*/ getAnonDeclWithTypedefName(boolean AnyRedecl/*= false*/) /*const*/ {
    {
      /*const*/ TagType /*P*/ TT = getTypeSourceInfo().getType().$arrow().getAs(TagType.class);
      if ((TT != null)) {
        TypedefNameDecl /*P*/ OwningTypedef = TT.getDecl().getTypedefNameForAnonDecl();
        /*const*/ TypedefNameDecl /*P*/ ThisTypedef = this;
        if (AnyRedecl && (OwningTypedef != null)) {
          OwningTypedef = OwningTypedef.getCanonicalDecl();
          ThisTypedef = ThisTypedef.getCanonicalDecl$Const();
        }
        if (OwningTypedef == ThisTypedef) {
          return TT.getDecl();
        }
      }
    }
    
    return null;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2673,
   FQN="clang::TypedefNameDecl::classof", NM="_ZN5clang15TypedefNameDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2674,
   FQN="clang::TypedefNameDecl::classofKind", NM="_ZN5clang15TypedefNameDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstTypedefName.getValue() && K.getValue() <= Kind.lastTypedefName.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypedefNameDecl::~TypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2609,
   FQN="clang::TypedefNameDecl::~TypedefNameDecl", NM="_ZN5clang15TypedefNameDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang15TypedefNameDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public final TypedefNameDecl getPreviousDecl() { 
    return (TypedefNameDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public final TypedefNameDecl getPreviousDecl$Const() { 
    return (TypedefNameDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public final TypedefNameDecl getMostRecentDecl() { 
    return (TypedefNameDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public final TypedefNameDecl getMostRecentDecl$Const() { 
    return (TypedefNameDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return "" + "MaybeModedTInfo=" + MaybeModedTInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
