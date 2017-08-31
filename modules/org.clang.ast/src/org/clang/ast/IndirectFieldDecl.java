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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// IndirectFieldDecl - An instance of this class is created to represent a
/// field injected from an anonymous union/struct into the parent scope.
/// IndirectFieldDecl are always implicit.
//<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2521,
 FQN="clang::IndirectFieldDecl", NM="_ZN5clang17IndirectFieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDeclE")
//</editor-fold>
public class IndirectFieldDecl extends /*public*/ ValueDecl implements /*public*/ Mergeable<IndirectFieldDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4093,
   FQN="clang::IndirectFieldDecl::anchor", NM="_ZN5clang17IndirectFieldDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /*friend*/public type$ptr<NamedDecl /*P*/ /*P*/> Chaining;
  /*friend*/public /*uint*/int ChainingSize;
  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::IndirectFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4095,
   FQN="clang::IndirectFieldDecl::IndirectFieldDecl", NM="_ZN5clang17IndirectFieldDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEN4llvm15MutableArrayRefIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDeclC1ERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEN4llvm15MutableArrayRefIPNS_9NamedDeclEEE")
  //</editor-fold>
  private IndirectFieldDecl(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation L, DeclarationName N, 
      QualType T, 
      MutableArrayRef<NamedDecl /*P*/ > CH) {
    // : ValueDecl(IndirectField, DC, L, N, T), Mergeable<IndirectFieldDecl>(), Chaining(CH.data()), ChainingSize(CH.size()) 
    //START JInit
    super(Kind.IndirectField, DC, new SourceLocation(L), new DeclarationName(N), new QualType(T));
    $Mergeable();
    this.Chaining = $tryClone(CH.data());
    this.ChainingSize = CH.size();
    //END JInit
    // In C++, indirect field declarations conflict with tag declarations in the
    // same scope, so add them to IDNS_Tag so that tag redeclaration finds them.
    if (C.getLangOpts().CPlusPlus) {
      IdentifierNamespace_field |= $int2uint_13bits(IdentifierNamespace.IDNS_Tag);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4107,
   FQN="clang::IndirectFieldDecl::Create", NM="_ZN5clang17IndirectFieldDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEN4llvm15MutableArrayRefIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoENS_8QualTypeEN4llvm15MutableArrayRefIPNS_9NamedDeclEEE")
  //</editor-fold>
  public static IndirectFieldDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation L, 
        IdentifierInfo /*P*/ Id, QualType T, 
        MutableArrayRef<NamedDecl /*P*/ > CH) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new IndirectFieldDecl(C, DC, new SourceLocation(L), new DeclarationName(Id), new QualType(T), new MutableArrayRef<NamedDecl /*P*/ >(CH));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4114,
   FQN="clang::IndirectFieldDecl::CreateDeserialized", NM="_ZN5clang17IndirectFieldDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static IndirectFieldDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new IndirectFieldDecl(C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new DeclarationName(), new QualType(), new MutableArrayRef<NamedDecl /*P*/ >(None, true));
     });
  }

  
  /*typedef ArrayRef<NamedDecl *>::const_iterator chain_iterator*/
//  public final class chain_iterator extends type$ptr<NamedDecl /*P*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::chain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2540,
   FQN="clang::IndirectFieldDecl::chain", NM="_ZNK5clang17IndirectFieldDecl5chainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17IndirectFieldDecl5chainEv")
  //</editor-fold>
  public ArrayRef<NamedDecl /*P*/ > chain() /*const*/ {
    return llvm.makeArrayRef(Chaining, ChainingSize);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::chain_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2543,
   FQN="clang::IndirectFieldDecl::chain_begin", NM="_ZNK5clang17IndirectFieldDecl11chain_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17IndirectFieldDecl11chain_beginEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> chain_begin() /*const*/ {
    return chain().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::chain_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2544,
   FQN="clang::IndirectFieldDecl::chain_end", NM="_ZNK5clang17IndirectFieldDecl9chain_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17IndirectFieldDecl9chain_endEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> chain_end() /*const*/ {
    return chain().end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::getChainingSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2546,
   FQN="clang::IndirectFieldDecl::getChainingSize", NM="_ZNK5clang17IndirectFieldDecl15getChainingSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17IndirectFieldDecl15getChainingSizeEv")
  //</editor-fold>
  public /*uint*/int getChainingSize() /*const*/ {
    return ChainingSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::getAnonField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2548,
   FQN="clang::IndirectFieldDecl::getAnonField", NM="_ZNK5clang17IndirectFieldDecl12getAnonFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17IndirectFieldDecl12getAnonFieldEv")
  //</editor-fold>
  public FieldDecl /*P*/ getAnonField() /*const*/ {
    assert ($greatereq_uint(chain().size(), 2));
    return cast_FieldDecl(chain().back());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::getVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2553,
   FQN="clang::IndirectFieldDecl::getVarDecl", NM="_ZNK5clang17IndirectFieldDecl10getVarDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17IndirectFieldDecl10getVarDeclEv")
  //</editor-fold>
  public VarDecl /*P*/ getVarDecl() /*const*/ {
    assert ($greatereq_uint(chain().size(), 2));
    return dyn_cast_VarDecl(chain().front());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2558,
   FQN="clang::IndirectFieldDecl::getCanonicalDecl", NM="_ZN5clang17IndirectFieldDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public IndirectFieldDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2559,
   FQN="clang::IndirectFieldDecl::getCanonicalDecl", NM="_ZNK5clang17IndirectFieldDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang17IndirectFieldDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ IndirectFieldDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2562,
   FQN="clang::IndirectFieldDecl::classof", NM="_ZN5clang17IndirectFieldDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2563,
   FQN="clang::IndirectFieldDecl::classofKind", NM="_ZN5clang17IndirectFieldDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.IndirectField;
  }

  /*friend  class ASTDeclReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::IndirectFieldDecl::~IndirectFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2521,
   FQN="clang::IndirectFieldDecl::~IndirectFieldDecl", NM="_ZN5clang17IndirectFieldDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang17IndirectFieldDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Mergeable.super.$destroy$Mergeable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //public final IndirectFieldDecl /*P*/ getFirstDecl() { return Mergeable.super.getFirstDecl$Mergeable(); }
  
  //public final /*const*/ IndirectFieldDecl /*P*/ getFirstDecl$Const() /*const*/ { return Mergeable.super.getFirstDecl$Mergeable$Const(); }
  
  public final boolean isFirstDecl() /*const*/ { return Mergeable.super.isFirstDecl$Mergeable(); }
  
  public final Class<? extends IndirectFieldDecl> getDeclType$Mergeable() { return this.getClass(); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Chaining=" + Chaining // NOI18N
              + ", ChainingSize=" + ChainingSize // NOI18N
              + super.toString(); // NOI18N
  }
}
