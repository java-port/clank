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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.impl.DeclStatics.*;


/// \brief Represents a ValueDecl that came out of a declarator.
/// Contains type source information through TypeSourceInfo.
//<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 646,
 FQN="clang::DeclaratorDecl", NM="_ZN5clang14DeclaratorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDeclE")
//</editor-fold>
public class DeclaratorDecl extends /*public*/ ValueDecl implements Destructors.ClassWithDestructor {
  // A struct representing both a TInfo and a syntactic qualifier,
  // to be used for the (uncommon) case of out-of-line declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::ExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 649,
   FQN="clang::DeclaratorDecl::ExtInfo", NM="_ZN5clang14DeclaratorDecl7ExtInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl7ExtInfoE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ ExtInfo extends /*public*/ QualifierInfo {
    public TypeSourceInfo /*P*/ TInfo;
    //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::ExtInfo::ExtInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 649,
     FQN="clang::DeclaratorDecl::ExtInfo::ExtInfo", NM="_ZN5clang14DeclaratorDecl7ExtInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl7ExtInfoC1Ev")
    //</editor-fold>
    public /*inline*/ ExtInfo() {
      // : QualifierInfo() 
      //START JInit
      super();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "TInfo=" + TInfo // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /*friend*/public PointerUnion<TypeSourceInfo /*P*/ , ExtInfo /*P*/ > DeclInfo;
  
  /// InnerLocStart - The start of the source range for this declaration,
  /// ignoring outer template declarations.
  private SourceLocation InnerLocStart;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::hasExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 659,
   FQN="clang::DeclaratorDecl::hasExtInfo", NM="_ZNK5clang14DeclaratorDecl10hasExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl10hasExtInfoEv")
  //</editor-fold>
  /*friend*/public boolean hasExtInfo() /*const*/ {
    return (DeclInfo.is(ExtInfo /*P*/.class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 660,
   FQN="clang::DeclaratorDecl::getExtInfo", NM="_ZN5clang14DeclaratorDecl10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl10getExtInfoEv")
  //</editor-fold>
  /*friend*/public ExtInfo /*P*/ getExtInfo() {
    return DeclInfo.get(ExtInfo /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 661,
   FQN="clang::DeclaratorDecl::getExtInfo", NM="_ZNK5clang14DeclaratorDecl10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl10getExtInfoEv")
  //</editor-fold>
  private /*const*/ ExtInfo /*P*/ getExtInfo$Const() /*const*/ {
    return DeclInfo.get(ExtInfo /*P*/.class);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::DeclaratorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 664,
   FQN="clang::DeclaratorDecl::DeclaratorDecl", NM="_ZN5clang14DeclaratorDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoES5_")
  //</editor-fold>
  protected DeclaratorDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, 
      DeclarationName N, QualType T, TypeSourceInfo /*P*/ TInfo, 
      SourceLocation StartL) {
    // : ValueDecl(DK, DC, L, N, T), DeclInfo(TInfo), InnerLocStart(StartL) 
    //START JInit
    super(DK, DC, new SourceLocation(L), new DeclarationName(N), new QualType(T));
    this.DeclInfo = new PointerUnion<TypeSourceInfo /*P*/ , ExtInfo /*P*/ >(JD$T.INSTANCE, TypeSourceInfo /*P*/ .class, TInfo);
    this.InnerLocStart = new SourceLocation(StartL);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 671,
   FQN="clang::DeclaratorDecl::getTypeSourceInfo", NM="_ZNK5clang14DeclaratorDecl17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return hasExtInfo() ? getExtInfo$Const().TInfo : DeclInfo.get(TypeSourceInfo /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::setTypeSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 676,
   FQN="clang::DeclaratorDecl::setTypeSourceInfo", NM="_ZN5clang14DeclaratorDecl17setTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl17setTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeSourceInfo(TypeSourceInfo /*P*/ TI) {
    if (hasExtInfo()) {
      getExtInfo().TInfo = TI;
    } else {
      DeclInfo.$assign_T$C$R(TypeSourceInfo /*P*/.class, TI);
    }
  }

  
  /// getInnerLocStart - Return SourceLocation representing start of source
  /// range ignoring outer template declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getInnerLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 685,
   FQN="clang::DeclaratorDecl::getInnerLocStart", NM="_ZNK5clang14DeclaratorDecl16getInnerLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl16getInnerLocStartEv")
  //</editor-fold>
  public SourceLocation getInnerLocStart() /*const*/ {
    return new SourceLocation(InnerLocStart);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::setInnerLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 686,
   FQN="clang::DeclaratorDecl::setInnerLocStart", NM="_ZN5clang14DeclaratorDecl16setInnerLocStartENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl16setInnerLocStartENS_14SourceLocationE")
  //</editor-fold>
  public void setInnerLocStart(SourceLocation L) {
    InnerLocStart.$assign(L);
  }

  
  /// getOuterLocStart - Return SourceLocation representing start of source
  /// range taking into account any outer template declarations.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getOuterLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1695,
   FQN="clang::DeclaratorDecl::getOuterLocStart", NM="_ZNK5clang14DeclaratorDecl16getOuterLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl16getOuterLocStartEv")
  //</editor-fold>
  public SourceLocation getOuterLocStart() /*const*/ {
    return getTemplateOrInnerLocStart(this);
  }

  
  // namespace
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1739,
   FQN="clang::DeclaratorDecl::getSourceRange", NM="_ZNK5clang14DeclaratorDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation RangeEnd = getLocation();
    {
      TypeSourceInfo /*P*/ TInfo = getTypeSourceInfo();
      if ((TInfo != null)) {
        // If the declaration has no name or the type extends past the name take the
        // end location of the type.
        if (!getDeclName().$bool() || typeIsPostfix(TInfo.getType())) {
          RangeEnd.$assignMove(TInfo.getTypeLoc().getSourceRange().getEnd());
        }
      }
    }
    return new SourceRange(getOuterLocStart(), /*NO_COPY*/RangeEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 693,
   FQN="clang::DeclaratorDecl::getLocStart", NM="_ZNK5clang14DeclaratorDecl11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getOuterLocStart();
  }

  
  /// \brief Retrieve the nested-name-specifier that qualifies the name of this
  /// declaration, if it was present in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 699,
   FQN="clang::DeclaratorDecl::getQualifier", NM="_ZNK5clang14DeclaratorDecl12getQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl12getQualifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getQualifier() /*const*/ {
    return hasExtInfo() ? getExtInfo$Const().QualifierLoc.getNestedNameSpecifier() : null;
  }

  
  /// \brief Retrieve the nested-name-specifier (with source-location
  /// information) that qualifies the name of this declaration, if it was
  /// present in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 707,
   FQN="clang::DeclaratorDecl::getQualifierLoc", NM="_ZNK5clang14DeclaratorDecl15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return hasExtInfo() ? new NestedNameSpecifierLoc(getExtInfo$Const().QualifierLoc) : new NestedNameSpecifierLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::setQualifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1649,
   FQN="clang::DeclaratorDecl::setQualifierInfo", NM="_ZN5clang14DeclaratorDecl16setQualifierInfoENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl16setQualifierInfoENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void setQualifierInfo(NestedNameSpecifierLoc QualifierLoc) {
    if (QualifierLoc.$bool()) {
      // Make sure the extended decl info is allocated.
      if (!hasExtInfo()) {
        // Save (non-extended) type source info pointer.
        TypeSourceInfo /*P*/ savedTInfo = DeclInfo.get(TypeSourceInfo /*P*/.class);
        // Allocate external info struct.
        DeclInfo.$assign_T1$C$R(ExtInfo/*P*/.class, /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExtInfo());
        // Restore savedTInfo into (extended) decl info.
        getExtInfo().TInfo = savedTInfo;
      }
      // Set qualifier info.
      getExtInfo().QualifierLoc.$assign(QualifierLoc);
    } else {
      // Here Qualifier == 0, i.e., we are removing the qualifier (if any).
      if (hasExtInfo()) {
        if (getExtInfo().NumTemplParamLists == 0) {
          // Save type source info pointer.
          TypeSourceInfo /*P*/ savedTInfo = getExtInfo().TInfo;
          // Deallocate the extended decl info.
          getASTContext().Deallocate(getExtInfo());
          // Restore savedTInfo into (non-extended) decl info.
          DeclInfo.$assign_T$C$R(TypeSourceInfo /*P*/.class, savedTInfo);
        } else {
          getExtInfo().QualifierLoc.$assign(QualifierLoc);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getNumTemplateParameterLists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 714,
   FQN="clang::DeclaratorDecl::getNumTemplateParameterLists", NM="_ZNK5clang14DeclaratorDecl28getNumTemplateParameterListsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl28getNumTemplateParameterListsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateParameterLists() /*const*/ {
    return hasExtInfo() ? getExtInfo$Const().NumTemplParamLists : 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 717,
   FQN="clang::DeclaratorDecl::getTemplateParameterList", NM="_ZNK5clang14DeclaratorDecl24getTemplateParameterListEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl24getTemplateParameterListEj")
  //</editor-fold>
  public TemplateParameterList /*P*/ getTemplateParameterList(/*uint*/int index) /*const*/ {
    assert ($less_uint(index, getNumTemplateParameterLists()));
    return getExtInfo$Const().TemplParamLists.$at(index);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::setTemplateParameterListsInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1679,
   FQN="clang::DeclaratorDecl::setTemplateParameterListsInfo", NM="_ZN5clang14DeclaratorDecl29setTemplateParameterListsInfoERNS_10ASTContextEN4llvm8ArrayRefIPNS_21TemplateParameterListEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl29setTemplateParameterListsInfoERNS_10ASTContextEN4llvm8ArrayRefIPNS_21TemplateParameterListEEE")
  //</editor-fold>
  public void setTemplateParameterListsInfo(final ASTContext /*&*/ Context, ArrayRef<TemplateParameterList /*P*/ > TPLists) {
    assert (!TPLists.empty());
    // Make sure the extended decl info is allocated.
    if (!hasExtInfo()) {
      // Save (non-extended) type source info pointer.
      TypeSourceInfo /*P*/ savedTInfo = DeclInfo.get(TypeSourceInfo /*P*/.class);
      // Allocate external info struct.
      DeclInfo.$assign_T1$C$R(ExtInfo/*P*/.class, /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new ExtInfo());
      // Restore savedTInfo into (extended) decl info.
      getExtInfo().TInfo = savedTInfo;
    }
    // Set the template parameter lists info.
    getExtInfo().setTemplateParameterListsInfo(Context, new ArrayRef<TemplateParameterList /*P*/ >(TPLists));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::getTypeSpecStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1643,
   FQN="clang::DeclaratorDecl::getTypeSpecStartLoc", NM="_ZNK5clang14DeclaratorDecl19getTypeSpecStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang14DeclaratorDecl19getTypeSpecStartLocEv")
  //</editor-fold>
  public SourceLocation getTypeSpecStartLoc() /*const*/ {
    TypeSourceInfo /*P*/ TSI = getTypeSourceInfo();
    if ((TSI != null)) {
      return TSI.getTypeLoc().getBeginLoc();
    }
    return new SourceLocation();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 727,
   FQN="clang::DeclaratorDecl::classof", NM="_ZN5clang14DeclaratorDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 728,
   FQN="clang::DeclaratorDecl::classofKind", NM="_ZN5clang14DeclaratorDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstDeclarator.getValue() && K.getValue() <= Kind.lastDeclarator.getValue();
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclaratorDecl::~DeclaratorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 646,
   FQN="clang::DeclaratorDecl::~DeclaratorDecl", NM="_ZN5clang14DeclaratorDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang14DeclaratorDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "DeclInfo=" + DeclInfo // NOI18N
              + ", InnerLocStart=" + InnerLocStart // NOI18N
              + super.toString(); // NOI18N
  }
}
