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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 32,
 FQN="llvm::GlobalIFunc", NM="_ZN4llvm11GlobalIFuncE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFuncE")
//</editor-fold>
public final class GlobalIFunc extends /*public*/ GlobalIndirectSymbol implements /*public*/ ilist_node<GlobalIFunc>, IChild<Module>, Destructors.ClassWithDestructor {
  /*friend  class SymbolTableListTraits<GlobalIFunc>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 35,
   FQN="llvm::GlobalIFunc::operator=", NM="_ZN4llvm11GlobalIFuncaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFuncaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ GlobalIFunc /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::GlobalIFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 36,
   FQN="llvm::GlobalIFunc::GlobalIFunc", NM="_ZN4llvm11GlobalIFuncC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFuncC1ERKS0_")
  //</editor-fold>
  protected/*private*/ GlobalIFunc(final /*const*/ GlobalIFunc /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}


  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 399,
   FQN="llvm::GlobalIFunc::setParent", NM="_ZN4llvm11GlobalIFunc9setParentEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFunc9setParentEPNS_6ModuleE")
  //</editor-fold>
  public /*friend*//*private*/ void setParent(Module /*P*/ parent) {
    Parent = parent;
  }



  //===----------------------------------------------------------------------===//
  // GlobalIFunc Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::GlobalIFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 384,
   FQN="llvm::GlobalIFunc::GlobalIFunc", NM="_ZN4llvm11GlobalIFuncC1EPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFuncC1EPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE")
  //</editor-fold>
  private GlobalIFunc(Type /*P*/ Ty, /*uint*/int AddressSpace, GlobalValue.LinkageTypes Link,
      final /*const*/ Twine /*&*/ Name, Constant /*P*/ Resolver,
      Module /*P*/ ParentModule) {
    // : GlobalIndirectSymbol(Ty, Value::GlobalIFuncVal, AddressSpace, Link, Name, Resolver), ilist_node<GlobalIFunc>()
    //START JInit
    super(Ty, Value.ValueTy.GlobalIFuncVal, AddressSpace, Link, Name,
        Resolver);
    this.ilist_node$Flds = $ilist_node();
    //END JInit
    if ((ParentModule != null)) {
      ParentModule.getIFuncList().push_back(this);
    }
  }

/*public:*/
  /// If a parent module is specified, the ifunc is automatically inserted into
  /// the end of the specified module's ifunc list.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 393,
   FQN="llvm::GlobalIFunc::create", NM="_ZN4llvm11GlobalIFunc6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFunc6createEPNS_4TypeEjNS_11GlobalValue12LinkageTypesERKNS_5TwineEPNS_8ConstantEPNS_6ModuleE")
  //</editor-fold>
  public static GlobalIFunc /*P*/ create(Type /*P*/ Ty, /*uint*/int AddressSpace,
        GlobalValue.LinkageTypes Link, final /*const*/ Twine /*&*/ Name,
        Constant /*P*/ Resolver, Module /*P*/ ParentModule) {
    return /*NEW_EXPR [GlobalIndirectSymbol::new]*/GlobalIndirectSymbol.$new_GlobalIndirectSymbol((type$ptr<?> New$Mem)->{
        return new GlobalIFunc(Ty, AddressSpace, Link, Name, Resolver, ParentModule);
     });
  }


  /// This method unlinks 'this' from the containing module, but does not
  /// delete it.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::removeFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 403,
   FQN="llvm::GlobalIFunc::removeFromParent", NM="_ZN4llvm11GlobalIFunc16removeFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFunc16removeFromParentEv")
  //</editor-fold>
  @Override public final void removeFromParent()/* final*/ {
    getParent().getIFuncList().remove_ilist_iterator$NodeTy$C(getIterator());
  }


  /// This method unlinks 'this' from the containing module and deletes it.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Globals.cpp", line = 407,
   FQN="llvm::GlobalIFunc::eraseFromParent", NM="_ZN4llvm11GlobalIFunc15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFunc15eraseFromParentEv")
  //</editor-fold>
  @Override public final void eraseFromParent()/* final*/ {
    getParent().getIFuncList().erase(getIterator());
  }


  /// These methods retrieve and set ifunc resolver function.
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::setResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 58,
   FQN="llvm::GlobalIFunc::setResolver", NM="_ZN4llvm11GlobalIFunc11setResolverEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFunc11setResolverEPNS_8ConstantE")
  //</editor-fold>
  public void setResolver(Constant /*P*/ Resolver) {
    setIndirectSymbol(Resolver);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::getResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 61,
   FQN="llvm::GlobalIFunc::getResolver", NM="_ZNK4llvm11GlobalIFunc11getResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZNK4llvm11GlobalIFunc11getResolverEv")
  //</editor-fold>
  public /*const*/ Constant /*P*/ getResolver$Const() /*const*/ {
    return getIndirectSymbol$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::getResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 64,
   FQN="llvm::GlobalIFunc::getResolver", NM="_ZN4llvm11GlobalIFunc11getResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFunc11getResolverEv")
  //</editor-fold>
  public Constant /*P*/ getResolver() {
    return getIndirectSymbol();
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 69,
   FQN="llvm::GlobalIFunc::classof", NM="_ZN4llvm11GlobalIFunc7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFunc7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.GlobalIFuncVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::GlobalIFunc::~GlobalIFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GlobalIFunc.h", line = 32,
   FQN="llvm::GlobalIFunc::~GlobalIFunc", NM="_ZN4llvm11GlobalIFuncD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Globals.cpp -nm=_ZN4llvm11GlobalIFuncD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    ilist_node.super.$destroy$ilist_node();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private GlobalIFunc() {
    this.ilist_node$Flds = $ilist_node();
  }

  public static GlobalIFunc createSentinel() {
    return User.<GlobalIFunc>$new_FixedUses(0, (type$ptr<?> New$Mem)-> new GlobalIFunc());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
