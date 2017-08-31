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

package org.llvm.pass;

import org.clank.java.*;
import org.clank.java.stdimpl.aliases.StdVector;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.llvmc.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.support.sys.SmartScopedReader;
import org.llvm.support.sys.SmartScopedWriter;


/// PassRegistry - This class manages the registration and intitialization of
/// the pass subsystem as application startup, and assists the PassManager
/// in resolving pass dependencies.
/// NOTE: PassRegistry is NOT thread-safe.  If you want to use LLVM on multiple
/// threads simultaneously, you will need to use a separate PassRegistry on
/// each thread.
//<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/PassRegistry.h", line = 40,
 FQN="llvm::PassRegistry", NM="_ZN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistryE")
//</editor-fold>
public class PassRegistry implements LLVMOpaquePassRegistry, Destructors.ClassWithDestructor {
  private /*mutable */SmartRWMutex Lock;
  
  /// PassInfoMap - Keep track of the PassInfo object for each registered pass.
  // JAVA: typedef DenseMap<const void *, const PassInfo *> MapType
//  public final class MapType extends DenseMap</*const*/Object/*void P*/, /*const*/ PassInfo /*P*/ >{ };
  private DenseMap</*const*/Object/*void P*/, /*const*/ PassInfo /*P*/ > PassInfoMap;
  
  // JAVA: typedef StringMap<const PassInfo *> StringMapType
//  public final class StringMapType extends StringMap</*const*/ PassInfo /*P*/ >{ };
  private StringMap</*const*/ PassInfo /*P*/ > PassInfoStringMap;
  
  private std.vector<std.unique_ptr</*const*/ PassInfo>> ToFree;
  private std.vector<PassRegistrationListener /*P*/ > Listeners;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::PassRegistry">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/PassRegistry.h", line = 54,
   FQN="llvm::PassRegistry::PassRegistry", NM="_ZN4llvm12PassRegistryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistryC1Ev")
  //</editor-fold>
  public PassRegistry() {
    // : Lock(), PassInfoMap(), PassInfoStringMap(), ToFree(), Listeners() 
    //START JInit
    this.Lock = new SmartRWMutex(true);//, true);
    this.PassInfoMap = new DenseMap</*const*/Object/*void P*/, /*const*/ PassInfo /*P*/ >(/*DenseMapInfo$LikePtr*/DenseMapInfo$LikePtr.$Info(), (/*const*/ PassInfo /*P*/ )null);
    this.PassInfoStringMap = new StringMap</*const*/ PassInfo /*P*/ >((/*const*/ PassInfo /*P*/ )null);
    this.ToFree = new std.vector<std.unique_ptr</*const*/ PassInfo>>(new std.unique_ptr</*const*/ PassInfo>());
    this.Listeners = new std.vector<PassRegistrationListener /*P*/ >((PassRegistrationListener /*P*/ )null);
    //END JInit
  }

  
  //===----------------------------------------------------------------------===//
  // Accessors
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::~PassRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 35,
   FQN="llvm::PassRegistry::~PassRegistry", NM="_ZN4llvm12PassRegistryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistryD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    Listeners.$destroy();
    ToFree.$destroy();
    PassInfoStringMap.$destroy();
    PassInfoMap.$destroy();
    Lock.$destroy();
    //END JDestroy
  }

  
  /// getPassRegistry - Access the global registry object, which is
  /// automatically initialized at application launch and destroyed by
  /// llvm_shutdown.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::getPassRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 27,
   FQN="llvm::PassRegistry::getPassRegistry", NM="_ZN4llvm12PassRegistry15getPassRegistryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistry15getPassRegistryEv")
  //</editor-fold>
  public static PassRegistry /*P*/ getPassRegistry() {
    return $AddrOf(PassRegistryStatics.PassRegistryObj.$star());
  }

  
  /// getPassInfo - Look up a pass' corresponding PassInfo, indexed by the pass'
  /// type identifier (&MyPass::ID).
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::getPassInfo">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 37,
   FQN="llvm::PassRegistry::getPassInfo", NM="_ZNK4llvm12PassRegistry11getPassInfoEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZNK4llvm12PassRegistry11getPassInfoEPKv")
  //</editor-fold>
  public /*const*/ PassInfo /*P*/ getPassInfo(/*const*/Object/*void P*/ TI) /*const*/ {
    assert Pass.class.isAssignableFrom((Class)TI) : "Expected child of Pass: " + TI;
    SmartScopedReader/*<true>*/ Guard = null;
    try {
      Guard/*J*/= new SmartScopedReader/*<true>*/(true, Lock);
      DenseMapIterator</*const*/Object/*void P*/ , /*const*/ PassInfo /*P*/ > I = PassInfoMap.find$Const(TI);
      return I.$noteq(PassInfoMap.end$Const()) ? I.$arrow().second : null;
    } finally {
      if (Guard != null) { Guard.$destroy(); }
    }
  }

  
  /// getPassInfo - Look up a pass' corresponding PassInfo, indexed by the pass'
  /// argument string.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::getPassInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 43,
   FQN="llvm::PassRegistry::getPassInfo", NM="_ZNK4llvm12PassRegistry11getPassInfoENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZNK4llvm12PassRegistry11getPassInfoENS_9StringRefE")
  //</editor-fold>
  public /*const*/ PassInfo /*P*/ getPassInfo(StringRef Arg) /*const*/ {
    SmartScopedReader/*<true>*/ Guard = null;
    try {
      Guard/*J*/= new SmartScopedReader/*<true>*/(true, Lock);
      StringMapConstIterator</*const*/ PassInfo /*P*/ > I = PassInfoStringMap.find$Const(/*NO_COPY*/Arg);
      return I.$noteq(PassInfoStringMap.end$Const()) ? I.$arrow().second : null;
    } finally {
      if (Guard != null) { Guard.$destroy(); }
    }
  }

  
  /// registerPass - Register a pass (by means of its PassInfo) with the
  /// registry.  Required in order to use the pass with a PassManager.
  
  //===----------------------------------------------------------------------===//
  // Pass Registration mechanism
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::registerPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 53,
   FQN="llvm::PassRegistry::registerPass", NM="_ZN4llvm12PassRegistry12registerPassERKNS_8PassInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistry12registerPassERKNS_8PassInfoEb")
  //</editor-fold>
  public void registerPass(final /*const*/ PassInfo /*&*/ PI) {
    registerPass(PI, false);
  }
  public void registerPass(final /*const*/ PassInfo /*&*/ PI, boolean ShouldFree/*= false*/) {
    SmartScopedWriter/*<true>*/ Guard = null;
    try {
      Guard/*J*/= new SmartScopedWriter/*<true>*/(true, Lock);
      boolean Inserted = PassInfoMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(PI.getTypeInfo(), $AddrOf(PI))).second;
      assert (Inserted) : "Pass registered multiple times!";
      ///*J:(void)*/Inserted;
      PassInfoStringMap.$set(/*STRINGREF_STR*/PI.getPassArgument(), $AddrOf(PI));
      
      // Notify any listeners.
      for (PassRegistrationListener /*P*/ Listener : Listeners)  {
        Listener.passRegistered($AddrOf(PI));
      }
      if (ShouldFree) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          ToFree.push_back_T$RR($c$.track(new std.unique_ptr</*const*/ PassInfo>($AddrOf(PI)))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (Guard != null) { Guard.$destroy(); }
    }
  }

  
  /// registerAnalysisGroup - Register an analysis group (or a pass implementing
  // an analysis group) with the registry.  Like registerPass, this is required
  // in order for a PassManager to be able to use this group/pass.
  
  /// Analysis Group Mechanisms.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::registerAnalysisGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 76,
   FQN="llvm::PassRegistry::registerAnalysisGroup", NM="_ZN4llvm12PassRegistry21registerAnalysisGroupEPKvS2_RNS_8PassInfoEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistry21registerAnalysisGroupEPKvS2_RNS_8PassInfoEbb")
  //</editor-fold>
  public void registerAnalysisGroup(/*const*/Object/*void P*/ InterfaceID, 
                       /*const*/Object/*void P*/ PassID, 
                       final PassInfo /*&*/ Registeree, boolean isDefault) {
    registerAnalysisGroup(InterfaceID, 
                       PassID, 
                       Registeree, isDefault, 
                       false);
  }
  public void registerAnalysisGroup(/*const*/Object/*void P*/ InterfaceID, 
                       /*const*/Object/*void P*/ PassID, 
                       final PassInfo /*&*/ Registeree, boolean isDefault, 
                       boolean ShouldFree/*= false*/) {
    PassInfo /*P*/ InterfaceInfo = ((/*const_cast*/PassInfo /*P*/ )(getPassInfo(InterfaceID)));
    if (!(InterfaceInfo != null)) {
      // First reference to Interface, register it now.
      registerPass(Registeree);
      InterfaceInfo = $AddrOf(Registeree);
    }
    assert (Registeree.isAnalysisGroup()) : "Trying to join an analysis group that is a normal pass!";
    if ((PassID != null)) {
      SmartScopedWriter/*<true>*/ Guard = null;
      try {
        PassInfo /*P*/ ImplementationInfo = ((/*const_cast*/PassInfo /*P*/ )(getPassInfo(PassID)));
        assert ((ImplementationInfo != null)) : "Must register pass before adding to AnalysisGroup!";
        
        Guard/*J*/= new SmartScopedWriter/*<true>*/(true, Lock);
        
        // Make sure we keep track of the fact that the implementation implements
        // the interface.
        ImplementationInfo.addInterfaceImplemented(InterfaceInfo);
        if (isDefault) {
          assert (InterfaceInfo.getNormalCtor() == null) : "Default implementation for analysis group already specified!";
          assert ((ImplementationInfo.getNormalCtor() != null)) : "Cannot specify pass as default if it does not have a default ctor";
          InterfaceInfo.setNormalCtor(ImplementationInfo.getNormalCtor());
          InterfaceInfo.setTargetMachineCtor(ImplementationInfo.getTargetMachineCtor());
        }
      } finally {
        if (Guard != null) { Guard.$destroy(); }
      }
    }
    if (ShouldFree) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ToFree.push_back_T$RR($c$.track(new std.unique_ptr</*const*/ PassInfo>($AddrOf(Registeree)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// enumerateWith - Enumerate the registered passes, calling the provided
  /// PassRegistrationListener's passEnumerate() callback on each of them.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::enumerateWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 69,
   FQN="llvm::PassRegistry::enumerateWith", NM="_ZN4llvm12PassRegistry13enumerateWithEPNS_24PassRegistrationListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistry13enumerateWithEPNS_24PassRegistrationListenerE")
  //</editor-fold>
  public void enumerateWith(PassRegistrationListener /*P*/ L) {
    SmartScopedReader/*<true>*/ Guard = null;
    try {
      Guard/*J*/= new SmartScopedReader/*<true>*/(true, Lock);
      for (std.pair</*const*/Object/*void P*/ , /*const*/ PassInfo /*P*/ > PassInfoPair : PassInfoMap)  {
        L.passEnumerate(PassInfoPair.second);
      }
    } finally {
      if (Guard != null) { Guard.$destroy(); }
    }
  }

  
  /// addRegistrationListener - Register the given PassRegistrationListener
  /// to receive passRegistered() callbacks whenever a new pass is registered.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::addRegistrationListener">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 116,
   FQN="llvm::PassRegistry::addRegistrationListener", NM="_ZN4llvm12PassRegistry23addRegistrationListenerEPNS_24PassRegistrationListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistry23addRegistrationListenerEPNS_24PassRegistrationListenerE")
  //</editor-fold>
  public void addRegistrationListener(PassRegistrationListener /*P*/ L) {
    SmartScopedWriter/*<true>*/ Guard = null;
    try {
      Guard/*J*/= new SmartScopedWriter/*<true>*/(true, Lock);
      Listeners.push_back_T$C$R(L);
    } finally {
      if (Guard != null) { Guard.$destroy(); }
    }
  }

  
  /// removeRegistrationListener - Unregister a PassRegistrationListener so that
  /// it no longer receives passRegistered() callbacks.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassRegistry::removeRegistrationListener">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp", line = 121,
   FQN="llvm::PassRegistry::removeRegistrationListener", NM="_ZN4llvm12PassRegistry26removeRegistrationListenerEPNS_24PassRegistrationListenerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassRegistry.cpp -nm=_ZN4llvm12PassRegistry26removeRegistrationListenerEPNS_24PassRegistrationListenerE")
  //</editor-fold>
  public void removeRegistrationListener(PassRegistrationListener /*P*/ L) {
    SmartScopedWriter/*<true>*/ Guard = null;
    try {
      Guard/*J*/= new SmartScopedWriter/*<true>*/(true, Lock);
      StdVector.iterator<PassRegistrationListener> I = std.find(Listeners.begin(), Listeners.end(), L);
      Listeners.erase(new std.vector.iterator</*const*/ PassRegistrationListener /*P*/ >(I));
    } finally {
      if (Guard != null) { Guard.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "Lock=" + Lock // NOI18N
              + ", PassInfoMap=" + PassInfoMap // NOI18N
              + ", PassInfoStringMap=" + PassInfoStringMap // NOI18N
              + ", ToFree=" + ToFree // NOI18N
              + ", Listeners=" + Listeners; // NOI18N
  }
}
