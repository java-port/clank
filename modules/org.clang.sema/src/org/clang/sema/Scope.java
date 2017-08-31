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

package org.clang.sema;

import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// Scope - A scope is a transient data structure that is used while parsing the
/// program.  It assists with resolving identifiers to the appropriate
/// declaration.
///
//<editor-fold defaultstate="collapsed" desc="clang::Scope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 39,
 FQN="clang::Scope", NM="_ZN5clang5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5ScopeE")
//</editor-fold>
public class Scope implements Destructors.ClassWithDestructor {
/*public:*/
  /// ScopeFlags - These are bitfields that are or'd together when creating a
  /// scope, which defines the sorts of things the scope contains.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::ScopeFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 43,
   FQN="clang::Scope::ScopeFlags", NM="_ZN5clang5Scope10ScopeFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope10ScopeFlagsE")
  //</editor-fold>
  public static final class/*enum*/ ScopeFlags {
    /// \brief This indicates that the scope corresponds to a function, which
    /// means that labels are set here.
    public static final /*uint*/int FnScope = 0x01;
    
    /// \brief This is a while, do, switch, for, etc that can have break
    /// statements embedded into it.
    public static final /*uint*/int BreakScope = 0x02;
    
    /// \brief This is a while, do, for, which can have continue statements
    /// embedded into it.
    public static final /*uint*/int ContinueScope = 0x04;
    
    /// \brief This is a scope that can contain a declaration.  Some scopes
    /// just contain loop constructs but don't contain decls.
    public static final /*uint*/int DeclScope = 0x08;
    
    /// \brief The controlling scope in a if/switch/while/for statement.
    public static final /*uint*/int ControlScope = 0x10;
    
    /// \brief The scope of a struct/union/class definition.
    public static final /*uint*/int ClassScope = 0x20;
    
    /// \brief This is a scope that corresponds to a block/closure object.
    /// Blocks serve as top-level scopes for some objects like labels, they
    /// also prevent things like break and continue.  BlockScopes always have
    /// the FnScope and DeclScope flags set as well.
    public static final /*uint*/int BlockScope = 0x40;
    
    /// \brief This is a scope that corresponds to the
    /// template parameters of a C++ template. Template parameter
    /// scope starts at the 'template' keyword and ends when the
    /// template declaration ends.
    public static final /*uint*/int TemplateParamScope = 0x80;
    
    /// \brief This is a scope that corresponds to the
    /// parameters within a function prototype.
    public static final /*uint*/int FunctionPrototypeScope = 0x100;
    
    /// \brief This is a scope that corresponds to the parameters within
    /// a function prototype for a function declaration (as opposed to any
    /// other kind of function declarator). Always has FunctionPrototypeScope
    /// set as well.
    public static final /*uint*/int FunctionDeclarationScope = 0x200;
    
    /// \brief This is a scope that corresponds to the Objective-C
    /// \@catch statement.
    public static final /*uint*/int AtCatchScope = 0x400;
    
    /// \brief This scope corresponds to an Objective-C method body.
    /// It always has FnScope and DeclScope set as well.
    public static final /*uint*/int ObjCMethodScope = 0x800;
    
    /// \brief This is a scope that corresponds to a switch statement.
    public static final /*uint*/int SwitchScope = 0x1000;
    
    /// \brief This is the scope of a C++ try statement.
    public static final /*uint*/int TryScope = 0x2000;
    
    /// \brief This is the scope for a function-level C++ try or catch scope.
    public static final /*uint*/int FnTryCatchScope = 0x4000;
    
    /// \brief This is the scope of OpenMP executable directive.
    public static final /*uint*/int OpenMPDirectiveScope = 0x8000;
    
    /// \brief This is the scope of some OpenMP loop directive.
    public static final /*uint*/int OpenMPLoopDirectiveScope = 0x10000;
    
    /// \brief This is the scope of some OpenMP simd directive.
    /// For example, it is used for 'omp simd', 'omp for simd'.
    /// This flag is propagated to children scopes.
    public static final /*uint*/int OpenMPSimdDirectiveScope = 0x20000;
    
    /// This scope corresponds to an enum.
    public static final /*uint*/int EnumScope = 0x40000;
    
    /// This scope corresponds to an SEH try.
    public static final /*uint*/int SEHTryScope = 0x80000;
    
    /// This scope corresponds to an SEH except.
    public static final /*uint*/int SEHExceptScope = 0x100000;
    
    /// We are currently in the filter expression of an SEH except block.
    public static final /*uint*/int SEHFilterScope = 0x200000;
  };
/*private:*/
  /// The parent scope for this scope.  This is null for the translation-unit
  /// scope.
  private Scope /*P*/ AnyParent;
  
  /// Flags - This contains a set of ScopeFlags, which indicates how the scope
  /// interrelates with other control flow statements.
  private /*uint*/int Flags;
  
  /// Depth - This is the depth of this scope.  The translation-unit scope has
  /// depth 0.
  private /*ushort*/char Depth;
  
  /// \brief Declarations with static linkage are mangled with the number of
  /// scopes seen as a component.
  private /*ushort*/char MSLastManglingNumber;
  
  private /*ushort*/char MSCurManglingNumber;
  
  /// PrototypeDepth - This is the number of function prototype scopes
  /// enclosing this scope, including this scope.
  private /*ushort*/char PrototypeDepth;
  
  /// PrototypeIndex - This is the number of parameters currently
  /// declared in this scope.
  private /*ushort*/char PrototypeIndex;
  
  /// FnParent - If this scope has a parent scope that is a function body, this
  /// pointer is non-null and points to it.  This is used for label processing.
  private Scope /*P*/ FnParent;
  private Scope /*P*/ MSLastManglingParent;
  
  /// BreakParent/ContinueParent - This is a direct link to the innermost
  /// BreakScope/ContinueScope which contains the contents of this scope
  /// for control flow purposes (and might be this scope itself), or null
  /// if there is no such scope.
  private Scope /*P*/ BreakParent;
  private Scope /*P*/ ContinueParent;
  
  /// BlockParent - This is a direct link to the immediately containing
  /// BlockScope if this scope is not one, or null if there is none.
  private Scope /*P*/ BlockParent;
  
  /// TemplateParamParent - This is a direct link to the
  /// immediately containing template parameter scope. In the
  /// case of nested templates, template parameter scopes can have
  /// other template parameter scopes as parents.
  private Scope /*P*/ TemplateParamParent;
  
  /// DeclsInScope - This keeps track of all declarations in this scope.  When
  /// the declaration is added to the scope, it is set as the current
  /// declaration for the identifier in the IdentifierTable.  When the scope is
  /// popped, these declarations are removed from the IdentifierTable's notion
  /// of current declaration.  It is up to the current Action implementation to
  /// implement these semantics.
  /*typedef llvm::SmallPtrSet<Decl *, 32> DeclSetTy*/
//  public final class DeclSetTy extends SmallPtrSet<Decl /*P*/ >{ };
  private SmallPtrSet<Decl /*P*/ > DeclsInScope;
  
  /// The DeclContext with which this scope is associated. For
  /// example, the entity of a class scope is the class itself, the
  /// entity of a function scope is a function, etc.
  private DeclContext /*P*/ Entity;
  
  /*typedef SmallVector<UsingDirectiveDecl *, 2> UsingDirectivesTy*/
//  public final class UsingDirectivesTy extends SmallVector<UsingDirectiveDecl /*P*/>{ };
  private SmallVector<UsingDirectiveDecl /*P*/> UsingDirectives;
  
  /// \brief Used to determine if errors occurred in this scope.
  private DiagnosticErrorTrap ErrorTrap;
  
  /// A lattice consisting of undefined, a single NRVO candidate variable in
  /// this scope, or over-defined. The bit is true when over-defined.
  private PointerBoolPair<VarDecl /*P*/ > NRVO;
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::setFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp", line = 21,
   FQN="clang::Scope::setFlags", NM="_ZN5clang5Scope8setFlagsEPS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp -nm=_ZN5clang5Scope8setFlagsEPS0_j")
  //</editor-fold>
  private void setFlags(Scope /*P*/ parent, /*uint*/int flags) {
    AnyParent = parent;
    Flags = flags;
    if ((parent != null) && !((flags & ScopeFlags.FnScope) != 0)) {
      BreakParent = parent.BreakParent;
      ContinueParent = parent.ContinueParent;
    } else {
      // Control scopes do not contain the contents of nested function scopes for
      // control flow purposes.
      BreakParent = ContinueParent = null;
    }
    if ((parent != null)) {
      Depth = $int2ushort($ushort2int(parent.Depth) + 1);
      PrototypeDepth = parent.PrototypeDepth;
      PrototypeIndex = 0;
      FnParent = parent.FnParent;
      BlockParent = parent.BlockParent;
      TemplateParamParent = parent.TemplateParamParent;
      MSLastManglingParent = parent.MSLastManglingParent;
      MSCurManglingNumber = $uint2ushort(getMSLastManglingNumber());
      if ((Flags & (ScopeFlags.FnScope | ScopeFlags.ClassScope | ScopeFlags.BlockScope | ScopeFlags.TemplateParamScope
         | ScopeFlags.FunctionPrototypeScope | ScopeFlags.AtCatchScope | ScopeFlags.ObjCMethodScope))
         == 0) {
        Flags |= parent.getFlags() & ScopeFlags.OpenMPSimdDirectiveScope;
      }
    } else {
      Depth = 0;
      PrototypeDepth = 0;
      PrototypeIndex = 0;
      MSLastManglingParent = FnParent = BlockParent = null;
      TemplateParamParent = null;
      MSLastManglingNumber = 1;
      MSCurManglingNumber = 1;
    }
    
    // If this scope is a function or contains breaks/continues, remember it.
    if (((flags & ScopeFlags.FnScope) != 0)) {
      FnParent = this;
    }
    // The MS mangler uses the number of scopes that can hold declarations as
    // part of an external name.
    if (((Flags & (ScopeFlags.ClassScope | ScopeFlags.FnScope)) != 0)) {
      MSLastManglingNumber = $uint2ushort(getMSLastManglingNumber());
      MSLastManglingParent = this;
      MSCurManglingNumber = 1;
    }
    if (((flags & ScopeFlags.BreakScope) != 0)) {
      BreakParent = this;
    }
    if (((flags & ScopeFlags.ContinueScope) != 0)) {
      ContinueParent = this;
    }
    if (((flags & ScopeFlags.BlockScope) != 0)) {
      BlockParent = this;
    }
    if (((flags & ScopeFlags.TemplateParamScope) != 0)) {
      TemplateParamParent = this;
    }
    
    // If this is a prototype scope, record that.
    if (((flags & ScopeFlags.FunctionPrototypeScope) != 0)) {
      PrototypeDepth++;
    }
    if (((flags & ScopeFlags.DeclScope) != 0)) {
      if (((flags & ScopeFlags.FunctionPrototypeScope) != 0)) {
        ; // Prototype scopes are uninteresting.
      } else if (((flags & ScopeFlags.ClassScope) != 0) && getParent().isClassScope()) {
        ; // Nested class scopes aren't ambiguous.
      } else if (((flags & ScopeFlags.ClassScope) != 0) && getParent().getFlags() == ScopeFlags.DeclScope) {
        ; // Classes inside of namespaces aren't ambiguous.
      } else if (((flags & ScopeFlags.EnumScope) != 0)) {
        ; // Don't increment for enum scopes.
      } else {
        incrementMSManglingNumber();
      }
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::Scope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 203,
   FQN="clang::Scope::Scope", NM="_ZN5clang5ScopeC1EPS0_jRNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5ScopeC1EPS0_jRNS_17DiagnosticsEngineE")
  //</editor-fold>
  public Scope(Scope /*P*/ Parent, /*uint*/int ScopeFlags, final DiagnosticsEngine /*&*/ Diag) {
    // : DeclsInScope(), UsingDirectives(), ErrorTrap(Diag), NRVO() 
    //START JInit
    this.DeclsInScope = new SmallPtrSet<Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    this.UsingDirectives = new SmallVector<UsingDirectiveDecl /*P*/>(2, null);
    this.ErrorTrap = new DiagnosticErrorTrap(Diag);
    this.NRVO = new PointerBoolPair<VarDecl /*P*/ >();
    //END JInit
    Init(Parent, ScopeFlags);
  }

  
  /// getFlags - Return the flags for this scope.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 210,
   FQN="clang::Scope::getFlags", NM="_ZNK5clang5Scope8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope8getFlagsEv")
  //</editor-fold>
  public /*uint*/int getFlags() /*const*/ {
    return Flags;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::setFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 211,
   FQN="clang::Scope::setFlags", NM="_ZN5clang5Scope8setFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope8setFlagsEj")
  //</editor-fold>
  public void setFlags(/*uint*/int F) {
    setFlags(getParent(), F);
  }

  
  /// isBlockScope - Return true if this scope correspond to a closure.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isBlockScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 214,
   FQN="clang::Scope::isBlockScope", NM="_ZNK5clang5Scope12isBlockScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope12isBlockScopeEv")
  //</editor-fold>
  public boolean isBlockScope() /*const*/ {
    return ((Flags & ScopeFlags.BlockScope) != 0);
  }

  
  /// getParent - Return the scope that this is nested in.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 218,
   FQN="clang::Scope::getParent", NM="_ZNK5clang5Scope9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope9getParentEv")
  //</editor-fold>
  public /*const*/ Scope /*P*/ getParent$Const() /*const*/ {
    return AnyParent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 219,
   FQN="clang::Scope::getParent", NM="_ZN5clang5Scope9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope9getParentEv")
  //</editor-fold>
  public Scope /*P*/ getParent() {
    return AnyParent;
  }

  
  /// getFnParent - Return the closest scope that is a function body.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getFnParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 223,
   FQN="clang::Scope::getFnParent", NM="_ZNK5clang5Scope11getFnParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope11getFnParentEv")
  //</editor-fold>
  public /*const*/ Scope /*P*/ getFnParent$Const() /*const*/ {
    return FnParent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getFnParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 224,
   FQN="clang::Scope::getFnParent", NM="_ZN5clang5Scope11getFnParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope11getFnParentEv")
  //</editor-fold>
  public Scope /*P*/ getFnParent() {
    return FnParent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getMSLastManglingParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 226,
   FQN="clang::Scope::getMSLastManglingParent", NM="_ZNK5clang5Scope23getMSLastManglingParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope23getMSLastManglingParentEv")
  //</editor-fold>
  public /*const*/ Scope /*P*/ getMSLastManglingParent$Const() /*const*/ {
    return MSLastManglingParent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getMSLastManglingParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 229,
   FQN="clang::Scope::getMSLastManglingParent", NM="_ZN5clang5Scope23getMSLastManglingParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope23getMSLastManglingParentEv")
  //</editor-fold>
  public Scope /*P*/ getMSLastManglingParent() {
    return MSLastManglingParent;
  }

  
  /// getContinueParent - Return the closest scope that a continue statement
  /// would be affected by.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getContinueParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 233,
   FQN="clang::Scope::getContinueParent", NM="_ZN5clang5Scope17getContinueParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope17getContinueParentEv")
  //</editor-fold>
  public Scope /*P*/ getContinueParent() {
    return ContinueParent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getContinueParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 237,
   FQN="clang::Scope::getContinueParent", NM="_ZNK5clang5Scope17getContinueParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope17getContinueParentEv")
  //</editor-fold>
  public /*const*/ Scope /*P*/ getContinueParent$Const() /*const*/ {
    return ((/*const_cast*/Scope /*P*/ )(this)).getContinueParent();
  }

  
  /// getBreakParent - Return the closest scope that a break statement
  /// would be affected by.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getBreakParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 243,
   FQN="clang::Scope::getBreakParent", NM="_ZN5clang5Scope14getBreakParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope14getBreakParentEv")
  //</editor-fold>
  public Scope /*P*/ getBreakParent() {
    return BreakParent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getBreakParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 246,
   FQN="clang::Scope::getBreakParent", NM="_ZNK5clang5Scope14getBreakParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope14getBreakParentEv")
  //</editor-fold>
  public /*const*/ Scope /*P*/ getBreakParent$Const() /*const*/ {
    return ((/*const_cast*/Scope /*P*/ )(this)).getBreakParent();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getBlockParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 250,
   FQN="clang::Scope::getBlockParent", NM="_ZN5clang5Scope14getBlockParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope14getBlockParentEv")
  //</editor-fold>
  public Scope /*P*/ getBlockParent() {
    return BlockParent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getBlockParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 251,
   FQN="clang::Scope::getBlockParent", NM="_ZNK5clang5Scope14getBlockParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope14getBlockParentEv")
  //</editor-fold>
  public /*const*/ Scope /*P*/ getBlockParent$Const() /*const*/ {
    return BlockParent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getTemplateParamParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 253,
   FQN="clang::Scope::getTemplateParamParent", NM="_ZN5clang5Scope22getTemplateParamParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope22getTemplateParamParentEv")
  //</editor-fold>
  public Scope /*P*/ getTemplateParamParent() {
    return TemplateParamParent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getTemplateParamParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 254,
   FQN="clang::Scope::getTemplateParamParent", NM="_ZNK5clang5Scope22getTemplateParamParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope22getTemplateParamParentEv")
  //</editor-fold>
  public /*const*/ Scope /*P*/ getTemplateParamParent$Const() /*const*/ {
    return TemplateParamParent;
  }

  
  /// Returns the number of function prototype scopes in this scope
  /// chain.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getFunctionPrototypeDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 258,
   FQN="clang::Scope::getFunctionPrototypeDepth", NM="_ZNK5clang5Scope25getFunctionPrototypeDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope25getFunctionPrototypeDepthEv")
  //</editor-fold>
  public /*uint*/int getFunctionPrototypeDepth() /*const*/ {
    return $ushort2uint(PrototypeDepth);
  }

  
  /// Return the number of parameters declared in this function
  /// prototype, increasing it by one for the next call.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getNextFunctionPrototypeIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 264,
   FQN="clang::Scope::getNextFunctionPrototypeIndex", NM="_ZN5clang5Scope29getNextFunctionPrototypeIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope29getNextFunctionPrototypeIndexEv")
  //</editor-fold>
  public /*uint*/int getNextFunctionPrototypeIndex() {
    assert (isFunctionPrototypeScope());
    return $ushort2uint(PrototypeIndex++);
  }

  
  /*typedef llvm::iterator_range<DeclSetTy::iterator> decl_range*/
//  public final class decl_range extends iterator_range<Decl /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 270,
   FQN="clang::Scope::decls", NM="_ZNK5clang5Scope5declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope5declsEv")
  //</editor-fold>
  public iterator_range<Decl /*P*/ > decls() /*const*/ {
    return new iterator_range<Decl /*P*/ >(DeclsInScope.begin(), DeclsInScope.end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::decl_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 273,
   FQN="clang::Scope::decl_empty", NM="_ZNK5clang5Scope10decl_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope10decl_emptyEv")
  //</editor-fold>
  public boolean decl_empty() /*const*/ {
    return DeclsInScope.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::AddDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 275,
   FQN="clang::Scope::AddDecl", NM="_ZN5clang5Scope7AddDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope7AddDeclEPNS_4DeclE")
  //</editor-fold>
  public void AddDecl(Decl /*P*/ D) {
    DeclsInScope.insert(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::RemoveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 279,
   FQN="clang::Scope::RemoveDecl", NM="_ZN5clang5Scope10RemoveDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope10RemoveDeclEPNS_4DeclE")
  //</editor-fold>
  public void RemoveDecl(Decl /*P*/ D) {
    DeclsInScope.erase(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::incrementMSManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 283,
   FQN="clang::Scope::incrementMSManglingNumber", NM="_ZN5clang5Scope25incrementMSManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope25incrementMSManglingNumberEv")
  //</editor-fold>
  public void incrementMSManglingNumber() {
    {
      Scope /*P*/ MSLMP = getMSLastManglingParent();
      if ((MSLMP != null)) {
        MSLMP.MSLastManglingNumber += 1;
        MSCurManglingNumber += 1;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::decrementMSManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 290,
   FQN="clang::Scope::decrementMSManglingNumber", NM="_ZN5clang5Scope25decrementMSManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope25decrementMSManglingNumberEv")
  //</editor-fold>
  public void decrementMSManglingNumber() {
    {
      Scope /*P*/ MSLMP = getMSLastManglingParent();
      if ((MSLMP != null)) {
        MSLMP.MSLastManglingNumber -= 1;
        MSCurManglingNumber -= 1;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getMSLastManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 297,
   FQN="clang::Scope::getMSLastManglingNumber", NM="_ZNK5clang5Scope23getMSLastManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope23getMSLastManglingNumberEv")
  //</editor-fold>
  public /*uint*/int getMSLastManglingNumber() /*const*/ {
    {
      /*const*/ Scope /*P*/ MSLMP = getMSLastManglingParent$Const();
      if ((MSLMP != null)) {
        return $ushort2uint(MSLMP.MSLastManglingNumber);
      }
    }
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getMSCurManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 303,
   FQN="clang::Scope::getMSCurManglingNumber", NM="_ZNK5clang5Scope22getMSCurManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope22getMSCurManglingNumberEv")
  //</editor-fold>
  public /*uint*/int getMSCurManglingNumber() /*const*/ {
    return $ushort2uint(MSCurManglingNumber);
  }

  
  /// isDeclScope - Return true if this is the scope that the specified decl is
  /// declared in.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isDeclScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 309,
   FQN="clang::Scope::isDeclScope", NM="_ZN5clang5Scope11isDeclScopeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope11isDeclScopeEPNS_4DeclE")
  //</editor-fold>
  public boolean isDeclScope(Decl /*P*/ D) {
    return DeclsInScope.count(D) != 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::getEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 313,
   FQN="clang::Scope::getEntity", NM="_ZNK5clang5Scope9getEntityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope9getEntityEv")
  //</editor-fold>
  public DeclContext /*P*/ getEntity() /*const*/ {
    return Entity;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::setEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 314,
   FQN="clang::Scope::setEntity", NM="_ZN5clang5Scope9setEntityEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope9setEntityEPNS_11DeclContextE")
  //</editor-fold>
  public void setEntity(DeclContext /*P*/ E) {
    Entity = E;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::hasErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 316,
   FQN="clang::Scope::hasErrorOccurred", NM="_ZNK5clang5Scope16hasErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope16hasErrorOccurredEv")
  //</editor-fold>
  public boolean hasErrorOccurred() /*const*/ {
    return ErrorTrap.hasErrorOccurred();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::hasUnrecoverableErrorOccurred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 318,
   FQN="clang::Scope::hasUnrecoverableErrorOccurred", NM="_ZNK5clang5Scope29hasUnrecoverableErrorOccurredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope29hasUnrecoverableErrorOccurredEv")
  //</editor-fold>
  public boolean hasUnrecoverableErrorOccurred() /*const*/ {
    return ErrorTrap.hasUnrecoverableErrorOccurred();
  }

  
  /// isFunctionScope() - Return true if this scope is a function scope.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isFunctionScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 323,
   FQN="clang::Scope::isFunctionScope", NM="_ZNK5clang5Scope15isFunctionScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope15isFunctionScopeEv")
  //</editor-fold>
  public boolean isFunctionScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.FnScope) != 0);
  }

  
  /// isClassScope - Return true if this scope is a class/struct/union scope.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isClassScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 326,
   FQN="clang::Scope::isClassScope", NM="_ZNK5clang5Scope12isClassScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope12isClassScopeEv")
  //</editor-fold>
  public boolean isClassScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.ClassScope) != 0);
  }

  
  /// isInCXXInlineMethodScope - Return true if this scope is a C++ inline
  /// method scope or is inside one.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isInCXXInlineMethodScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 332,
   FQN="clang::Scope::isInCXXInlineMethodScope", NM="_ZNK5clang5Scope24isInCXXInlineMethodScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope24isInCXXInlineMethodScopeEv")
  //</editor-fold>
  public boolean isInCXXInlineMethodScope() /*const*/ {
    {
      /*const*/ Scope /*P*/ FnS = getFnParent$Const();
      if ((FnS != null)) {
        assert ((FnS.getParent$Const() != null)) : "TUScope not created?";
        return FnS.getParent$Const().isClassScope();
      }
    }
    return false;
  }

  
  /// isInObjcMethodScope - Return true if this scope is, or is contained in, an
  /// Objective-C method body.  Note that this method is not constant time.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isInObjcMethodScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 342,
   FQN="clang::Scope::isInObjcMethodScope", NM="_ZNK5clang5Scope19isInObjcMethodScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope19isInObjcMethodScopeEv")
  //</editor-fold>
  public boolean isInObjcMethodScope() /*const*/ {
    for (/*const*/ Scope /*P*/ S = this; (S != null); S = S.getParent$Const()) {
      // If this scope is an objc method scope, then we succeed.
      if (((S.getFlags() & ScopeFlags.ObjCMethodScope) != 0)) {
        return true;
      }
    }
    return false;
  }

  
  /// isInObjcMethodOuterScope - Return true if this scope is an
  /// Objective-C method outer most body.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isInObjcMethodOuterScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 353,
   FQN="clang::Scope::isInObjcMethodOuterScope", NM="_ZNK5clang5Scope24isInObjcMethodOuterScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope24isInObjcMethodOuterScopeEv")
  //</editor-fold>
  public boolean isInObjcMethodOuterScope() /*const*/ {
    {
      /*const*/ Scope /*P*/ S = this;
      if ((S != null)) {
        // If this scope is an objc method scope, then we succeed.
        if (((S.getFlags() & ScopeFlags.ObjCMethodScope) != 0)) {
          return true;
        }
      }
    }
    return false;
  }

  
  /// isTemplateParamScope - Return true if this scope is a C++
  /// template parameter scope.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isTemplateParamScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 365,
   FQN="clang::Scope::isTemplateParamScope", NM="_ZNK5clang5Scope20isTemplateParamScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope20isTemplateParamScopeEv")
  //</editor-fold>
  public boolean isTemplateParamScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.TemplateParamScope) != 0);
  }

  
  /// isFunctionPrototypeScope - Return true if this scope is a
  /// function prototype scope.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isFunctionPrototypeScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 371,
   FQN="clang::Scope::isFunctionPrototypeScope", NM="_ZNK5clang5Scope24isFunctionPrototypeScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope24isFunctionPrototypeScopeEv")
  //</editor-fold>
  public boolean isFunctionPrototypeScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.FunctionPrototypeScope) != 0);
  }

  
  /// isAtCatchScope - Return true if this scope is \@catch.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isAtCatchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 376,
   FQN="clang::Scope::isAtCatchScope", NM="_ZNK5clang5Scope14isAtCatchScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope14isAtCatchScopeEv")
  //</editor-fold>
  public boolean isAtCatchScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.AtCatchScope) != 0);
  }

  
  /// isSwitchScope - Return true if this scope is a switch scope.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isSwitchScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 381,
   FQN="clang::Scope::isSwitchScope", NM="_ZNK5clang5Scope13isSwitchScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope13isSwitchScopeEv")
  //</editor-fold>
  public boolean isSwitchScope() /*const*/ {
    for (/*const*/ Scope /*P*/ S = this; (S != null); S = S.getParent$Const()) {
      if (((S.getFlags() & Scope.ScopeFlags.SwitchScope) != 0)) {
        return true;
      } else if (((S.getFlags() & (Scope.ScopeFlags.FnScope | Scope.ScopeFlags.ClassScope
         | Scope.ScopeFlags.BlockScope | Scope.ScopeFlags.TemplateParamScope
         | Scope.ScopeFlags.FunctionPrototypeScope
         | Scope.ScopeFlags.AtCatchScope | Scope.ScopeFlags.ObjCMethodScope)) != 0)) {
        return false;
      }
    }
    return false;
  }

  
  /// \brief Determines whether this scope is the OpenMP directive scope
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isOpenMPDirectiveScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 395,
   FQN="clang::Scope::isOpenMPDirectiveScope", NM="_ZNK5clang5Scope22isOpenMPDirectiveScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope22isOpenMPDirectiveScopeEv")
  //</editor-fold>
  public boolean isOpenMPDirectiveScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.OpenMPDirectiveScope) != 0);
  }

  
  /// \brief Determine whether this scope is some OpenMP loop directive scope
  /// (for example, 'omp for', 'omp simd').
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isOpenMPLoopDirectiveScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 401,
   FQN="clang::Scope::isOpenMPLoopDirectiveScope", NM="_ZNK5clang5Scope26isOpenMPLoopDirectiveScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope26isOpenMPLoopDirectiveScopeEv")
  //</editor-fold>
  public boolean isOpenMPLoopDirectiveScope() /*const*/ {
    if (((getFlags() & Scope.ScopeFlags.OpenMPLoopDirectiveScope) != 0)) {
      assert (isOpenMPDirectiveScope()) : "OpenMP loop directive scope is not a directive scope";
      return true;
    }
    return false;
  }

  
  /// \brief Determine whether this scope is (or is nested into) some OpenMP
  /// loop simd directive scope (for example, 'omp simd', 'omp for simd').
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isOpenMPSimdDirectiveScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 412,
   FQN="clang::Scope::isOpenMPSimdDirectiveScope", NM="_ZNK5clang5Scope26isOpenMPSimdDirectiveScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope26isOpenMPSimdDirectiveScopeEv")
  //</editor-fold>
  public boolean isOpenMPSimdDirectiveScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.OpenMPSimdDirectiveScope) != 0);
  }

  
  /// \brief Determine whether this scope is a loop having OpenMP loop
  /// directive attached.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isOpenMPLoopScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 418,
   FQN="clang::Scope::isOpenMPLoopScope", NM="_ZNK5clang5Scope17isOpenMPLoopScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope17isOpenMPLoopScopeEv")
  //</editor-fold>
  public boolean isOpenMPLoopScope() /*const*/ {
    /*const*/ Scope /*P*/ P = getParent$Const();
    return (P != null) && P.isOpenMPLoopDirectiveScope();
  }

  
  /// \brief Determine whether this scope is a C++ 'try' block.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isTryScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 424,
   FQN="clang::Scope::isTryScope", NM="_ZNK5clang5Scope10isTryScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope10isTryScopeEv")
  //</editor-fold>
  public boolean isTryScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.TryScope) != 0);
  }

  
  /// \brief Determine whether this scope is a SEH '__try' block.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isSEHTryScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 427,
   FQN="clang::Scope::isSEHTryScope", NM="_ZNK5clang5Scope13isSEHTryScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope13isSEHTryScopeEv")
  //</editor-fold>
  public boolean isSEHTryScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.SEHTryScope) != 0);
  }

  
  /// \brief Determine whether this scope is a SEH '__except' block.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::isSEHExceptScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 430,
   FQN="clang::Scope::isSEHExceptScope", NM="_ZNK5clang5Scope16isSEHExceptScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope16isSEHExceptScopeEv")
  //</editor-fold>
  public boolean isSEHExceptScope() /*const*/ {
    return ((getFlags() & Scope.ScopeFlags.SEHExceptScope) != 0);
  }

  
  /// \brief Returns if rhs has a higher scope depth than this.
  ///
  /// The caller is responsible for calling this only if one of the two scopes
  /// is an ancestor of the other.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::Contains">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 436,
   FQN="clang::Scope::Contains", NM="_ZNK5clang5Scope8ContainsERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang5Scope8ContainsERKS0_")
  //</editor-fold>
  public boolean Contains(final /*const*/ Scope /*&*/ rhs) /*const*/ {
    return $ushort2int(Depth) < $ushort2int(rhs.Depth);
  }

  
  /// containedInPrototypeScope - Return true if this or a parent scope
  /// is a FunctionPrototypeScope.
  
  /// containedInPrototypeScope - Return true if this or a parent scope
  /// is a FunctionPrototypeScope.
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::containedInPrototypeScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp", line = 98,
   FQN="clang::Scope::containedInPrototypeScope", NM="_ZNK5clang5Scope25containedInPrototypeScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp -nm=_ZNK5clang5Scope25containedInPrototypeScopeEv")
  //</editor-fold>
  public boolean containedInPrototypeScope() /*const*/ {
    /*const*/ Scope /*P*/ S = this;
    while ((S != null)) {
      if (S.isFunctionPrototypeScope()) {
        return true;
      }
      S = S.getParent$Const();
    }
    return false;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::PushUsingDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 442,
   FQN="clang::Scope::PushUsingDirective", NM="_ZN5clang5Scope18PushUsingDirectiveEPNS_18UsingDirectiveDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope18PushUsingDirectiveEPNS_18UsingDirectiveDeclE")
  //</editor-fold>
  public void PushUsingDirective(UsingDirectiveDecl /*P*/ UDir) {
    UsingDirectives.push_back(UDir);
  }

  
  /*typedef llvm::iterator_range<UsingDirectivesTy::iterator> using_directives_range*/
//  public final class using_directives_range extends iterator_range<UsingDirectiveDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::using_directives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 449,
   FQN="clang::Scope::using_directives", NM="_ZN5clang5Scope16using_directivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope16using_directivesEv")
  //</editor-fold>
  public iterator_range<UsingDirectiveDecl /*P*/ > using_directives() {
    return new iterator_range<UsingDirectiveDecl /*P*/ >(UsingDirectives.begin(), 
        UsingDirectives.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::addNRVOCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 454,
   FQN="clang::Scope::addNRVOCandidate", NM="_ZN5clang5Scope16addNRVOCandidateEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope16addNRVOCandidateEPNS_7VarDeclE")
  //</editor-fold>
  public void addNRVOCandidate(VarDecl /*P*/ VD) {
    if (NRVO.getInt()) {
      return;
    }
    if (NRVO.getPointer() == null) {
      NRVO.setPointer(VD);
      return;
    }
    if (NRVO.getPointer() != VD) {
      setNoNRVO();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::setNoNRVO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 465,
   FQN="clang::Scope::setNoNRVO", NM="_ZN5clang5Scope9setNoNRVOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5Scope9setNoNRVOEv")
  //</editor-fold>
  public void setNoNRVO() {
    NRVO.setInt(true);
    NRVO.setPointer((VarDecl /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Scope::mergeNRVOIntoParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp", line = 122,
   FQN="clang::Scope::mergeNRVOIntoParent", NM="_ZN5clang5Scope19mergeNRVOIntoParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp -nm=_ZN5clang5Scope19mergeNRVOIntoParentEv")
  //</editor-fold>
  public void mergeNRVOIntoParent() {
    {
      VarDecl /*P*/ Candidate = NRVO.getPointer();
      if ((Candidate != null)) {
        if (isDeclScope(Candidate)) {
          Candidate.setNRVOVariable(true);
        }
      }
    }
    if ((getEntity() != null)) {
      return;
    }
    if (NRVO.getInt()) {
      getParent().setNoNRVO();
    } else if ((NRVO.getPointer() != null)) {
      getParent().addNRVOCandidate(NRVO.getPointer());
    }
  }


  
  /// Init - This is used by the parser to implement scope caching.
  ///
  
  /// Init - This is used by the parser to implement scope caching.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::Init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp", line = 88,
   FQN="clang::Scope::Init", NM="_ZN5clang5Scope4InitEPS0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp -nm=_ZN5clang5Scope4InitEPS0_j")
  //</editor-fold>
  public void Init(Scope /*P*/ parent, /*uint*/int flags) {
    setFlags(parent, flags);
    
    DeclsInScope.clear();
    UsingDirectives.clear();
    Entity = null;
    ErrorTrap.reset();
    NRVO.setPointerAndInt((VarDecl /*P*/ )null, false);
  }


  
  /// \brief Sets up the specified scope flags and adjusts the scope state
  /// variables accordingly.
  ///
  
  /// \brief Sets up the specified scope flags and adjusts the scope state
  /// variables accordingly.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Scope::AddFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp", line = 108,
   FQN="clang::Scope::AddFlags", NM="_ZN5clang5Scope8AddFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp -nm=_ZN5clang5Scope8AddFlagsEj")
  //</editor-fold>
  public void AddFlags(/*uint*/int FlagsToSet) {
    assert ((FlagsToSet & ~(ScopeFlags.BreakScope | ScopeFlags.ContinueScope)) == 0) : "Unsupported scope flags";
    if (((FlagsToSet & ScopeFlags.BreakScope) != 0)) {
      assert ((Flags & ScopeFlags.BreakScope) == 0) : "Already set";
      BreakParent = this;
    }
    if (((FlagsToSet & ScopeFlags.ContinueScope) != 0)) {
      assert ((Flags & ScopeFlags.ContinueScope) == 0) : "Already set";
      ContinueParent = this;
    }
    Flags |= FlagsToSet;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Scope::dumpImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp", line = 139,
   FQN="clang::Scope::dumpImpl", NM="_ZNK5clang5Scope8dumpImplERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp -nm=_ZNK5clang5Scope8dumpImplERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpImpl(final raw_ostream /*&*/ OS) /*const*/ {
    /*uint*/int Flags = getFlags();
    boolean HasFlags = Flags != 0;
    if (HasFlags) {
      OS.$out(/*KEEP_STR*/"Flags: ");
    }
    while ((Flags != 0)) {
      if (((Flags & ScopeFlags.FnScope) != 0)) {
        OS.$out(/*KEEP_STR*/"FnScope");
        Flags &= ~ScopeFlags.FnScope;
      } else if (((Flags & ScopeFlags.BreakScope) != 0)) {
        OS.$out(/*KEEP_STR*/"BreakScope");
        Flags &= ~ScopeFlags.BreakScope;
      } else if (((Flags & ScopeFlags.ContinueScope) != 0)) {
        OS.$out(/*KEEP_STR*/"ContinueScope");
        Flags &= ~ScopeFlags.ContinueScope;
      } else if (((Flags & ScopeFlags.DeclScope) != 0)) {
        OS.$out(/*KEEP_STR*/"DeclScope");
        Flags &= ~ScopeFlags.DeclScope;
      } else if (((Flags & ScopeFlags.ControlScope) != 0)) {
        OS.$out(/*KEEP_STR*/"ControlScope");
        Flags &= ~ScopeFlags.ControlScope;
      } else if (((Flags & ScopeFlags.ClassScope) != 0)) {
        OS.$out(/*KEEP_STR*/"ClassScope");
        Flags &= ~ScopeFlags.ClassScope;
      } else if (((Flags & ScopeFlags.BlockScope) != 0)) {
        OS.$out(/*KEEP_STR*/"BlockScope");
        Flags &= ~ScopeFlags.BlockScope;
      } else if (((Flags & ScopeFlags.TemplateParamScope) != 0)) {
        OS.$out(/*KEEP_STR*/"TemplateParamScope");
        Flags &= ~ScopeFlags.TemplateParamScope;
      } else if (((Flags & ScopeFlags.FunctionPrototypeScope) != 0)) {
        OS.$out(/*KEEP_STR*/"FunctionPrototypeScope");
        Flags &= ~ScopeFlags.FunctionPrototypeScope;
      } else if (((Flags & ScopeFlags.FunctionDeclarationScope) != 0)) {
        OS.$out(/*KEEP_STR*/"FunctionDeclarationScope");
        Flags &= ~ScopeFlags.FunctionDeclarationScope;
      } else if (((Flags & ScopeFlags.AtCatchScope) != 0)) {
        OS.$out(/*KEEP_STR*/"AtCatchScope");
        Flags &= ~ScopeFlags.AtCatchScope;
      } else if (((Flags & ScopeFlags.ObjCMethodScope) != 0)) {
        OS.$out(/*KEEP_STR*/"ObjCMethodScope");
        Flags &= ~ScopeFlags.ObjCMethodScope;
      } else if (((Flags & ScopeFlags.SwitchScope) != 0)) {
        OS.$out(/*KEEP_STR*/"SwitchScope");
        Flags &= ~ScopeFlags.SwitchScope;
      } else if (((Flags & ScopeFlags.TryScope) != 0)) {
        OS.$out(/*KEEP_STR*/"TryScope");
        Flags &= ~ScopeFlags.TryScope;
      } else if (((Flags & ScopeFlags.FnTryCatchScope) != 0)) {
        OS.$out(/*KEEP_STR*/"FnTryCatchScope");
        Flags &= ~ScopeFlags.FnTryCatchScope;
      } else if (((Flags & ScopeFlags.SEHTryScope) != 0)) {
        OS.$out(/*KEEP_STR*/"SEHTryScope");
        Flags &= ~ScopeFlags.SEHTryScope;
      } else if (((Flags & ScopeFlags.SEHExceptScope) != 0)) {
        OS.$out(/*KEEP_STR*/"SEHExceptScope");
        Flags &= ~ScopeFlags.SEHExceptScope;
      } else if (((Flags & ScopeFlags.OpenMPDirectiveScope) != 0)) {
        OS.$out(/*KEEP_STR*/"OpenMPDirectiveScope");
        Flags &= ~ScopeFlags.OpenMPDirectiveScope;
      } else if (((Flags & ScopeFlags.OpenMPLoopDirectiveScope) != 0)) {
        OS.$out(/*KEEP_STR*/"OpenMPLoopDirectiveScope");
        Flags &= ~ScopeFlags.OpenMPLoopDirectiveScope;
      } else if (((Flags & ScopeFlags.OpenMPSimdDirectiveScope) != 0)) {
        OS.$out(/*KEEP_STR*/"OpenMPSimdDirectiveScope");
        Flags &= ~ScopeFlags.OpenMPSimdDirectiveScope;
      }
      if ((Flags != 0)) {
        OS.$out(/*KEEP_STR*/" | ");
      }
    }
    if (HasFlags) {
      OS.$out_char($$LF);
    }
    {
      
      /*const*/ Scope /*P*/ Parent = getParent$Const();
      if ((Parent != null)) {
        OS.$out(/*KEEP_STR*/"Parent: (clang::Scope*)").$out(Parent).$out_char($$LF);
      }
    }
    
    OS.$out(/*KEEP_STR*/"Depth: ").$out_int($ushort2int(Depth)).$out_char($$LF);
    OS.$out(/*KEEP_STR*/"MSLastManglingNumber: ").$out_uint(getMSLastManglingNumber()).$out_char($$LF);
    OS.$out(/*KEEP_STR*/"MSCurManglingNumber: ").$out_uint(getMSCurManglingNumber()).$out_char($$LF);
    {
      /*const*/ DeclContext /*P*/ DC = getEntity();
      if ((DC != null)) {
        OS.$out(/*KEEP_STR*/"Entity : (clang::DeclContext*)").$out(DC).$out_char($$LF);
      }
    }
    if (NRVO.getInt()) {
      OS.$out(/*KEEP_STR*/"NRVO not allowed\n");
    } else if ((NRVO.getPointer() != null)) {
      OS.$out(/*KEEP_STR*/"NRVO candidate : (clang::VarDecl*)").$out(NRVO.getPointer()).$out_char($$LF);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Scope::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp", line = 137,
   FQN="clang::Scope::dump", NM="_ZNK5clang5Scope4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Scope.cpp -nm=_ZNK5clang5Scope4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpImpl(llvm.errs());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Scope::~Scope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Scope.h", line = 39,
   FQN="clang::Scope::~Scope", NM="_ZN5clang5ScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang5ScopeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    UsingDirectives.$destroy();
    DeclsInScope.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + ", Entity=" + "[DeclContext:" + NativeTrace.getIdentityStr(Entity) + "]" // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", Depth=" + $ushort2uint(Depth) // NOI18N
              + "AnyParent=" + NativeTrace.getIdentityStr(AnyParent) // NOI18N            
              + ", PrototypeDepth=" + $ushort2uint(PrototypeDepth) // NOI18N
              + ", PrototypeIndex=" + $ushort2uint(PrototypeIndex) // NOI18N
              + ", FnParent=" + NativeTrace.getIdentityStr(FnParent) // NOI18N
              + ", MSLastManglingParent=" + NativeTrace.getIdentityStr(MSLastManglingParent) // NOI18N
              + ", MSLastManglingNumber=" + $ushort2uint(MSLastManglingNumber) // NOI18N
              + ", MSCurManglingNumber=" + $ushort2uint(MSCurManglingNumber) // NOI18N
              + ", BreakParent=" + NativeTrace.getIdentityStr(BreakParent) // NOI18N
              + ", ContinueParent=" + NativeTrace.getIdentityStr(ContinueParent) // NOI18N
              + ", BlockParent=" + NativeTrace.getIdentityStr(BlockParent) // NOI18N
              + ", TemplateParamParent=" + NativeTrace.getIdentityStr(TemplateParamParent) // NOI18N
              + ", DeclsInScope=" + DeclsInScope.size() // NOI18N
              + ", UsingDirectives=" + UsingDirectives.size() // NOI18N
              + ", ErrorTrap=" + NativeTrace.getIdentityStr(ErrorTrap) // NOI18N
              + ", NRVO=" + NRVO; // NOI18N
  }
}
