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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


/// LabelDecl - Represents the declaration of a label.  Labels also have a
/// corresponding LabelStmt, which indicates the position that the label was
/// defined at.  For normal labels, the location of the decl is the same as the
/// location of the statement.  For GNU local labels (__label__), the decl
/// location is where the __label__ is.
//<editor-fold defaultstate="collapsed" desc="clang::LabelDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 424,
 FQN="clang::LabelDecl", NM="_ZN5clang9LabelDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDeclE")
//</editor-fold>
public class LabelDecl extends /*public*/ NamedDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3978,
   FQN="clang::LabelDecl::anchor", NM="_ZN5clang9LabelDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  private LabelStmt /*P*/ TheStmt;
  private StringRef MSAsmName;
  private boolean MSAsmNameResolved;
  /// LocStart - For normal labels, this is the same as the main declaration
  /// label, i.e., the location of the identifier; for GNU local labels,
  /// this is the location of the __label__ keyword.
  private SourceLocation LocStart;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::LabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 434,
   FQN="clang::LabelDecl::LabelDecl", NM="_ZN5clang9LabelDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_9LabelStmtES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_9LabelStmtES3_")
  //</editor-fold>
  private LabelDecl(DeclContext /*P*/ DC, SourceLocation IdentL, IdentifierInfo /*P*/ II, 
      LabelStmt /*P*/ S, SourceLocation StartL) {
    // : NamedDecl(Label, DC, IdentL, II), TheStmt(S), MSAsmName(), MSAsmNameResolved(false), LocStart(StartL) 
    //START JInit
    super(Kind.Label, DC, new SourceLocation(IdentL), new DeclarationName(II));
    this.TheStmt = S;
    this.MSAsmName = new StringRef();
    this.MSAsmNameResolved = false;
    this.LocStart = new SourceLocation(StartL);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3980,
   FQN="clang::LabelDecl::Create", NM="_ZN5clang9LabelDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoE")
  //</editor-fold>
  public static LabelDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation IdentL, IdentifierInfo /*P*/ II) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new LabelDecl(DC, new SourceLocation(IdentL), II, (LabelStmt /*P*/ )null, new SourceLocation(IdentL));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3985,
   FQN="clang::LabelDecl::Create", NM="_ZN5clang9LabelDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES5_")
  //</editor-fold>
  public static LabelDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation IdentL, IdentifierInfo /*P*/ II, 
        SourceLocation GnuLabelL) {
    assert ($noteq_SourceLocation$C(GnuLabelL, IdentL)) : "Use this only for GNU local labels";
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new LabelDecl(DC, new SourceLocation(IdentL), II, (LabelStmt /*P*/ )null, new SourceLocation(GnuLabelL));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3992,
   FQN="clang::LabelDecl::CreateDeserialized", NM="_ZN5clang9LabelDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static LabelDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new LabelDecl((DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, (LabelStmt /*P*/ )null, 
                new SourceLocation());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 449,
   FQN="clang::LabelDecl::getStmt", NM="_ZNK5clang9LabelDecl7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9LabelDecl7getStmtEv")
  //</editor-fold>
  public LabelStmt /*P*/ getStmt() /*const*/ {
    return TheStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::setStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 450,
   FQN="clang::LabelDecl::setStmt", NM="_ZN5clang9LabelDecl7setStmtEPNS_9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl7setStmtEPNS_9LabelStmtE")
  //</editor-fold>
  public void setStmt(LabelStmt /*P*/ T) {
    TheStmt = T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::isGnuLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 452,
   FQN="clang::LabelDecl::isGnuLocal", NM="_ZNK5clang9LabelDecl10isGnuLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9LabelDecl10isGnuLocalEv")
  //</editor-fold>
  public boolean isGnuLocal() /*const*/ {
    return $noteq_SourceLocation$C(LocStart, getLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::setLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 453,
   FQN="clang::LabelDecl::setLocStart", NM="_ZN5clang9LabelDecl11setLocStartENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl11setLocStartENS_14SourceLocationE")
  //</editor-fold>
  public void setLocStart(SourceLocation L) {
    LocStart.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 455,
   FQN="clang::LabelDecl::getSourceRange", NM="_ZNK5clang9LabelDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9LabelDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(/*NO_COPY*/LocStart, getLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::isMSAsmLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 459,
   FQN="clang::LabelDecl::isMSAsmLabel", NM="_ZNK5clang9LabelDecl12isMSAsmLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9LabelDecl12isMSAsmLabelEv")
  //</editor-fold>
  public boolean isMSAsmLabel() /*const*/ {
    return MSAsmName.size() != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::isResolvedMSAsmLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 460,
   FQN="clang::LabelDecl::isResolvedMSAsmLabel", NM="_ZNK5clang9LabelDecl20isResolvedMSAsmLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9LabelDecl20isResolvedMSAsmLabelEv")
  //</editor-fold>
  public boolean isResolvedMSAsmLabel() /*const*/ {
    return isMSAsmLabel() && MSAsmNameResolved;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::setMSAsmLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3997,
   FQN="clang::LabelDecl::setMSAsmLabel", NM="_ZN5clang9LabelDecl13setMSAsmLabelEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl13setMSAsmLabelEN4llvm9StringRefE")
  //</editor-fold>
  public void setMSAsmLabel(StringRef Name) {
    char$ptr/*char P*/ Buffer = create_char$ptr(/*FIXME:NEW_EXPR*//*new (getASTContext(), 1)*/ new$char(Name.size() + 1));
    memcpy(Buffer, Name.data(), Name.size());
    Buffer.$set(Name.size(), $$TERM);
    MSAsmName.$assignMove(new StringRef(Buffer));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::getMSAsmLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 462,
   FQN="clang::LabelDecl::getMSAsmLabel", NM="_ZNK5clang9LabelDecl13getMSAsmLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9LabelDecl13getMSAsmLabelEv")
  //</editor-fold>
  public StringRef getMSAsmLabel() /*const*/ {
    return new StringRef(MSAsmName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::setMSAsmLabelResolved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 463,
   FQN="clang::LabelDecl::setMSAsmLabelResolved", NM="_ZN5clang9LabelDecl21setMSAsmLabelResolvedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl21setMSAsmLabelResolvedEv")
  //</editor-fold>
  public void setMSAsmLabelResolved() {
    MSAsmNameResolved = true;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 466,
   FQN="clang::LabelDecl::classof", NM="_ZN5clang9LabelDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 467,
   FQN="clang::LabelDecl::classofKind", NM="_ZN5clang9LabelDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.Label;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LabelDecl::~LabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 424,
   FQN="clang::LabelDecl::~LabelDecl", NM="_ZN5clang9LabelDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9LabelDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "TheStmt=" + NativeTrace.getIdentityStr(TheStmt) // NOI18N
              + ", MSAsmName=" + MSAsmName // NOI18N
              + ", MSAsmNameResolved=" + MSAsmNameResolved // NOI18N
              + ", LocStart=" + LocStart // NOI18N
              + super.toString(); // NOI18N
  }
}
