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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.llvm.support.sys.fs.*;
import static org.clang.driver.java.JavaDriverSupport.*;


/// Compilation - A set of tasks to perform for a single driver
/// invocation.
//<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 35,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 34,
 FQN="clang::driver::Compilation", NM="_ZN5clang6driver11CompilationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11CompilationE")
//</editor-fold>
public class Compilation implements Destructors.ClassWithDestructor {
  /// The driver we were created by.
  private /*const*/ Driver /*&*/ TheDriver;
  
  /// The default tool chain.
  private /*const*/ ToolChain /*&*/ DefaultToolChain;
  
  /// A mask of all the programming models the host has to support in the
  /// current compilation.
  private /*uint*/int ActiveOffloadMask;
  
  /// Array with the toolchains of offloading host and devices in the order they
  /// were requested by the user. We are preserving that order in case the code
  /// generation needs to derive a programming-model-specific semantic out of
  /// it.
  private std.multimapUIntType/*Action::OffloadKind*//*uint*/</*const*/ ToolChain /*P*/ > OrderedOffloadingToolchains;
  
  /// The original (untranslated) input argument list.
  private InputArgList /*P*/ Args;
  
  /// The driver translated arguments. Note that toolchains may perform their
  /// own argument translation.
  private DerivedArgList /*P*/ TranslatedArgs;
  
  /// The list of actions we've created via MakeAction.  This is not accessible
  /// to consumers; it's here just to manage ownership.
  private std.vector<std.unique_ptr<Action>> AllActions;
  
  /// The list of actions.  This is maintained and modified by consumers, via
  /// getActions().
  private /*ActionList*/SmallVector<Action /*P*/> Actions;
  
  /// The root list of jobs.
  private JobList Jobs;
  
  /// Cache of translated arguments for a particular tool chain and bound
  /// architecture.
  private DenseMap<std.pair</*const*/ ToolChain /*P*/ , /*const*/char$ptr/*char P*/ >, DerivedArgList /*P*/ > TCArgs;
  
  /// Temporary files which should be removed on exit.
  private ArgStringList TempFiles;
  
  /// Result files which should be removed on failure.
  private /*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr> ResultFiles;
  
  /// Result files which are generated correctly on failure, and which should
  /// only be removed if we crash.
  private /*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr> FailureResultFiles;
  
  /// Redirection for stdout, stderr, etc.
  private /*const*/type$ptr<StringRef> Redirects;
  
  /// Whether we're compiling for diagnostic purposes.
  private boolean ForDiagnostics;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::Compilation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 25,
   FQN="clang::driver::Compilation::Compilation", NM="_ZN5clang6driver11CompilationC1ERKNS0_6DriverERKNS0_9ToolChainEPN4llvm3opt12InputArgListEPNS9_14DerivedArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11CompilationC1ERKNS0_6DriverERKNS0_9ToolChainEPN4llvm3opt12InputArgListEPNS9_14DerivedArgListE")
  //</editor-fold>
  public Compilation(/*const*/ Driver /*&*/ D, /*const*/ ToolChain /*&*/ _DefaultToolChain, 
      InputArgList /*P*/ _Args, DerivedArgList /*P*/ _TranslatedArgs) {
    /* : TheDriver(D), DefaultToolChain(_DefaultToolChain), ActiveOffloadMask(0uU), OrderedOffloadingToolchains(), Args(_Args), TranslatedArgs(_TranslatedArgs), AllActions(), Actions(), Jobs(), TCArgs(), TempFiles(), ResultFiles(), FailureResultFiles(), Redirects(null), ForDiagnostics(false)*/ 
    //START JInit
    this./*&*/TheDriver=/*&*/D;
    this./*&*/DefaultToolChain=/*&*/_DefaultToolChain;
    this.ActiveOffloadMask = 0/*U*/;
    this.OrderedOffloadingToolchains = new std.multimapUIntType/*Action::OffloadKind*//*uint*/</*const*/ ToolChain /*P*/ >(null);
    this.Args = _Args;
    this.TranslatedArgs = _TranslatedArgs;
    this.AllActions = new std.vector<std.unique_ptr<Action>>(new std.unique_ptr<Action>());
    this.Actions = new /*ActionList*/SmallVector<Action /*P*/>(3, (Action/*P*/)null);
    this.Jobs = new JobList();
    this.TCArgs = new DenseMap<std.pair</*const*/ ToolChain /*P*/ , /*const*/char$ptr/*char P*/ >, DerivedArgList /*P*/ >(
            new DenseMapInfoPair(
                    DenseMapInfo$LikePtr.$Info(),
                    DenseMapInfoVoid$Ptr.$Info()),
            (DerivedArgList) null
    );
    this.TempFiles = new ArgStringList();
    this.ResultFiles = new /*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr>(DenseMapInfo$LikePtr.$Info(), (char$ptr) null);
    this.FailureResultFiles = new /*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr>(DenseMapInfo$LikePtr.$Info(), (char$ptr) null);
    this.Redirects = null;
    this.ForDiagnostics = false;
    //END JInit
    // The offloading host toolchain is the default tool chain.
    OrderedOffloadingToolchains.insert(std.make_pair_uint_Ptr(Action.OffloadKind.OFK_Host, /*AddrOf*/DefaultToolChain));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::~Compilation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 35,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 32,
   FQN="clang::driver::Compilation::~Compilation", NM="_ZN5clang6driver11CompilationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11CompilationD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (TranslatedArgs != null) { TranslatedArgs.$destroy();};
    if (Args != null) { Args.$destroy();};
    
    // Free any derived arg lists.
    for (DenseMapIterator<std.pair</*const*/ ToolChain /*P*/ , /*const*/ char$ptr/*char P*/ >, DerivedArgList /*P*/ > it = TCArgs.begin(), 
        ie = TCArgs.end(); it.$noteq(/*NO_ITER_COPY*/ie); it.$preInc())  {
      if (it.$arrow().second != TranslatedArgs) {
        if (it.$arrow().second != null) { it.$arrow().second.$destroy();};
      }
    }
    
    // Free redirections of stdout/stderr.
    if ((Redirects != null)) {
      /*delete*/Destructors.$destroy(Redirects.$at(0));
      /*delete*/Destructors.$destroy(Redirects.$at(1));
      /*delete*/Destructors.$destroy(Redirects.$at(2));
      /*delete[]*/Destructors.$destroyArray(Redirects);
    }
    //START JDestroy
    FailureResultFiles.$destroy();
    ResultFiles.$destroy();
    TempFiles.$destroy();
    TCArgs.$destroy();
    Jobs.$destroy();
    Actions.$destroy();
    AllActions.$destroy();
    OrderedOffloadingToolchains.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getDriver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 89,
   FQN="clang::driver::Compilation::getDriver", NM="_ZNK5clang6driver11Compilation9getDriverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation9getDriverEv")
  //</editor-fold>
  public /*const*/ Driver /*&*/ getDriver() /*const*/ {
    return TheDriver;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getDefaultToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 91,
   FQN="clang::driver::Compilation::getDefaultToolChain", NM="_ZNK5clang6driver11Compilation19getDefaultToolChainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation19getDefaultToolChainEv")
  //</editor-fold>
  public /*const*/ ToolChain /*&*/ getDefaultToolChain() /*const*/ {
    return DefaultToolChain;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::isOffloadingHostKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 102,
   FQN="clang::driver::Compilation::isOffloadingHostKind", NM="_ZNK5clang6driver11Compilation20isOffloadingHostKindENS0_6Action11OffloadKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation20isOffloadingHostKindENS0_6Action11OffloadKindE")
  //</editor-fold>
  public /*uint*/int isOffloadingHostKind(/*Action::OffloadKind*//*uint*/int Kind) /*const*/ {
    return ActiveOffloadMask & Kind;
  }

  
  /// Iterator that visits device toolchains of a given kind.
  /*typedef const std::multimap<Action::OffloadKind, const ToolChain *>::const_iterator const_offload_toolchains_iterator*/
//  public final class const_offload_toolchains_iterator extends /*const*/ _Rb_tree_const_iterator<pair</*const OffloadKind*//*uint*/int, /*const*/ ToolChain /*P*/ > >{ };
  /*typedef std::pair<const const_offload_toolchains_iterator, const const_offload_toolchains_iterator> const_offload_toolchains_range*/
//  public final class const_offload_toolchains_range extends std.pair</*const*/ _Rb_tree_const_iterator<pair</*const OffloadKind*//*uint*/int, /*const*/ ToolChain /*P*/ > >, /*const*/ _Rb_tree_const_iterator<pair</*const OffloadKind*//*uint*/int, /*const*/ ToolChain /*P*/ > > >{ };
  
  /*template <Action::OffloadKind Kind> TEMPLATE*/
  /*template <Action::OffloadKind Kind> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getOffloadToolChains">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 115,
   FQN="clang::driver::Compilation::getOffloadToolChains", NM="Tpl__ZNK5clang6driver11Compilation20getOffloadToolChainsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=Tpl__ZNK5clang6driver11Compilation20getOffloadToolChainsEv")
  //</editor-fold>
  public /*<Action::OffloadKind Kind>*/ std.pair<type$iterator<? , std.pairUIntType<ToolChain>>, type$iterator<?, std.pairUIntType<ToolChain>> > getOffloadToolChains(/*Action::OffloadKind*//*uint*/int Kind) /*const*/ {
    return OrderedOffloadingToolchains.equal_range(Kind);
  }

  
  /// Return an offload toolchain of the provided kind. Only one is expected to
  /// exist.
  /*template <Action::OffloadKind Kind> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getSingleOffloadToolChain">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 122,
   FQN="clang::driver::Compilation::getSingleOffloadToolChain", NM="Tpl__ZNK5clang6driver11Compilation25getSingleOffloadToolChainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=Tpl__ZNK5clang6driver11Compilation25getSingleOffloadToolChainEv")
  //</editor-fold>
  public /*<Action::OffloadKind Kind>*/ /*const*/ ToolChain /*P*/ getSingleOffloadToolChain(/*Action::OffloadKind*//*uint*/int Kind) /*const*/ {
    std.pair<type$iterator<? , std.pairUIntType<ToolChain>>, type$iterator<?, std.pairUIntType<ToolChain>> >  TCs = getOffloadToolChains(Kind);
    assert ($noteq_iter(TCs.first, TCs.second)) : "No tool chains of the selected kind exist!";
    assert ($eq_iter(std.next($tryClone(TCs.first)), TCs.second)) : "More than one tool chain of the this kind exist.";
    return TCs.first.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::addOffloadDeviceToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 132,
   FQN="clang::driver::Compilation::addOffloadDeviceToolChain", NM="_ZN5clang6driver11Compilation25addOffloadDeviceToolChainEPKNS0_9ToolChainENS0_6Action11OffloadKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation25addOffloadDeviceToolChainEPKNS0_9ToolChainENS0_6Action11OffloadKindE")
  //</editor-fold>
  public void addOffloadDeviceToolChain(/*const*/ ToolChain /*P*/ DeviceToolChain, 
                           /*Action::OffloadKind*//*uint*/int OffloadKind) {
    assert (OffloadKind != Action.OffloadKind.OFK_Host && OffloadKind != Action.OffloadKind.OFK_None) : "This is not a device tool chain!";
    
    // Update the host offload kind to also contain this kind.
    ActiveOffloadMask |= OffloadKind;
    OrderedOffloadingToolchains.insert(std.make_pair_uint_Ptr(OffloadKind, DeviceToolChain));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getInputArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 104,
   FQN="clang::driver::Compilation::getInputArgs", NM="_ZNK5clang6driver11Compilation12getInputArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation12getInputArgsEv")
  //</editor-fold>
  public /*const*/ InputArgList /*&*/ getInputArgs() /*const*/ {
    return /*Deref*/Args;
  }

  
  ////<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 106,
   FQN="clang::driver::Compilation::getArgs", NM="_ZNK5clang6driver11Compilation7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation7getArgsEv")
  //</editor-fold>
  public /*const*/ DerivedArgList /*&*/ getArgs$Const() /*const*/ {
    return /*Deref*/TranslatedArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 108,
   FQN="clang::driver::Compilation::getArgs", NM="_ZN5clang6driver11Compilation7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation7getArgsEv")
  //</editor-fold>
  public DerivedArgList /*&*/ getArgs() {
    return /*Deref*/TranslatedArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getActions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 110,
   FQN="clang::driver::Compilation::getActions", NM="_ZN5clang6driver11Compilation10getActionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation10getActionsEv")
  //</editor-fold>
  public /*ActionList*/SmallVector<Action /*P*/>/*&*/ getActions() {
    return Actions;
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getActions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 111,
   FQN="clang::driver::Compilation::getActions", NM="_ZNK5clang6driver11Compilation10getActionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation10getActionsEv")
  //</editor-fold>
  public /*const*//*ActionList*/SmallVector<Action /*P*/>/*&*/ getActions$Const() /*const*/ {
    return Actions;
  }

  
  /// Creates a new Action owned by this Compilation.
  ///
  /// The new Action is *not* added to the list returned by getActions().
  /*template <typename T, typename ... Args> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::MakeAction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*takes action directly and caller must create it*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 155,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 116,
   FQN="clang::driver::Compilation::MakeAction", NM="Tpl__ZN5clang6driver11Compilation10MakeActionEDpOT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=Tpl__ZN5clang6driver11Compilation10MakeActionEDpOT0_")
  //</editor-fold>
  public </*typename*/ T extends Action> T /*P*/ MakeAction(T A) {
    // T /*P*/ RawPtr = new T(( std.<Args>forward(Arg)... ));
    AllActions.push_back_T$RR(new std.unique_ptr<Action>(A));
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getJobs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 161,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 122,
   FQN="clang::driver::Compilation::getJobs", NM="_ZN5clang6driver11Compilation7getJobsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation7getJobsEv")
  //</editor-fold>
  public JobList /*&*/ getJobs() {
    return Jobs;
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getJobs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 123,
   FQN="clang::driver::Compilation::getJobs", NM="_ZNK5clang6driver11Compilation7getJobsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation7getJobsEv")
  //</editor-fold>
  public /*const*/ JobList /*&*/ getJobs$Const() /*const*/ {
    return Jobs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::addCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 164,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 125,
   FQN="clang::driver::Compilation::addCommand", NM="_ZN5clang6driver11Compilation10addCommandESt10unique_ptrINS0_7CommandESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation10addCommandESt10unique_ptrINS0_7CommandESt14default_deleteIS3_EE")
  //</editor-fold>
  public void addCommand(std.unique_ptr<Command> C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Jobs.addJob($c$.track(new std.unique_ptr<Command>(JD$Move.INSTANCE, std.move(C)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getTempFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 127,
   FQN="clang::driver::Compilation::getTempFiles", NM="_ZNK5clang6driver11Compilation12getTempFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation12getTempFilesEv")
  //</editor-fold>
  public /*const*/ArgStringList/*&*/ getTempFiles() /*const*/ {
    return TempFiles;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getResultFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 168,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 129,
   FQN="clang::driver::Compilation::getResultFiles", NM="_ZNK5clang6driver11Compilation14getResultFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation14getResultFilesEv")
  //</editor-fold>
  public /*const*//*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr>/*&*/ getResultFiles() /*const*/ {
    return ResultFiles;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getFailureResultFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 170,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 131,
   FQN="clang::driver::Compilation::getFailureResultFiles", NM="_ZNK5clang6driver11Compilation21getFailureResultFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation21getFailureResultFilesEv")
  //</editor-fold>
  public /*const*//*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr>/*&*/ getFailureResultFiles() /*const*/ {
    return FailureResultFiles;
  }

  
  /// Returns the sysroot path.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getSysRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 232,
   FQN="clang::driver::Compilation::getSysRoot", NM="_ZNK5clang6driver11Compilation10getSysRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation10getSysRootEv")
  //</editor-fold>
  public StringRef getSysRoot() /*const*/ {
    return new StringRef(getDriver().SysRoot);
  }

  
  /// getArgsForToolChain - Return the derived argument list for the
  /// tool chain \p TC (or the default tool chain, if TC is not specified).
  ///
  /// \param BoundArch - The bound architecture name, or 0.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::getArgsForToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 55,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 51,
   FQN="clang::driver::Compilation::getArgsForToolChain", NM="_ZN5clang6driver11Compilation19getArgsForToolChainEPKNS0_9ToolChainEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation19getArgsForToolChainEPKNS0_9ToolChainEPKc")
  //</editor-fold>
  public /*const*/ DerivedArgList /*&*/ getArgsForToolChain(/*const*/ ToolChain /*P*/ TC, 
                     /*const*/char$ptr/*char P*/ BoundArch) {
    if (!(TC != null)) {
      TC = $AddrOf(DefaultToolChain);
    }
    
    final type$ref<DerivedArgList /*P*/ /*&*/> Entry = TCArgs.ref$at(std.make_pair_Ptr_T(TC, BoundArch));
    if (!(Entry.$deref() != null)) {
      Entry.$set(TC.TranslateArgs($Deref(TranslatedArgs), BoundArch));
      if (!(Entry.$deref() != null)) {
        Entry.$set(TranslatedArgs);
      }
    }
    
    return $Deref(Entry.$deref());
  }

  
  /// addTempFile - Add a file to remove on exit, and returns its
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::addTempFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 186,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 147,
   FQN="clang::driver::Compilation::addTempFile", NM="_ZN5clang6driver11Compilation11addTempFileEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation11addTempFileEPKc")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ addTempFile(/*const*/char$ptr/*char P*/ Name) {
    TempFiles.push_back(Name);
    return Name;
  }

  
  /// addResultFile - Add a file to remove on failure, and returns its
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::addResultFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 154,
   FQN="clang::driver::Compilation::addResultFile", NM="_ZN5clang6driver11Compilation13addResultFileEPKcPKNS0_9JobActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation13addResultFileEPKcPKNS0_9JobActionE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ addResultFile(/*const*/char$ptr/*char P*/ Name, /*const*/ JobAction /*P*/ JA) {
    ResultFiles.$set(JA, Name);
    return Name;
  }

  
  /// addFailureResultFile - Add a file to remove if we crash, and returns its
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::addFailureResultFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 200,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 161,
   FQN="clang::driver::Compilation::addFailureResultFile", NM="_ZN5clang6driver11Compilation20addFailureResultFileEPKcPKNS0_9JobActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation20addFailureResultFileEPKcPKNS0_9JobActionE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ addFailureResultFile(/*const*/char$ptr/*char P*/ Name, /*const*/ JobAction /*P*/ JA) {
    FailureResultFiles.$set(JA, Name);
    return Name;
  }

  
  /// CleanupFile - Delete a given file.
  ///
  /// \param IssueErrors - Report failures as errors.
  /// \return Whether the file was removed successfully.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::CleanupFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 66,
   FQN="clang::driver::Compilation::CleanupFile", NM="_ZNK5clang6driver11Compilation11CleanupFileEPKcb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation11CleanupFileEPKcb")
  //</editor-fold>
  public boolean CleanupFile(/*const*/char$ptr/*char P*/ File) /*const*/ {
    return CleanupFile(File, false);
  }
  public boolean CleanupFile(/*const*/char$ptr/*char P*/ File, boolean IssueErrors/*= false*/) /*const*/ {
    // FIXME: Why are we trying to remove files that we have not created? For
    // example we should only try to remove a temporary assembly file if
    // "clang -cc1" succeed in writing it. Was this a workaround for when
    // clang was writing directly to a .s file and sometimes leaving it behind
    // during a failure?
    
    // FIXME: If this is necessary, we can still try to split
    // llvm::sys::fs::remove into a removeFile and a removeDir and avoid the
    // duplicated stat from is_regular_file.
    
    // Don't try to remove files which we don't have write access to (but may be
    // able to remove), or non-regular files. Underlying tools may have
    // intentionally not overwritten them.
    if (!fs.can_write(new Twine(File)) || !fs.is_regular_file(new Twine(File))) {
      return true;
    }
    {
      
      std.error_code EC = fs.remove(new Twine(File));
      if (EC.$bool()) {
        // Failure is only failure if the file exists and is "regular". We checked
        // for it being regular before, and llvm::sys::fs::remove ignores ENOENT,
        // so we don't need to check again.
        if (IssueErrors) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_unable_to_remove_file)), 
                new StringRef(EC.message())));
          } finally {
            $c$.$destroy();
          }
        }
        return false;
      }
    }
    return true;
  }

  
  /// CleanupFileList - Remove the files in the given list.
  ///
  /// \param IssueErrors - Report failures as errors.
  /// \return Whether all files were removed successfully.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::CleanupFileList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 96,
   FQN="clang::driver::Compilation::CleanupFileList", NM="_ZNK5clang6driver11Compilation15CleanupFileListERKN4llvm11SmallVectorIPKcLj16EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation15CleanupFileListERKN4llvm11SmallVectorIPKcLj16EEEb")
  //</editor-fold>
  public boolean CleanupFileList(/*const*/ArgStringList/*&*/ Files) /*const*/ {
    return CleanupFileList(Files, 
                 false);
  }
  public boolean CleanupFileList(/*const*/ArgStringList/*&*/ Files, 
                 boolean IssueErrors/*= false*/) /*const*/ {
    boolean Success = true;
    for (type$ptr<char$ptr> /*ArgStringList*/ it = $tryClone(Files.begin()), /*P*/ ie = $tryClone(Files.end()); $noteq_iter(it, ie); it.$preInc())  {
      Success &= CleanupFile(it.$star(), IssueErrors);
    }
    return Success;
  }

  
  /// CleanupFileMap - Remove the files in the given map.
  ///
  /// \param JA - If specified, only delete the files associated with this
  /// JobAction.  Otherwise, delete all files in the map.
  /// \param IssueErrors - Report failures as errors.
  /// \return Whether all files were removed successfully.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::CleanupFileMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 105,
   FQN="clang::driver::Compilation::CleanupFileMap", NM="_ZNK5clang6driver11Compilation14CleanupFileMapERKN4llvm8DenseMapIPKNS0_9JobActionEPKcNS2_12DenseMapInfoIS6_EENS2_6detail12DenseMapPairIS6_S8_EEEES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation14CleanupFileMapERKN4llvm8DenseMapIPKNS0_9JobActionEPKcNS2_12DenseMapInfoIS6_EENS2_6detail12DenseMapPairIS6_S8_EEEES6_b")
  //</editor-fold>
  public boolean CleanupFileMap(/*const*//*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr>/*&*/ Files, 
                /*const*/ JobAction /*P*/ JA) /*const*/ {
    return CleanupFileMap(Files, 
                JA, 
                false);
  }
  public boolean CleanupFileMap(/*const*//*ArgStringMap*/DenseMap</*const*/ JobAction /*P*/, /*const*/ char$ptr>/*&*/ Files, 
                /*const*/ JobAction /*P*/ JA, 
                boolean IssueErrors/*= false*/) /*const*/ {
    boolean Success = true;
    for (DenseMapIterator</*const*/ JobAction, /*const*/char$ptr> it = Files.begin(), ie = Files.end(); it.$noteq(ie); it.$preInc()) {
      
      // If specified, only delete the files associated with the JobAction.
      // Otherwise, delete all files in the map.
      if ((JA != null) && it.$arrow().first != JA) {
        continue;
      }
      Success &= CleanupFile(it.$arrow().second, IssueErrors);
    }
    return Success;
  }

  
  /// ExecuteCommand - Execute an actual command.
  ///
  /// \param FailingCommand - For non-zero results, this will be set to the
  /// Command which failed, if any.
  /// \return The result code of the subprocess.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::ExecuteCommand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 125,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 121,
   FQN="clang::driver::Compilation::ExecuteCommand", NM="_ZNK5clang6driver11Compilation14ExecuteCommandERKNS0_7CommandERPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation14ExecuteCommandERKNS0_7CommandERPS3_")
  //</editor-fold>
  public int ExecuteCommand(/*const*/ Command /*&*/ C, 
                type$ref<Command /*P*/> /*&*/ FailingCommand) /*const*/ {
    if ((getDriver().CCPrintOptions
       || getArgs().hasArg(new OptSpecifier(options.ID.OPT_v.getValue()))) && !getDriver().CCGenDiagnostics) {
      raw_ostream /*P*/ OS = /*AddrOf*/llvm.errs();
      
      // Follow gcc implementation of CC_PRINT_OPTIONS; we could also cache the
      // output stream.
      if (getDriver().CCPrintOptions && (getDriver().CCPrintOptionsFilename != null)) {
        std.error_code EC/*J*/= new std.error_code();
        OS = new raw_fd_ostream(new StringRef(getDriver().CCPrintOptionsFilename), EC, 
            $bitor_OpenFlags(/*KEEP_ENUM*/fs.OpenFlags.F_Append, 
                /*KEEP_ENUM*/fs.OpenFlags.F_Text));
        if (EC.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_cc_print_options_failure)), 
                new StringRef(EC.message())));
            FailingCommand.$set(/*AddrOf*/C);
            if (OS != null) { OS.$destroy();};
            return 1;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (getDriver().CCPrintOptions) {
        /*Deref*/OS.$out(/*KEEP_STR*/"[Logging clang options]");
      }
      
      C.Print(/*Deref*/OS, $LF, /*Quote=*/ getDriver().CCPrintOptions);
      if (OS != /*AddrOf*/llvm.errs()) {
        if (OS != null) { OS.$destroy();};
      }
    }
    
    std.string Error/*J*/= new std.string();
    bool$ptr ExecutionFailed = create_bool$ptr();
    int Res = C.Execute(Redirects, /*AddrOf*/Error, /*AddrOf*/ExecutionFailed);
    if (!Error.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert ((Res != 0)) : "Error string set with 0 result code!";
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_command_failure)), new StringRef(Error)));
      } finally {
        $c$.$destroy();
      }
    }
    if ((Res != 0)) {
      FailingCommand.$set(/*AddrOf*/C);
    }
    
    return ExecutionFailed.$star() ? 1 : Res;
  }

  
  /// ExecuteJob - Execute a single job.
  ///
  /// \param FailingCommands - For non-zero results, this will be a vector of
  /// failing commands and their associated result code.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::ExecuteJobs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use type$ref<Command>*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 170,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 191,
   FQN="clang::driver::Compilation::ExecuteJobs", NM="_ZNK5clang6driver11Compilation11ExecuteJobsERKNS0_7JobListERN4llvm15SmallVectorImplISt4pairIiPKNS0_7CommandEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation11ExecuteJobsERKNS0_7JobListERN4llvm15SmallVectorImplISt4pairIiPKNS0_7CommandEEEE")
  //</editor-fold>
  public void ExecuteJobs(/*const*/ JobList /*&*/ Jobs, 
             SmallVectorImpl<std.pairIntPtr</*const*/ Command /*P*/ > > /*&*/ FailingCommands) /*const*/ {
    for (/*const*/ Command /*&*/ Job : Jobs) {
      /*const*/ type$ref<Command /*P*/> FailingCommand = create_type$ref((Command) null);
      {
        int Res = ExecuteCommand(Job, FailingCommand);
        if ((Res != 0)) {
          FailingCommands.push_back(std.make_pair_int_Ptr(Res, FailingCommand.$deref()));
          // Bail as soon as one command fails, so we don't output duplicate error
          // messages if we die on e.g. the same file.
          return;
        }
      }
    }
  }

  
  /// initCompilationForDiagnostics - Remove stale state and suppress output
  /// so compilation can be reexecuted to generate additional diagnostic
  /// information (e.g., preprocessed source(s)).
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::initCompilationForDiagnostics">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", old_line = 202,
   FQN="clang::driver::Compilation::initCompilationForDiagnostics", NM="_ZN5clang6driver11Compilation29initCompilationForDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation29initCompilationForDiagnosticsEv")
  //</editor-fold>
  public void initCompilationForDiagnostics() {
    ForDiagnostics = true;
    
    // Free actions and jobs.
    Actions.clear();
    AllActions.clear();
    Jobs.clear();
    
    // Clear temporary/results file lists.
    TempFiles.clear();
    ResultFiles.clear();
    FailureResultFiles.clear();
    
    // Remove any user specified output.  Claim any unclaimed arguments, so as
    // to avoid emitting warnings about unused args.
    OptSpecifier OutputOpts[/*3*/] = $IDsToOptSpecifiers(new options.ID [/*3*/] {
      options.ID.OPT_o, options.ID.OPT_MD, 
      options.ID.OPT_MMD});
    for (/*uint*/int i = 0, e = llvm.array_lengthof(OutputOpts); i != e; ++i) {
      if (TranslatedArgs.hasArg(/*NO_COPY*/OutputOpts[i])) {
        TranslatedArgs.eraseArg(/*NO_COPY*/OutputOpts[i]);
      }
    }
    TranslatedArgs.ClaimAllArgs();
    
    // Redirect stdout/stderr to /dev/null.
    Redirects = create_type$ptr(new /*const*/ StringRef /*P*/ [3]);//(/*implicit-init*/((/*const*/ StringRef /*P*/ )/*zero-init*/null)));
    Redirects.$set(0, null);
    Redirects.$set(1, new StringRef()); // JAVA: will be destroyed, so do not use const
    Redirects.$set(2, new StringRef()); // JAVA: will be destroyed, so do not use const
  }

  
  /// Return true if we're compiling for diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::isForDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", line = 249,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Compilation.h", old_line = 210,
   FQN="clang::driver::Compilation::isForDiagnostics", NM="_ZNK5clang6driver11Compilation16isForDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver11Compilation16isForDiagnosticsEv")
  //</editor-fold>
  public boolean isForDiagnostics() /*const*/ {
    return ForDiagnostics;
  }

  
  /// Redirect - Redirect output of this compilation. Can only be done once.
  ///
  /// \param Redirects - array of pointers to paths. The array
  /// should have a size of three. The inferior process's
  /// stdin(0), stdout(1), and stderr(2) will be redirected to the
  /// corresponding paths. This compilation instance becomes
  /// the owner of Redirects and will delete the array and StringRef's.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::Compilation::Redirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp", line = 218,
   FQN="clang::driver::Compilation::Redirect", NM="_ZN5clang6driver11Compilation8RedirectEPPKN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver11Compilation8RedirectEPPKN4llvm9StringRefE")
  //</editor-fold>
  public void Redirect(/*const*/type$ptr<StringRef> Redirects) {
    this.Redirects = $tryClone(Redirects);
  }

  private static class DummyToolChain extends ToolChain {

    private DummyToolChain() {
      super();
    }

    @Override
    public boolean isPICDefault() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean isPIEDefault() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean isPICDefaultForced() {
      throw new UnsupportedOperationException("Not supported.");
    }      
  }
  
  public String toString() {
    return "" + "TheDriver=" + TheDriver // NOI18N
              + ", DefaultToolChain=" + DefaultToolChain // NOI18N
              + ", ActiveOffloadMask=" + ActiveOffloadMask // NOI18N
              + ", OrderedOffloadingToolchains=" + OrderedOffloadingToolchains // NOI18N
              + ", Args=" + Args // NOI18N
              + ", TranslatedArgs=" + TranslatedArgs // NOI18N
              + ", AllActions=" + AllActions // NOI18N
              + ", Actions=" + Actions // NOI18N
              + ", Jobs=" + Jobs // NOI18N
              + ", TCArgs=" + TCArgs // NOI18N
              + ", TempFiles=" + TempFiles // NOI18N
              + ", ResultFiles=" + ResultFiles // NOI18N
              + ", FailureResultFiles=" + FailureResultFiles // NOI18N
              + ", Redirects=" + Redirects // NOI18N
              + ", ForDiagnostics=" + ForDiagnostics; // NOI18N
  }
}
