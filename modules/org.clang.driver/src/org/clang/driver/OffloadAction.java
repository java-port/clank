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

package org.clang.driver;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.driver.*;
import org.clang.driver.java.DriverFunctionPointers.OffloadActionWorkTy;
;


/// An offload action combines host or/and device actions according to the
/// programming model implementation needs and propagates the offloading kind to
/// its dependences.
//<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 208,
 FQN="clang::driver::OffloadAction", NM="_ZN5clang6driver13OffloadActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadActionE")
//</editor-fold>
public final class OffloadAction extends /*public*/ Action implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 131,
   FQN="clang::driver::OffloadAction::anchor", NM="_ZN5clang6driver13OffloadAction6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadAction6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  /// Type used to communicate device actions. It associates bound architecture,
  /// toolchain, and offload kind to each action.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 214,
   FQN="clang::driver::OffloadAction::DeviceDependences", NM="_ZN5clang6driver13OffloadAction17DeviceDependencesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadAction17DeviceDependencesE")
  //</editor-fold>
  public static final class DeviceDependences implements Destructors.ClassWithDestructor {
  /*public:*/
    /*typedef SmallVector<const ToolChain *, 3> ToolChainList*/
//    public final class ToolChainList extends SmallVector</*const*/ ToolChain /*P*/ >{ };
    /*typedef SmallVector<const char *, 3> BoundArchList*/
//    public final class BoundArchList extends SmallVector</*const*/char$ptr/*char P*//*,  3*/>{ };
    /*typedef SmallVector<OffloadKind, 3> OffloadKindList*/
//    public final class OffloadKindList extends SmallVectorUInt/*OffloadKind*/{ };
  /*private:*/
    // Lists that keep the information for each dependency. All the lists are
    // meant to be updated in sync. We are adopting separate lists instead of a
    // list of structs, because that simplifies forwarding the actions list to
    // initialize the inputs of the base Action class.
    
    /// The dependence actions.
    private /*ActionList*/SmallVector<Action /*P*/> DeviceActions;
    /// The offloading toolchains that should be used with the action.
    private SmallVector</*const*/ ToolChain /*P*/ > DeviceToolChains;
    /// The architectures that should be used with this action.
    private SmallVector</*const*/char$ptr/*char P*//*,  3*/> DeviceBoundArchs;
    /// The offload kind of each dependence.
    private SmallVectorUInt/*OffloadKind*/ DeviceOffloadKinds;
  /*public:*/
    /// Add a action along with the associated toolchain, bound arch, and
    /// offload kind.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences::add">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 247,
     FQN="clang::driver::OffloadAction::DeviceDependences::add", NM="_ZN5clang6driver13OffloadAction17DeviceDependences3addERNS0_6ActionERKNS0_9ToolChainEPKcNS3_11OffloadKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadAction17DeviceDependences3addERNS0_6ActionERKNS0_9ToolChainEPKcNS3_11OffloadKindE")
    //</editor-fold>
    public void add(Action /*&*/ A, /*const*/ ToolChain /*&*/ TC, 
       /*const*/char$ptr/*char P*/ BoundArch, 
       /*OffloadKind*//*uint*/int OKind) {
      DeviceActions.push_back(/*AddrOf*/A);
      DeviceToolChains.push_back(/*AddrOf*/TC);
      DeviceBoundArchs.push_back(BoundArch);
      DeviceOffloadKinds.push_back(OKind);
    }

    
    /// Get each of the individual arrays.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences::getActions">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 242,
     FQN="clang::driver::OffloadAction::DeviceDependences::getActions", NM="_ZNK5clang6driver13OffloadAction17DeviceDependences10getActionsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction17DeviceDependences10getActionsEv")
    //</editor-fold>
    public /*const*//*ActionList*/SmallVector<Action /*P*/>/*&*/ getActions() /*const*/ {
      return DeviceActions;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences::getToolChains">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 243,
     FQN="clang::driver::OffloadAction::DeviceDependences::getToolChains", NM="_ZNK5clang6driver13OffloadAction17DeviceDependences13getToolChainsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction17DeviceDependences13getToolChainsEv")
    //</editor-fold>
    public /*const*/SmallVector</*const*/ ToolChain /*P*/ > /*&*/ getToolChains() /*const*/ {
      return DeviceToolChains;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences::getBoundArchs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 244,
     FQN="clang::driver::OffloadAction::DeviceDependences::getBoundArchs", NM="_ZNK5clang6driver13OffloadAction17DeviceDependences13getBoundArchsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction17DeviceDependences13getBoundArchsEv")
    //</editor-fold>
    public /*const*/SmallVector</*const*/char$ptr/*char P*//*,  3*/> /*&*/ getBoundArchs() /*const*/ {
      return DeviceBoundArchs;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences::getOffloadKinds">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 245,
     FQN="clang::driver::OffloadAction::DeviceDependences::getOffloadKinds", NM="_ZNK5clang6driver13OffloadAction17DeviceDependences15getOffloadKindsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction17DeviceDependences15getOffloadKindsEv")
    //</editor-fold>
    public /*const*/SmallVectorUInt/*OffloadKind*/ /*&*/ getOffloadKinds() /*const*/ {
      return DeviceOffloadKinds;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences::DeviceDependences">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 214,
     FQN="clang::driver::OffloadAction::DeviceDependences::DeviceDependences", NM="_ZN5clang6driver13OffloadAction17DeviceDependencesC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver13OffloadAction17DeviceDependencesC1Ev")
    //</editor-fold>
    public /*inline*/ DeviceDependences() {
      /* : DeviceActions(), DeviceToolChains(), DeviceBoundArchs(), DeviceOffloadKinds()*/ 
      //START JInit
      this.DeviceActions = new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
      this.DeviceToolChains = new SmallVector</*const*/ ToolChain /*P*/ >(3, (/*const*/ ToolChain /*P*/ )null);
      this.DeviceBoundArchs = new SmallVector</*const*/char$ptr/*char P*//*,  3*/>(3, null);
      this.DeviceOffloadKinds = new SmallVectorUInt/*OffloadKind*/(3, Action.OffloadKind.OFK_None);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::DeviceDependences::~DeviceDependences">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 214,
     FQN="clang::driver::OffloadAction::DeviceDependences::~DeviceDependences", NM="_ZN5clang6driver13OffloadAction17DeviceDependencesD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN5clang6driver13OffloadAction17DeviceDependencesD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      DeviceOffloadKinds.$destroy();
      DeviceBoundArchs.$destroy();
      DeviceToolChains.$destroy();
      DeviceActions.$destroy();
      //END JDestroy
    }

    
    public String toString() {
      return "" + "DeviceActions=" + DeviceActions // NOI18N
                + ", DeviceToolChains=" + DeviceToolChains // NOI18N
                + ", DeviceBoundArchs=" + DeviceBoundArchs // NOI18N
                + ", DeviceOffloadKinds=" + DeviceOffloadKinds; // NOI18N
    }
  };
  
  /// Type used to communicate host actions. It associates bound architecture,
  /// toolchain, and offload kinds to the host action.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::HostDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 252,
   FQN="clang::driver::OffloadAction::HostDependence", NM="_ZN5clang6driver13OffloadAction14HostDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadAction14HostDependenceE")
  //</editor-fold>
  public static final class HostDependence {
    /// The dependence action.
    private Action /*&*/ HostAction;
    /// The offloading toolchain that should be used with the action.
    private /*const*/ ToolChain /*&*/ HostToolChain;
    /// The architectures that should be used with this action.
    private /*const*/char$ptr/*char P*/ HostBoundArch/* = null*/;
    /// The offload kind of each dependence.
    private /*uint*/int HostOffloadKinds/* = 0uU*/;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::HostDependence::HostDependence">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 263,
     FQN="clang::driver::OffloadAction::HostDependence::HostDependence", NM="_ZN5clang6driver13OffloadAction14HostDependenceC1ERNS0_6ActionERKNS0_9ToolChainEPKcj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadAction14HostDependenceC1ERNS0_6ActionERKNS0_9ToolChainEPKcj")
    //</editor-fold>
    public HostDependence(Action /*&*/ A, /*const*/ ToolChain /*&*/ TC, /*const*/char$ptr/*char P*/ BoundArch, 
        /*const*//*uint*/int OffloadKinds) {
      /* : HostAction(A), HostToolChain(TC), HostBoundArch(BoundArch), HostOffloadKinds(OffloadKinds)*/ 
      //START JInit
      this./*&*/HostAction=/*&*/A;
      this./*&*/HostToolChain=/*&*/TC;
      this.HostBoundArch = $tryClone(BoundArch);
      this.HostOffloadKinds = OffloadKinds;
      //END JInit
    }

    /// Constructor version that obtains the offload kinds from the device
    /// dependencies.
    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::HostDependence::HostDependence">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 256,
     FQN="clang::driver::OffloadAction::HostDependence::HostDependence", NM="_ZN5clang6driver13OffloadAction14HostDependenceC1ERNS0_6ActionERKNS0_9ToolChainEPKcRKNS1_17DeviceDependencesE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadAction14HostDependenceC1ERNS0_6ActionERKNS0_9ToolChainEPKcRKNS1_17DeviceDependencesE")
    //</editor-fold>
    public HostDependence(Action /*&*/ A, /*const*/ ToolChain /*&*/ TC, 
        /*const*/char$ptr/*char P*/ BoundArch, 
        /*const*/ DeviceDependences /*&*/ DDeps) {
      /* : HostAction(A), HostToolChain(TC), HostBoundArch(BoundArch), HostOffloadKinds(0uU)*/ 
      //START JInit
      this./*&*/HostAction=/*&*/A;
      this./*&*/HostToolChain=/*&*/TC;
      this.HostBoundArch = $tryClone(BoundArch);
      /*InClass*/this.HostOffloadKinds = 0/*U*/;
      //END JInit
      for (/*OffloadKind*//*uint*/int K : DDeps.getOffloadKinds())  {
        HostOffloadKinds |= K;
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::HostDependence::getAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 271,
     FQN="clang::driver::OffloadAction::HostDependence::getAction", NM="_ZNK5clang6driver13OffloadAction14HostDependence9getActionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction14HostDependence9getActionEv")
    //</editor-fold>
    public Action /*P*/ getAction() /*const*/ {
      return /*AddrOf*/HostAction;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::HostDependence::getToolChain">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 272,
     FQN="clang::driver::OffloadAction::HostDependence::getToolChain", NM="_ZNK5clang6driver13OffloadAction14HostDependence12getToolChainEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction14HostDependence12getToolChainEv")
    //</editor-fold>
    public /*const*/ ToolChain /*P*/ getToolChain() /*const*/ {
      return /*AddrOf*/HostToolChain;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::HostDependence::getBoundArch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 273,
     FQN="clang::driver::OffloadAction::HostDependence::getBoundArch", NM="_ZNK5clang6driver13OffloadAction14HostDependence12getBoundArchEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction14HostDependence12getBoundArchEv")
    //</editor-fold>
    public /*const*/char$ptr/*char P*/ getBoundArch() /*const*/ {
      return HostBoundArch;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::HostDependence::getOffloadKinds">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 274,
     FQN="clang::driver::OffloadAction::HostDependence::getOffloadKinds", NM="_ZNK5clang6driver13OffloadAction14HostDependence15getOffloadKindsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction14HostDependence15getOffloadKindsEv")
    //</editor-fold>
    public /*uint*/int getOffloadKinds() /*const*/ {
      return HostOffloadKinds;
    }

    
    public String toString() {
      return "" + "HostAction=" + HostAction // NOI18N
                + ", HostToolChain=" + HostToolChain // NOI18N
                + ", HostBoundArch=" + HostBoundArch // NOI18N
                + ", HostOffloadKinds=" + HostOffloadKinds; // NOI18N
    }
  };
  
  /*typedef llvm::function_ref<void (Action *, const ToolChain *, const char *)> OffloadActionWorkTy*/
//  public final class OffloadActionWorkTy extends OffloadActionWorkTy{ };
/*private:*/
  /// The host offloading toolchain that should be used with the action.
  private /*const*/ ToolChain /*P*/ HostTC/* = null*/;
  
  /// The tool chains associated with the list of actions.
  private SmallVector</*const*/ ToolChain /*P*/ > DevToolChains;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::OffloadAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 133,
   FQN="clang::driver::OffloadAction::OffloadAction", NM="_ZN5clang6driver13OffloadActionC1ERKNS1_14HostDependenceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadActionC1ERKNS1_14HostDependenceE")
  //</editor-fold>
  public OffloadAction(/*const*/ HostDependence /*&*/ HDep) {
    /* : Action(OffloadClass, HDep.getAction()), HostTC(HDep.getToolChain()), DevToolChains()*/ 
    //START JInit
    super(ActionClass.OffloadClass, HDep.getAction());
    this.HostTC = HDep.getToolChain();
    this.DevToolChains = new SmallVector</*const*/ ToolChain /*P*/ >(3, (/*const*/ ToolChain /*P*/ )null);
    //END JInit
    OffloadingArch = $tryClone(HDep.getBoundArch());
    ActiveOffloadKindMask = HDep.getOffloadKinds();
    HDep.getAction().propagateHostOffloadInfo(HDep.getOffloadKinds(), 
        HDep.getBoundArch());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::OffloadAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 141,
   FQN="clang::driver::OffloadAction::OffloadAction", NM="_ZN5clang6driver13OffloadActionC1ERKNS1_17DeviceDependencesENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadActionC1ERKNS1_17DeviceDependencesENS0_5types2IDE")
  //</editor-fold>
  public OffloadAction(/*const*/ DeviceDependences /*&*/ DDeps, types.ID Ty) {
    /* : Action(OffloadClass, DDeps.getActions(), Ty), HostTC(null), DevToolChains(DDeps.getToolChains())*/ 
    //START JInit
    super(ActionClass.OffloadClass, DDeps.getActions(), Ty);
    /*InClass*/this.HostTC = null;
    this.DevToolChains = new SmallVector</*const*/ ToolChain /*P*/ >(DDeps.getToolChains());
    //END JInit
    /*const*/SmallVectorUInt/*OffloadKind*/ /*&*/ OKinds = DDeps.getOffloadKinds();
    /*const*/SmallVector</*const*/char$ptr/*char P*//*,  3*/> /*&*/ BArchs = DDeps.getBoundArchs();
    
    // If all inputs agree on the same kind, use it also for this action.
    if (llvm.all_of(OKinds,  (K) -> 
          {
            return K == OKinds.front();
          }
)) {
      OffloadingDeviceKind = OKinds.front();
    }
    
    // If we have a single dependency, inherit the architecture from it.
    if (OKinds.size() == 1) {
      OffloadingArch = $tryClone(BArchs.front());
    }
    
    // Propagate info to the dependencies.
    for (/*uint*/int i = 0, e = getInputs().size(); i != e; ++i)  {
      getInputs().$at(i).propagateDeviceOffloadInfo(OKinds.$at(i), BArchs.$at(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::OffloadAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 160,
   FQN="clang::driver::OffloadAction::OffloadAction", NM="_ZN5clang6driver13OffloadActionC1ERKNS1_14HostDependenceERKNS1_17DeviceDependencesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadActionC1ERKNS1_14HostDependenceERKNS1_17DeviceDependencesE")
  //</editor-fold>
  public OffloadAction(/*const*/ HostDependence /*&*/ HDep, 
      /*const*/ DeviceDependences /*&*/ DDeps) {
    /* : Action(OffloadClass, HDep.getAction()), HostTC(HDep.getToolChain()), DevToolChains(DDeps.getToolChains())*/ 
    //START JInit
    super(ActionClass.OffloadClass, HDep.getAction());
    this.HostTC = HDep.getToolChain();
    this.DevToolChains = new SmallVector</*const*/ ToolChain /*P*/ >(DDeps.getToolChains());
    //END JInit
    // We use the kinds of the host dependence for this action.
    OffloadingArch = $tryClone(HDep.getBoundArch());
    ActiveOffloadKindMask = HDep.getOffloadKinds();
    HDep.getAction().propagateHostOffloadInfo(HDep.getOffloadKinds(), 
        HDep.getBoundArch());
    
    // Add device inputs and propagate info to the device actions. Do work only if
    // we have dependencies.
    for (/*uint*/int i = 0, e = DDeps.getActions().size(); i != e; ++i)  {
      {
        Action /*P*/ A = DDeps.getActions().$at(i);
        if ((A != null)) {
          getInputs().push_back(A);
          A.propagateDeviceOffloadInfo(DDeps.getOffloadKinds().$at(i), 
              DDeps.getBoundArchs().$at(i));
        }
      }
    }
  }

  
  /// Execute the work specified in \a Work on the host dependence.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::doOnHostDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 180,
   FQN="clang::driver::OffloadAction::doOnHostDependence", NM="_ZNK5clang6driver13OffloadAction18doOnHostDependenceERKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction18doOnHostDependenceERKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE")
  //</editor-fold>
  public void doOnHostDependence(OffloadActionWorkTy Work) /*const*/ {
    if (!(HostTC != null)) {
      return;
    }
    assert (!getInputs().empty()) : "No dependencies for offload action??";
    Action /*P*/ A = getInputs().front();
    Work.$call(A, HostTC, A.getOffloadingArch());
  }

  
  /// Execute the work specified in \a Work on each device dependence.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::doOnEachDeviceDependence">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 188,
   FQN="clang::driver::OffloadAction::doOnEachDeviceDependence", NM="_ZNK5clang6driver13OffloadAction24doOnEachDeviceDependenceERKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction24doOnEachDeviceDependenceERKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE")
  //</editor-fold>
  public void doOnEachDeviceDependence(OffloadActionWorkTy Work) /*const*/ {
    type$ptr<Action> /*P*/ /*const*/ /*P*/ I = getInputs().begin();
    type$ptr<Action> /*P*/ /*const*/ /*P*/ E = getInputs().end();
    if (I.$eq(E)) {
      return;
    }
    
    // We expect to have the same number of input dependences and device tool
    // chains, except if we also have a host dependence. In that case we have one
    // more dependence than we have device tool chains.
    assert (getInputs().size() == DevToolChains.size() + ((HostTC != null) ? 1 : 0)) : "Sizes of action dependences and toolchains are not consistent!";
    
    // Skip host action
    if ((HostTC != null)) {
      I.$preInc();
    }
    
    /*const*/ type$ptr<ToolChain> /*P*/ /*const*/ /*P*/ TI = DevToolChains.begin();
    for (; I.$noteq(E); I.$preInc() , TI.$preInc())  {
      Work.$call(/*Deref*/I.$arrow(), /*Deref*/TI.$arrow(), (/*Deref*/I.$arrow()).getOffloadingArch());
    }
  }

  
  /// Execute the work specified in \a Work on each dependence.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::doOnEachDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 210,
   FQN="clang::driver::OffloadAction::doOnEachDependence", NM="_ZNK5clang6driver13OffloadAction18doOnEachDependenceERKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction18doOnEachDependenceERKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE")
  //</editor-fold>
  public void doOnEachDependence(OffloadActionWorkTy Work) /*const*/ {
    doOnHostDependence(Work);
    doOnEachDeviceDependence(Work);
  }

  
  /// Execute the work specified in \a Work on each host or device dependence if
  /// \a IsHostDependenceto is true or false, respectively.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::doOnEachDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 215,
   FQN="clang::driver::OffloadAction::doOnEachDependence", NM="_ZNK5clang6driver13OffloadAction18doOnEachDependenceEbRKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction18doOnEachDependenceEbRKN4llvm12function_refIFvPNS0_6ActionEPKNS0_9ToolChainEPKcEEE")
  //</editor-fold>
  public void doOnEachDependence(boolean IsHostDependence, 
                    OffloadActionWorkTy Work) /*const*/ {
    if (IsHostDependence) {
      doOnHostDependence(Work);
    } else {
      doOnEachDeviceDependence(Work);
    }
  }

  
  /// Return true if the action has a host dependence.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::hasHostDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 223,
   FQN="clang::driver::OffloadAction::hasHostDependence", NM="_ZNK5clang6driver13OffloadAction17hasHostDependenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction17hasHostDependenceEv")
  //</editor-fold>
  public boolean hasHostDependence() /*const*/ {
    return HostTC != null;
  }

  
  /// Return the host dependence of this action. This function is only expected
  /// to be called if the host dependence exists.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::getHostDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 225,
   FQN="clang::driver::OffloadAction::getHostDependence", NM="_ZNK5clang6driver13OffloadAction17getHostDependenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction17getHostDependenceEv")
  //</editor-fold>
  public Action /*P*/ getHostDependence() /*const*/ {
    assert (hasHostDependence()) : "Host dependence does not exist!";
    assert (!getInputs().empty()) : "No dependencies for offload action??";
    return (HostTC != null) ? getInputs().front() : null;
  }

  
  /// Return true if the action has a single device dependence. If \a
  /// DoNotConsiderHostActions is set, ignore the host dependence, if any, while
  /// accounting for the number of dependences.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::hasSingleDeviceDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 231,
   FQN="clang::driver::OffloadAction::hasSingleDeviceDependence", NM="_ZNK5clang6driver13OffloadAction25hasSingleDeviceDependenceEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction25hasSingleDeviceDependenceEb")
  //</editor-fold>
  public boolean hasSingleDeviceDependence() /*const*/ {
    return hasSingleDeviceDependence(false);
  }
  public boolean hasSingleDeviceDependence(boolean DoNotConsiderHostActions/*= false*/) /*const*/ {
    if (DoNotConsiderHostActions) {
      return getInputs().size() == ((HostTC != null) ? 2 : 1);
    }
    return !(HostTC != null) && getInputs().size() == 1;
  }

  
  /// Return the single device dependence of this action. This function is only
  /// expected to be called if a single device dependence exists. If \a
  /// DoNotConsiderHostActions is set, a host dependence is allowed.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::getSingleDeviceDependence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 238,
   FQN="clang::driver::OffloadAction::getSingleDeviceDependence", NM="_ZNK5clang6driver13OffloadAction25getSingleDeviceDependenceEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZNK5clang6driver13OffloadAction25getSingleDeviceDependenceEb")
  //</editor-fold>
  public Action /*P*/ getSingleDeviceDependence() /*const*/ {
    return getSingleDeviceDependence(false);
  }
  public Action /*P*/ getSingleDeviceDependence(boolean DoNotConsiderHostActions/*= false*/) /*const*/ {
    assert (hasSingleDeviceDependence(DoNotConsiderHostActions)) : "Single device dependence does not exist!";
    // The previous assert ensures the number of entries in getInputs() is
    // consistent with what we are doing here.
    return (HostTC != null) ? getInputs().$at(1) : getInputs().front();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 324,
   FQN="clang::driver::OffloadAction::classof", NM="_ZN5clang6driver13OffloadAction7classofEPKNS0_6ActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadAction7classofEPKNS0_6ActionE")
  //</editor-fold>
  public static boolean classof(/*const*/Action/*P*/ A) {
    return A.getKind() == ActionClass.OffloadClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::OffloadAction::~OffloadAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 208,
   FQN="clang::driver::OffloadAction::~OffloadAction", NM="_ZN5clang6driver13OffloadActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13OffloadActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DevToolChains.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "HostTC=" + HostTC // NOI18N
              + ", DevToolChains=" + DevToolChains // NOI18N
              + super.toString(); // NOI18N
  }
}
