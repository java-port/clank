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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 27,
 FQN="llvm::GlobalAlias", NM="_ZN4llvm11GlobalAliasE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAliasE")
//</editor-fold>
public class GlobalAlias extends /*public*/ GlobalIndirectSymbol implements /*public*/ ilist_node<GlobalAlias>, IChild<Module>, Destructors.ClassWithDestructor {
  /*friend  class SymbolTableListTraits<GlobalAlias>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 30,
   FQN="llvm::GlobalAlias::operator=", NM="_ZN4llvm11GlobalAliasaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAliasaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ GlobalAlias /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::GlobalAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 31,
   FQN="llvm::GlobalAlias::GlobalAlias", NM="_ZN4llvm11GlobalAliasC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAliasC1ERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalAlias(final /*const*/ GlobalAlias /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 362,
   FQN="llvm::GlobalAlias::setParent", NM="_ZN4llvm11GlobalAlias9setParentEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias9setParentEPNS_6ModuleE")
  //</editor-fold>
  public /*friend*//*private*/ void setParent(Module /*P*/ parent) {
    Parent = parent;
  }

  
  
  //===----------------------------------------------------------------------===//
  // GlobalAlias Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::GlobalAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 324,
   FQN="llvm::GlobalAlias::GlobalAlias", NM="_ZN4llvm11GlobalAliasC1EPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAliasC1EPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE")
  //</editor-fold>
  private GlobalAlias(Type /*P*/ Ty, /*uint*/int AddressSpace, GlobalValue.LinkageTypes Link, 
      final /*const*/ Twine /*&*/ Name, Constant /*P*/ Aliasee, 
      Module /*P*/ ParentModule) {
    // : GlobalIndirectSymbol(Ty, Value::GlobalAliasVal, AddressSpace, Link, Name, Aliasee), ilist_node<GlobalAlias>() 
    //START JInit
    super(Ty, Value.ValueTy.GlobalAliasVal, AddressSpace, Link, Name, 
        Aliasee);
    this.ilist_node$Flds = $ilist_node();
    //END JInit
    if ((ParentModule != null)) {
      ParentModule.getAliasList().push_back(this);
    }
  }

/*public:*/
  /// If a parent module is specified, the alias is automatically inserted into
  /// the end of the specified module's alias list.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 333,
   FQN="llvm::GlobalAlias::create", NM="_ZN4llvm11GlobalAlias6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE")
  //</editor-fold>
  public static GlobalAlias /*P*/ create(Type /*P*/ Ty, /*uint*/int AddressSpace, 
        GlobalValue.LinkageTypes Link, final /*const*/ Twine /*&*/ Name, 
        Constant /*P*/ Aliasee, Module /*P*/ ParentModule) {
    return /*NEW_EXPR [GlobalIndirectSymbol::new]*/GlobalIndirectSymbol.$new_GlobalIndirectSymbol((type$ptr<?> New$Mem)->{
        return new GlobalAlias(Ty, AddressSpace, Link, Name, Aliasee, ParentModule);
     });
  }

  
  // Without the Aliasee.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 339,
   FQN="llvm::GlobalAlias::create", NM="_ZN4llvm11GlobalAlias6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_6ModuleE")
  //</editor-fold>
  public static GlobalAlias /*P*/ create(Type /*P*/ Ty, /*uint*/int AddressSpace, 
        GlobalValue.LinkageTypes Linkage, final /*const*/ Twine /*&*/ Name, 
        Module /*P*/ Parent) {
    return create(Ty, AddressSpace, Linkage, Name, (Constant /*P*/ )null, Parent);
  }

  
  // The module is taken from the Aliasee.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 345,
   FQN="llvm::GlobalAlias::create", NM="_ZN4llvm11GlobalAlias6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPS3_")
  //</editor-fold>
  public static GlobalAlias /*P*/ create(Type /*P*/ Ty, /*uint*/int AddressSpace, 
        GlobalValue.LinkageTypes Linkage, final /*const*/ Twine /*&*/ Name, 
        GlobalValue /*P*/ Aliasee) {
    return create(Ty, AddressSpace, Linkage, Name, Aliasee, Aliasee.getParent());
  }

  
  // Type, Parent and AddressSpace taken from the Aliasee.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 351,
   FQN="llvm::GlobalAlias::create", NM="_ZN4llvm11GlobalAlias6createENS_11GlobalValue12LinkageTypesERKNS_5TwineEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias6createENS_11GlobalValue12LinkageTypesERKNS_5TwineEPS1_")
  //</editor-fold>
  public static GlobalAlias /*P*/ create(GlobalValue.LinkageTypes Link, final /*const*/ Twine /*&*/ Name, 
        GlobalValue /*P*/ Aliasee) {
    PointerType /*P*/ PTy = Aliasee.getType();
    return create(PTy.getElementType(), PTy.getAddressSpace(), Link, Name, 
        Aliasee);
  }

  
  // Linkage, Type, Parent and AddressSpace taken from the Aliasee.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 358,
   FQN="llvm::GlobalAlias::create", NM="_ZN4llvm11GlobalAlias6createERKNS_5TwineEPNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias6createERKNS_5TwineEPNS_11GlobalValueE")
  //</editor-fold>
  public static GlobalAlias /*P*/ create(final /*const*/ Twine /*&*/ Name, GlobalValue /*P*/ Aliasee) {
    return create(Aliasee.getLinkage(), Name, Aliasee);
  }

  
  /// removeFromParent - This method unlinks 'this' from the containing module,
  /// but does not delete it.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::removeFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 366,
   FQN="llvm::GlobalAlias::removeFromParent", NM="_ZN4llvm11GlobalAlias16removeFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias16removeFromParentEv")
  //</editor-fold>
  @Override public void removeFromParent()/* override*/ {
    getParent().getAliasList().remove_ilist_iterator$NodeTy$C(getIterator());
  }

  
  /// eraseFromParent - This method unlinks 'this' from the containing module
  /// and deletes it.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 370,
   FQN="llvm::GlobalAlias::eraseFromParent", NM="_ZN4llvm11GlobalAlias15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias15eraseFromParentEv")
  //</editor-fold>
  @Override public void eraseFromParent()/* override*/ {
    getParent().getAliasList().erase(getIterator());
  }

  
  /// These methods retrieve and set alias target.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::setAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 374,
   FQN="llvm::GlobalAlias::setAliasee", NM="_ZN4llvm11GlobalAlias10setAliaseeEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias10setAliaseeEPNS_8ConstantE")
  //</editor-fold>
  public void setAliasee(Constant /*P*/ Aliasee) {
    assert ((!(Aliasee != null) || Aliasee.getType() == getType())) : "Alias and aliasee types should match!";
    setIndirectSymbol(Aliasee);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::getAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 74,
   FQN="llvm::GlobalAlias::getAliasee", NM="_ZNK4llvm11GlobalAlias10getAliaseeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalAlias10getAliaseeEv")
  //</editor-fold>
  public /*const*/ Constant /*P*/ getAliasee$Const() /*const*/ {
    return getIndirectSymbol$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::getAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 77,
   FQN="llvm::GlobalAlias::getAliasee", NM="_ZN4llvm11GlobalAlias10getAliaseeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias10getAliaseeEv")
  //</editor-fold>
  public Constant /*P*/ getAliasee() {
    return getIndirectSymbol();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::isValidLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 81,
   FQN="llvm::GlobalAlias::isValidLinkage", NM="_ZN4llvm11GlobalAlias14isValidLinkageENS_11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias14isValidLinkageENS_11GlobalValue12LinkageTypesE")
  //</editor-fold>
  public static boolean isValidLinkage(GlobalValue.LinkageTypes L) {
    return GlobalValue.isExternalLinkage(L) || GlobalValue.isLocalLinkage(L)
       || GlobalValue.isWeakLinkage(L) || GlobalValue.isLinkOnceLinkage(L);
  }

  
  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 87,
   FQN="llvm::GlobalAlias::classof", NM="_ZN4llvm11GlobalAlias7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAlias7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.GlobalAliasVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalAlias::~GlobalAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalAlias.h", line = 27,
   FQN="llvm::GlobalAlias::~GlobalAlias", NM="_ZN4llvm11GlobalAliasD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalAliasD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    ilist_node.super.$destroy$ilist_node();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public GlobalAlias() {
    super();
    this.ilist_node$Flds = $ilist_node();
  }
  
  public static GlobalAlias createSentinel() {
    return User.<GlobalAlias>$new_FixedUses(0, (type$ptr<?> New$Mem)-> new GlobalAlias());
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {    
    return "" + super.toString(); // NOI18N
  }
}
