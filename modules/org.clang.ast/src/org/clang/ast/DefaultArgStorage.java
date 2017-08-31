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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.llvm.adt.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.ast.java.Common$TemplateParmDecl;


/// Storage for a default argument. This is conceptually either empty, or an
/// argument value, or a pointer to a previous declaration that had a default
/// argument.
///
/// However, this is complicated by modules: while we require all the default
/// arguments for a template to be equivalent, there may be more than one, and
/// we need to track all the originating parameters to determine if the default
/// argument is visible.
/*template <typename ParmDecl, typename ArgType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*derived typedefs should be used*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 249,
 FQN="clang::DefaultArgStorage", NM="_ZN5clang17DefaultArgStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17DefaultArgStorageE")
//</editor-fold>
public abstract class DefaultArgStorage</*typename*/ ParmDecl extends Common$TemplateParmDecl<ParmDecl, ArgType>, /*typename*/ ArgType/*P*/>  {
  /// Storage for both the value *and* another parameter from which we inherit
  /// the default argument. This is used when multiple default arguments for a
  /// parameter are merged together from different modules.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::Chain">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 254,
   FQN="clang::DefaultArgStorage::Chain", NM="_ZN5clang17DefaultArgStorage5ChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17DefaultArgStorage5ChainE")
  //</editor-fold>
  private static final class/*struct*/ Chain</*typename*/ ParmDecl extends Common$TemplateParmDecl<ParmDecl, ArgType>, /*typename*/ ArgType/*P*/> {
    public ParmDecl /*P*/ PrevDeclWithDefaultArg;
    public ArgType Value;

    public Chain(ParmDecl PrevDeclWithDefaultArg, ArgType Value) {
      this.PrevDeclWithDefaultArg = PrevDeclWithDefaultArg;
      this.Value = Value;
    }
    
    public static int $sizeof_Chain() {
      return 2 * $sizeof_ptr();
    }
    
    @Override public String toString() {
      return "" + "PrevDeclWithDefaultArg=" + PrevDeclWithDefaultArg // NOI18N
                + ", Value=" + Value; // NOI18N
    }
  };
  static { static_assert(Chain.$sizeof_Chain() == $sizeof_ptr(/*Object */) * 2, $("non-pointer argument type?")); };
  
  private final PointerUnion3<ArgType, ParmDecl /*P*/ , Chain<ParmDecl, ArgType> /*P*/ > ValueOrInherited;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::getParmOwningDefaultArg">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 263,
   FQN="clang::DefaultArgStorage::getParmOwningDefaultArg", NM="_ZN5clang17DefaultArgStorage23getParmOwningDefaultArgEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17DefaultArgStorage23getParmOwningDefaultArgEPT_")
  //</editor-fold>
  private static </*typename*/ ParmDecl extends Common$TemplateParmDecl<ParmDecl, ArgType>, /*typename*/ ArgType> ParmDecl /*P*/ getParmOwningDefaultArg(ParmDecl /*P*/ Parm) {
    Class<ParmDecl> ParmClass = (Class<ParmDecl>)Parm.getClass();
    final /*const*/ DefaultArgStorage<ParmDecl, ArgType> /*&*/ Storage = Parm.getDefaultArgStorage();
    {
      ParmDecl /*P*/ Prev = Storage.ValueOrInherited.dyn_cast(ParmClass);
      if (Prev != null) {
        Parm = Prev;
      }
    }
    assert Native.$bool(Native.$not(Parm.getDefaultArgStorage().ValueOrInherited.is(ParmClass))) : "should only be one level of indirection";
    return Parm;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::DefaultArgStorage<ParmDecl, ArgType>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*derived class must be used*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 274,
   FQN="clang::DefaultArgStorage::DefaultArgStorage<ParmDecl, ArgType>", NM="_ZN5clang17DefaultArgStorageC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17DefaultArgStorageC1Ev")
  //</editor-fold>
  protected DefaultArgStorage(Class<ArgType> ArgTypeClass) {
    // : ValueOrInherited(ArgType()) 
    //START JInit
    this.ValueOrInherited = /*ParenListExpr*/new PointerUnion3<ArgType, ParmDecl /*P*/ , Chain<ParmDecl, ArgType> /*P*/ >(ArgTypeClass);
    //END JInit
  }

  
  /// Determine whether there is a default argument for this parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::isSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 277,
   FQN="clang::DefaultArgStorage::isSet", NM="_ZNK5clang17DefaultArgStorage5isSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17DefaultArgStorage5isSetEv")
  //</editor-fold>
  public boolean isSet() /*const*/ {
    return Native.$not(ValueOrInherited.isNull());
  }

  /// Determine whether the default argument for this parameter was inherited
  /// from a previous declaration of the same entity.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::isInherited">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 280,
   FQN="clang::DefaultArgStorage::isInherited", NM="_ZNK5clang17DefaultArgStorage11isInheritedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17DefaultArgStorage11isInheritedEv")
  //</editor-fold>
  public boolean isInherited() /*const*/ {
    return ValueOrInherited.is(getParmDeclClass()) != 0;
  }

  /// Get the default argument's value. This does not consider whether the
  /// default argument is visible.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 283,
   FQN="clang::DefaultArgStorage::get", NM="_ZNK5clang17DefaultArgStorage3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17DefaultArgStorage3getEv")
  //</editor-fold>
  public ArgType get() /*const*/ {
    /*const*/ DefaultArgStorage<ParmDecl, ArgType> /*P*/ Storage = this;
    {
      ParmDecl /*P*/ Prev = ValueOrInherited.dyn_cast(this.getParmDeclClass());
      if (Prev != null) {
        Storage = Native.$addr(Prev.getDefaultArgStorage());
      }
    }
    {
      Chain<ParmDecl, ArgType> /*P*/ C = Storage.ValueOrInherited.dyn_cast(Chain.class);
      if (C != null) {
        return C.Value;
      }
    }
    return Storage.ValueOrInherited.get(this.getArgTypeClass());
  }

  /// Get the parameter from which we inherit the default argument, if any.
  /// This is the parameter on which the default argument was actually written.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::getInheritedFrom">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 293,
   FQN="clang::DefaultArgStorage::getInheritedFrom", NM="_ZNK5clang17DefaultArgStorage16getInheritedFromEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang17DefaultArgStorage16getInheritedFromEv")
  //</editor-fold>
  public /*const*/ ParmDecl /*P*/ getInheritedFrom() /*const*/ {
    {
      ParmDecl /*P*/ D = ValueOrInherited.dyn_cast(this.getParmDeclClass());
      if (D != null) {
        return D;
      }
    }
    {
      Chain<ParmDecl, ArgType> /*P*/ C = ValueOrInherited.dyn_cast(Chain.class);
      if (C != null) {
        return C.PrevDeclWithDefaultArg;
      }
    }
    return null;
  }

  /// Set the default argument.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 301,
   FQN="clang::DefaultArgStorage::set", NM="_ZN5clang17DefaultArgStorage3setET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17DefaultArgStorage3setET0_")
  //</editor-fold>
  public void set(ArgType Arg) {
    assert Native.$bool(Native.$not(isSet())) : "default argument already set";
    assert Arg == null || getArgTypeClass().isInstance(Arg);
    ValueOrInherited.$assign_T$C$R(getArgTypeClass(), Arg);
  }

  /// Set that the default argument was inherited from another parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::setInherited">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 306,
   FQN="clang::DefaultArgStorage::setInherited", NM="_ZN5clang17DefaultArgStorage12setInheritedERKNS_10ASTContextEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17DefaultArgStorage12setInheritedERKNS_10ASTContextEPT_")
  //</editor-fold>
  public void setInherited(final /*const*/ ASTContext /*&*/ C, ParmDecl /*P*/ InheritedFrom) {
    assert Native.$bool(Native.$not(isInherited())) : "default argument already inherited";
    InheritedFrom = (ParmDecl) getParmOwningDefaultArg(InheritedFrom);
    if (Native.$not(isSet())) {
      ValueOrInherited.$assign_T1$C$R(getParmDeclClass(), InheritedFrom);
    } else {      
      if (false) allocateDefaultArgStorageChain(C);
      Chain<ParmDecl, ArgType> $Chain = /*FIXME: NEW_EXPR [NoNewFun]*//*new (allocateDefaultArgStorageChain(C))*/new Chain<>(InheritedFrom, ValueOrInherited.get(getArgTypeClass()));
      ((PointerUnion3)ValueOrInherited).$assign_T2$C$R(Chain.class, $Chain);
    }
  }

  /// Remove the default argument, even if it was inherited.
  //<editor-fold defaultstate="collapsed" desc="clang::DefaultArgStorage::clear">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 316,
   FQN="clang::DefaultArgStorage::clear", NM="_ZN5clang17DefaultArgStorage5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang17DefaultArgStorage5clearEv")
  //</editor-fold>
  public void clear() {
    ValueOrInherited.$assign_T$C$R(getArgTypeClass(), null);
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected abstract Class<ParmDecl> getParmDeclClass();
  
  protected abstract Class<ArgType> getArgTypeClass();

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
    
  @Override public String toString() {
    return "" + "ValueOrInherited=" + ValueOrInherited; // NOI18N
  }
}
