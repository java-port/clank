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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// \brief An array of decls optimized for the common case of only containing
/// one entry.
//<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 32,
 FQN="clang::StoredDeclsList", NM="_ZN5clang15StoredDeclsListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsListE")
//</editor-fold>
public class/*struct*/ StoredDeclsList implements NativeCloneable<StoredDeclsList>, Destructors.ClassWithDestructor {
  
  /// \brief When in vector form, this is what the Data pointer points to.
  /*typedef SmallVector<NamedDecl *, 4> DeclsTy*/
//  public final class DeclsTy extends SmallVector<NamedDecl /*P*/ >{ };
  
  /// \brief A collection of declarations, with a flag to indicate if we have
  /// further external declarations.
  /*typedef llvm::PointerIntPair<DeclsTy *, 1, bool> DeclsAndHasExternalTy*/
//  public final class DeclsAndHasExternalTy extends PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/>{ };
  
  /// \brief The stored data, which will be either a pointer to a NamedDecl,
  /// or a pointer to a vector with a flag to indicate if there are further
  /// external declarations.
  public PointerUnion<NamedDecl /*P*/ , PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/> > Data;
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::StoredDeclsList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 47,
   FQN="clang::StoredDeclsList::StoredDeclsList", NM="_ZN5clang15StoredDeclsListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsListC1Ev")
  //</editor-fold>
  public StoredDeclsList() {
    // : Data() 
    //START JInit
    this.Data = new PointerUnion<NamedDecl /*P*/ , PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/> >(NamedDecl /*P*/.class);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::StoredDeclsList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 49,
   FQN="clang::StoredDeclsList::StoredDeclsList", NM="_ZN5clang15StoredDeclsListC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsListC1EOS0_")
  //</editor-fold>
  public StoredDeclsList(JD$Move _dparam, final StoredDeclsList /*&&*/RHS) {
    // : Data(RHS.Data) 
    //START JInit
    this.Data = new PointerUnion<NamedDecl /*P*/ , PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/> >(RHS.Data);
    //END JInit
    RHS.Data.$assign_T$C$R(NamedDecl /*P*/ /*const*/ /*&*/.class, (NamedDecl /*P*/ )(NamedDecl /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::~StoredDeclsList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 53,
   FQN="clang::StoredDeclsList::~StoredDeclsList", NM="_ZN5clang15StoredDeclsListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsListD0Ev")
  //</editor-fold>
  public void $destroy() {
    {
      // If this is a vector-form, free the vector.
      SmallVector<NamedDecl /*P*/ > /*P*/ Vector = getAsVector();
      if ((Vector != null)) {
        if (Vector != null) { Vector.$destroy();};
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 59,
   FQN="clang::StoredDeclsList::operator=", NM="_ZN5clang15StoredDeclsListaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsListaSEOS0_")
  //</editor-fold>
  public StoredDeclsList /*&*/ $assignMove(final StoredDeclsList /*&&*/RHS) {
    {
      SmallVector<NamedDecl /*P*/ > /*P*/ Vector = getAsVector();
      if ((Vector != null)) {
        if (Vector != null) { Vector.$destroy();};
      }
    }
    Data.$assign(RHS.Data);
    RHS.Data.$assign_T$C$R(NamedDecl /*P*/ /*const*/ /*&*/.class, (NamedDecl /*P*/ )(NamedDecl /*P*/ )null);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 67,
   FQN="clang::StoredDeclsList::isNull", NM="_ZNK5clang15StoredDeclsList6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15StoredDeclsList6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return Data.isNull();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::getAsDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 69,
   FQN="clang::StoredDeclsList::getAsDecl", NM="_ZNK5clang15StoredDeclsList9getAsDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15StoredDeclsList9getAsDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getAsDecl() /*const*/ {
    return Data.dyn_cast(NamedDecl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::getAsVectorAndHasExternal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 73,
   FQN="clang::StoredDeclsList::getAsVectorAndHasExternal", NM="_ZNK5clang15StoredDeclsList25getAsVectorAndHasExternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15StoredDeclsList25getAsVectorAndHasExternalEv")
  //</editor-fold>
  public PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/> getAsVectorAndHasExternal() /*const*/ {
    PointerBoolPair<SmallVector<NamedDecl>> Out = Data.dyn_cast(PointerBoolPair$Class);
    return Out == null ? new PointerBoolPair() : Out;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::getAsVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 77,
   FQN="clang::StoredDeclsList::getAsVector", NM="_ZNK5clang15StoredDeclsList11getAsVectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15StoredDeclsList11getAsVectorEv")
  //</editor-fold>
  public SmallVector<NamedDecl /*P*/ > /*P*/ getAsVector() /*const*/ {
    return getAsVectorAndHasExternal().getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::hasExternalDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 81,
   FQN="clang::StoredDeclsList::hasExternalDecls", NM="_ZNK5clang15StoredDeclsList16hasExternalDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang15StoredDeclsList16hasExternalDeclsEv")
  //</editor-fold>
  public boolean hasExternalDecls() /*const*/ {
    return getAsVectorAndHasExternal().getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::setHasExternalDecls">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 85,
   FQN="clang::StoredDeclsList::setHasExternalDecls", NM="_ZN5clang15StoredDeclsList19setHasExternalDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsList19setHasExternalDeclsEv")
  //</editor-fold>
  public void setHasExternalDecls() {
    {
      SmallVector<NamedDecl /*P*/ > /*P*/ Vec = getAsVector();
      if ((Vec != null)) {
        Data.$assign_T1$C$R(PointerBoolPair$Class, new PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/>(Vec, true));
      } else {
        SmallVector<NamedDecl /*P*/ > /*P*/ VT = new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
        {
          NamedDecl /*P*/ OldD = getAsDecl();
          if ((OldD != null)) {
            VT.push_back(OldD);
          }
        }
        Data.$assign_T1$C$R(PointerBoolPair$Class, new PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/>(VT, true));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::setOnlyValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 96,
   FQN="clang::StoredDeclsList::setOnlyValue", NM="_ZN5clang15StoredDeclsList12setOnlyValueEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsList12setOnlyValueEPNS_9NamedDeclE")
  //</editor-fold>
  public void setOnlyValue(NamedDecl /*P*/ ND) {
    assert (!(getAsVector() != null)) : "Not inline";
    Data.$assign_T$C$R(NamedDecl /*P*/ /*const*/ /*&*/.class, ND);
    // Make sure that Data is a plain NamedDecl* so we can use its address
    // at getLookupResult.
    assert ($AddrOf(Data.getAddrOfPtr1(NamedDecl.class).$star()) == ND) : "PointerUnion mangles the NamedDecl pointer!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 105,
   FQN="clang::StoredDeclsList::remove", NM="_ZN5clang15StoredDeclsList6removeEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsList6removeEPNS_9NamedDeclE")
  //</editor-fold>
  public void remove(NamedDecl /*P*/ D) {
    assert (!isNull()) : "removing from empty list";
    {
      NamedDecl /*P*/ Singleton = getAsDecl();
      if ((Singleton != null)) {
        assert (Singleton == D) : "list is different singleton";
        ///*J:(void)*/Singleton;
        Data.$assign_T$C$R(NamedDecl /*P*/ /*const*/ /*&*/.class, (NamedDecl /*P*/ )(NamedDecl /*P*/ )null);
        return;
      }
    }
    
    final SmallVector<NamedDecl /*P*/ > /*&*/ Vec = $Deref(getAsVector());
    type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(std.find(Vec.begin(), Vec.end(), D, true));
    assert ($noteq_ptr(I, Vec.end())) : "list does not contain decl";
    Vec.erase(I);
    assert ($eq_ptr(std.find(Vec.begin(), Vec.end(), D, true), Vec.end())) : "list still contains decl";
  }

  
  /// \brief Remove any declarations which were imported from an external
  /// AST source.
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::removeExternalDecls">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 125,
   FQN="clang::StoredDeclsList::removeExternalDecls", NM="_ZN5clang15StoredDeclsList19removeExternalDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsList19removeExternalDeclsEv")
  //</editor-fold>
  public void removeExternalDecls() {
    if (isNull()) {
      // Nothing to do.
    } else {
      NamedDecl /*P*/ Singleton = getAsDecl();
      if ((Singleton != null)) {
        if (Singleton.isFromASTFile()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(/*Deref*/this.$assignMove($c$.track(new StoredDeclsList())));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        final SmallVector<NamedDecl /*P*/ > /*&*/ Vec = $Deref(getAsVector());
        Vec.erase(std.remove_if(Vec.begin(), Vec.end(),
            (NamedDecl param) -> param.isFromASTFile()),//std.mem_fun_(/*AddrOf*//*FPtr*/Decl::isFromASTFile)), 
            Vec.end());
        // Don't have any external decls any more.
        Data.$assign_T1$C$R(PointerBoolPair$Class, new PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/>($AddrOf(Vec), false));
      }
    }
  }

  
  /// getLookupResult - Return an array of all the decls that this list
  /// represents.
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::getLookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 143,
   FQN="clang::StoredDeclsList::getLookupResult", NM="_ZN5clang15StoredDeclsList15getLookupResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsList15getLookupResultEv")
  //</editor-fold>
  public DeclContextLookupResult getLookupResult() {
    if (isNull()) {
      return new DeclContextLookupResult();
    }
    {
      
      // If we have a single NamedDecl, return it.
      NamedDecl /*P*/ ND = getAsDecl();
      if ((ND != null)) {
        assert (!isNull()) : "Empty list isn't allowed";
        
        // Data is a raw pointer to a NamedDecl*, return it.
        return new DeclContextLookupResult(ND);
      }
    }
    assert ((getAsVector() != null)) : "Must have a vector at this point";
    final SmallVector<NamedDecl /*P*/ > /*&*/ Vector = $Deref(getAsVector());
    
    // Otherwise, we have a range result.
    return new DeclContextLookupResult(new ArrayRef<NamedDecl /*P*/ >(Vector, true));
  }

  
  /// HandleRedeclaration - If this is a redeclaration of an existing decl,
  /// replace the old one with D and return true.  Otherwise return false.
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::HandleRedeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 164,
   FQN="clang::StoredDeclsList::HandleRedeclaration", NM="_ZN5clang15StoredDeclsList19HandleRedeclarationEPNS_9NamedDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsList19HandleRedeclarationEPNS_9NamedDeclEb")
  //</editor-fold>
  public boolean HandleRedeclaration(NamedDecl /*P*/ D, boolean IsKnownNewer) {
    {
      // Most decls only have one entry in their list, special case it.
      NamedDecl /*P*/ OldD = getAsDecl();
      if ((OldD != null)) {
        if (!D.declarationReplaces(OldD, IsKnownNewer)) {
          return false;
        }
        setOnlyValue(D);
        return true;
      }
    }
    
    // Determine if this declaration is actually a redeclaration.
    final SmallVector<NamedDecl /*P*/ > /*&*/ Vec = $Deref(getAsVector());
    for (type$ptr<NamedDecl /*P*/ /*P*/> OD = $tryClone(Vec.begin()), /*P*/ ODEnd = $tryClone(Vec.end());
         $noteq_ptr(OD, ODEnd); OD.$preInc()) {
      NamedDecl /*P*/ OldD = OD.$star();
      if (D.declarationReplaces(OldD, IsKnownNewer)) {
        OD.$set(D);
        return true;
      }
    }
    
    return false;
  }

  
  /// AddSubsequentDecl - This is called on the second and later decl when it is
  /// not a redeclaration to merge it into the appropriate place in our list.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::StoredDeclsList::AddSubsequentDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclContextInternals.h", line = 190,
   FQN="clang::StoredDeclsList::AddSubsequentDecl", NM="_ZN5clang15StoredDeclsList17AddSubsequentDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang15StoredDeclsList17AddSubsequentDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void AddSubsequentDecl(NamedDecl /*P*/ D) {
    assert (!isNull()) : "don't AddSubsequentDecl when we have no decls";
    {
      
      // If this is the second decl added to the list, convert this to vector
      // form.
      NamedDecl /*P*/ OldD = getAsDecl();
      if ((OldD != null)) {
        SmallVector<NamedDecl /*P*/ > /*P*/ VT = new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
        VT.push_back(OldD);
        Data.$assign_T1$C$R(PointerBoolPair$Class, new PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/>(VT, false));
      }
    }
    
    final SmallVector<NamedDecl /*P*/ > /*&*/ Vec = $Deref(getAsVector());
    
    // Using directives end up in a special entry which contains only
    // other using directives, so all this logic is wasted for them.
    // But avoiding the logic wastes time in the far-more-common case
    // that we're *not* adding a new using directive.
    
    // Tag declarations always go at the end of the list so that an
    // iterator which points at the first tag will start a span of
    // decls that only contains tags.
    if (D.hasTagIdentifierNamespace()) {
      Vec.push_back(D);
    } else 
    // Resolved using declarations go at the front of the list so that
    // they won't show up in other lookup results.  Unresolved using
    // declarations (which are always in IDNS_Using | IDNS_Ordinary)
    // follow that so that the using declarations will be contiguous.
    if (((D.getIdentifierNamespace() & Decl.IdentifierNamespace.IDNS_Using) != 0)) {
      type$ptr<NamedDecl /*P*/ /*P*/> I = $tryClone(Vec.begin());
      if (D.getIdentifierNamespace() != Decl.IdentifierNamespace.IDNS_Using) {
        while ($noteq_ptr(I, Vec.end())
           && (I.$star()).getIdentifierNamespace() == Decl.IdentifierNamespace.IDNS_Using) {
          I.$preInc();
        }
      }
      Vec.insert(I, D);
      // All other declarations go at the end of the list, but before any
      // tag declarations.  But we can be clever about tag declarations
      // because there can only ever be one in a scope.
    } else if (!Vec.empty() && Vec.back().hasTagIdentifierNamespace()) {
      NamedDecl /*P*/ TagD = Vec.back();
      Vec.ref$back().$set(D);
      Vec.push_back(TagD);
    } else {
      Vec.push_back(D);
    }
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public StoredDeclsList(final StoredDeclsList $Prm0) { this.Data = $tryClone($Prm0.Data); }

  @Override public StoredDeclsList clone() { return new StoredDeclsList(this); }

  private static Class<PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/>> PointerBoolPair$Class = (Class<PointerBoolPair<SmallVector<NamedDecl /*P*/ > /*P*/>>)(Class<?>)PointerBoolPair /*&*/.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Data=" + Data; // NOI18N
  }
}
