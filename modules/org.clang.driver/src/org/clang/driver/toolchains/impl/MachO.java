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

package org.clang.driver.toolchains.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolChainsStatics.*;
import static org.clang.driver.ToolChain.*;
import org.clang.driver.tools.impl.ArmStatics;
import org.clang.driver.tools.impl.DarwinStatics;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 255,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 237,
 FQN="clang::driver::toolchains::MachO", NM="_ZN5clang6driver10toolchains5MachOE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains5MachOE")
//</editor-fold>
public class MachO extends /*public*/ ToolChain implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 222,
   FQN="clang::driver::toolchains::MachO::buildAssembler", NM="_ZNK5clang6driver10toolchains5MachO14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new DarwinStatics.Assembler(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 220,
   FQN="clang::driver::toolchains::MachO::buildLinker", NM="_ZNK5clang6driver10toolchains5MachO11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new DarwinStatics.Linker(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::getTool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 212,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 201,
   FQN="clang::driver::toolchains::MachO::getTool", NM="_ZNK5clang6driver10toolchains5MachO7getToolENS0_6Action11ActionClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO7getToolENS0_6Action11ActionClassE")
  //</editor-fold>
  @Override protected Tool /*P*/ getTool(Action.ActionClass AC) /*const*//* override*/ {
    switch (AC) {
     case LipoJobClass:
      if (!Lipo.$bool()) {
        Lipo.reset(new DarwinStatics.Lipo(/*Deref*/this));
      }
      return Lipo.get();
     case DsymutilJobClass:
      if (!Dsymutil.$bool()) {
        Dsymutil.reset(new DarwinStatics.Dsymutil(/*Deref*/this));
      }
      return Dsymutil.get();
     case VerifyDebugInfoJobClass:
      if (!VerifyDebug.$bool()) {
        VerifyDebug.reset(new DarwinStatics.VerifyDebug(/*Deref*/this));
      }
      return VerifyDebug.get();
     default:
      return super.getTool(AC);
    }
  }


/*private:*/
  private /*mutable */std.unique_ptr<DarwinStatics.Lipo> Lipo;
  private /*mutable */std.unique_ptr<DarwinStatics.Dsymutil> Dsymutil;
  private /*mutable */std.unique_ptr<DarwinStatics.VerifyDebug> VerifyDebug;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::MachO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 45,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 44,
   FQN="clang::driver::toolchains::MachO::MachO", NM="_ZN5clang6driver10toolchains5MachOC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains5MachOC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public MachO(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, /*const*/ ArgList /*&*/ Args) {
    /* : ToolChain(D, Triple, Args), Lipo(), Dsymutil(), VerifyDebug()*/
    //START JInit
    super(D, Triple, Args);
    this.Lipo = new std.unique_ptr<DarwinStatics.Lipo>();
    this.Dsymutil = new std.unique_ptr<DarwinStatics.Dsymutil>();
    this.VerifyDebug = new std.unique_ptr<DarwinStatics.VerifyDebug>();
    //END JInit
    // We expect 'as', 'ld', etc. to be adjacent to our install dir.
    getProgramPaths().push_back(new std.string(getDriver().getInstalledDir()));
    if ($noteq_T_str$C(getDriver().getInstalledDir(), getDriver().Dir)) {
      getProgramPaths().push_back(getDriver().Dir);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::~MachO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 177,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 166,
   FQN="clang::driver::toolchains::MachO::~MachO", NM="_ZN5clang6driver10toolchains5MachOD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains5MachOD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    VerifyDebug.$destroy();
    Dsymutil.$destroy();
    Lipo.$destroy();
    super.$destroy();
    //END JDestroy
  }



  /// @name MachO specific toolchain API
  /// {

  /// Get the "MachO" arch name for a particular compiler invocation. For
  /// example, Apple treats different ARM variations as distinct architectures.

  /// @name MachO specific toolchain API
  /// {

  /// Get the "MachO" arch name for a particular compiler invocation. For
  /// example, Apple treats different ARM variations as distinct architectures.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::getMachOArchName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 153,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 142,
   FQN="clang::driver::toolchains::MachO::getMachOArchName", NM="_ZNK5clang6driver10toolchains5MachO16getMachOArchNameERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO16getMachOArchNameERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public StringRef getMachOArchName(/*const*/ ArgList /*&*/ Args) /*const*/ {
    switch (getTriple().getArch()) {
     default:
      return getDefaultUniversalArchName();
     case aarch64:
      return new StringRef(/*KEEP_STR*/"arm64");
     case thumb:
     case arm:
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
        if ((A != null)) {
          {
            /*const*/char$ptr/*char P*/ Arch = $tryClone(ArmMachOArchName(new StringRef(A.getValue())));
            if ((Arch != null)) {
              return new StringRef(Arch);
            }
          }
        }
      }
      {

        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
        if ((A != null)) {
          {
            /*const*/char$ptr/*char P*/ Arch = $tryClone(ArmMachOArchNameCPU(new StringRef(A.getValue())));
            if ((Arch != null)) {
              return new StringRef(Arch);
            }
          }
        }
      }

      return new StringRef(/*KEEP_STR*/"arm");
    }
  }



  /// Add the linker arguments to link the ARC runtime library.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::AddLinkARCArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 279,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 261,
   FQN="clang::driver::toolchains::MachO::AddLinkARCArgs", NM="_ZNK5clang6driver10toolchains5MachO14AddLinkARCArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO14AddLinkARCArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public /*virtual*/ void AddLinkARCArgs(/*const*/ ArgList /*&*/ Args,
                ArgStringList/*&*/ CmdArgs) /*const*/ {
  }


  /// Add the linker arguments to link the compiler runtime library.

  /// Add the linker arguments to link the compiler runtime library.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::AddLinkRuntimeLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1015,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 978,
   FQN="clang::driver::toolchains::MachO::AddLinkRuntimeLibArgs", NM="_ZNK5clang6driver10toolchains5MachO21AddLinkRuntimeLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO21AddLinkRuntimeLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddLinkRuntimeLibArgs(/*const*/ ArgList /*&*/ Args,
                       ArgStringList/*&*/ CmdArgs) /*const*/ {
    // Embedded targets are simple at the moment, not supporting sanitizers and
    // with different libraries for each member of the product { static, PIC } x
    // { hard-float, soft-float }
    SmallString/*32*/ CompilerRT = new SmallString/*32*/(new StringRef(/*KEEP_STR*/"libclang_rt."), 32);
    CompilerRT.$addassign(/*STRINGREF_STR*/(ArmStatics.getARMFloatABI(/*Deref*/this, Args) == ArmStatics.FloatABI.Hard) ? $("hard") : $("soft"));
    CompilerRT.$addassign(/*STRINGREF_STR*/Args.hasArg(new OptSpecifier(options.ID.OPT_fPIC.getValue())) ? $("_pic.a") : $("_static.a"));

    AddLinkRuntimeLib(Args, CmdArgs, CompilerRT.$StringRef(), false, true);
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::addStartObjectFileArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 286,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 268,
   FQN="clang::driver::toolchains::MachO::addStartObjectFileArgs", NM="_ZNK5clang6driver10toolchains5MachO22addStartObjectFileArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO22addStartObjectFileArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public /*virtual*/ void addStartObjectFileArgs(/*const*/ ArgList /*&*/ Args,
                        ArgStringList/*&*/ CmdArgs) /*const*/ {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::addMinVersionArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 290,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 272,
   FQN="clang::driver::toolchains::MachO::addMinVersionArgs", NM="_ZNK5clang6driver10toolchains5MachO17addMinVersionArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO17addMinVersionArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public /*virtual*/ void addMinVersionArgs(/*const*/ ArgList /*&*/ Args,
                   ArgStringList/*&*/ CmdArgs) /*const*/ {
  }


  /// On some iOS platforms, kernel and kernel modules were built statically. Is
  /// this such a target?
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::isKernelStatic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 295,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 277,
   FQN="clang::driver::toolchains::MachO::isKernelStatic", NM="_ZNK5clang6driver10toolchains5MachO14isKernelStaticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO14isKernelStaticEv")
  //</editor-fold>
  public /*virtual*/ boolean isKernelStatic() /*const*/ {
    return false;
  }


  /// Is the target either iOS or an iOS simulator?
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::isTargetIOSBased">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 298,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 280,
   FQN="clang::driver::toolchains::MachO::isTargetIOSBased", NM="_ZNK5clang6driver10toolchains5MachO16isTargetIOSBasedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO16isTargetIOSBasedEv")
  //</editor-fold>
  public boolean isTargetIOSBased() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::AddLinkRuntimeLib">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 299,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 288,
   FQN="clang::driver::toolchains::MachO::AddLinkRuntimeLib", NM="_ZNK5clang6driver10toolchains5MachO17AddLinkRuntimeLibERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEENS3_9StringRefEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO17AddLinkRuntimeLibERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEENS3_9StringRefEbbb")
  //</editor-fold>
  public void AddLinkRuntimeLib(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs,
                   StringRef DarwinLibName) /*const*/ {
    AddLinkRuntimeLib(Args, CmdArgs,
                   DarwinLibName, false,
                   false, false);
  }
  public void AddLinkRuntimeLib(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs,
                   StringRef DarwinLibName, boolean AlwaysLink/*= false*/) /*const*/ {
    AddLinkRuntimeLib(Args, CmdArgs,
                   DarwinLibName, AlwaysLink,
                   false, false);
  }
  public void AddLinkRuntimeLib(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs,
                   StringRef DarwinLibName, boolean AlwaysLink/*= false*/,
                   boolean IsEmbedded/*= false*/) /*const*/ {
    AddLinkRuntimeLib(Args, CmdArgs,
                   DarwinLibName, AlwaysLink,
                   IsEmbedded, false);
  }
  public void AddLinkRuntimeLib(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs,
                   StringRef DarwinLibName, boolean AlwaysLink/*= false*/,
                   boolean IsEmbedded/*= false*/, boolean AddRPath/*= false*/) /*const*/ {
    SmallString/*128*/ Dir/*J*/= new SmallString/*128*/(new StringRef(getDriver().ResourceDir), 128);
    path.append(Dir, new Twine(/*KEEP_STR*/"lib"), new Twine(IsEmbedded ? $("macho_embedded") : $("darwin")));

    SmallString/*128*/ P/*J*/= new SmallString/*128*/(Dir);
    path.append(P, new Twine(DarwinLibName));

    // For now, allow missing resource libraries to support developers who may
    // not have compiler-rt checked out or integrated into their build (unless
    // we explicitly force linking with this library).
    if (AlwaysLink || getVFS().exists(new Twine(P))) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(P)));
    }

    // Adding the rpaths might negatively interact when other rpaths are involved,
    // so we should make sure we add the rpaths last, after all user-specified
    // rpaths. This is currently true from this place, but we need to be
    // careful if this function is ever called before user's rpaths are emitted.
    if (AddRPath) {
      assert (DarwinLibName.endswith(/*STRINGREF_STR*/".dylib")) : "must be a dynamic library";

      // Add @executable_path to rpath to support having the dylib copied with
      // the executable.
      CmdArgs.push_back($("-rpath"));
      CmdArgs.push_back($("@executable_path"));

      // Add the path to the resource dir to rpath to support using the dylib
      // from the default location without copying.
      CmdArgs.push_back($("-rpath"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(Dir)));
    }
  }



  /// Add any profiling runtime libraries that are needed. This is essentially a
  /// MachO specific version of addProfileRT in Tools.cpp.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::addProfileRTLibs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 289,
   FQN="clang::driver::toolchains::MachO::addProfileRTLibs", NM="_ZNK5clang6driver10toolchains5MachO16addProfileRTLibsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO16addProfileRTLibsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addProfileRTLibs(/*const*/ ArgList /*&*/ Args,
                  ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // There aren't any profiling libs for embedded targets currently.
  }


  /// }
  /// @name ToolChain Implementation
  /// {

  /// }
  /// @name ToolChain Implementation
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::ComputeEffectiveClangTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 168,
   FQN="clang::driver::toolchains::MachO::ComputeEffectiveClangTriple", NM="_ZNK5clang6driver10toolchains5MachO27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE")
  //</editor-fold>
  @Override public std.string ComputeEffectiveClangTriple(/*const*/ ArgList /*&*/ Args,
                             types.ID InputType) /*const*//* override*/ {
    Triple Triple/*J*/= new Triple(new Twine(ComputeLLVMTriple(Args, InputType)));

    return new std.string(Triple.getTriple());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::LookupTypeForExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 57,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 56,
   FQN="clang::driver::toolchains::MachO::LookupTypeForExtension", NM="_ZNK5clang6driver10toolchains5MachO22LookupTypeForExtensionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO22LookupTypeForExtensionEPKc")
  //</editor-fold>
  @Override public types.ID LookupTypeForExtension(/*const*/char$ptr/*char P*/ Ext) /*const*//* override*/ {
    types.ID Ty = types.lookupTypeForExtension(Ext);

    // Darwin always preprocesses assembly files (unless -x is used explicitly).
    if (Ty == types.ID.TY_PP_Asm) {
      return types.ID.TY_Asm;
    }

    return Ty;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::HasNativeLLVMSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 66,
   FQN="clang::driver::toolchains::MachO::HasNativeLLVMSupport", NM="_ZNK5clang6driver10toolchains5MachO20HasNativeLLVMSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO20HasNativeLLVMSupportEv")
  //</editor-fold>
  @Override public boolean HasNativeLLVMSupport() /*const*//* override*/ {
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::TranslateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 800,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 763,
   FQN="clang::driver::toolchains::MachO::TranslateArgs", NM="_ZNK5clang6driver10toolchains5MachO13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc")
  //</editor-fold>
  @Override public DerivedArgList /*P*/ TranslateArgs(/*const*/ DerivedArgList /*&*/ Args,
               /*const*/char$ptr/*char P*/ BoundArch) /*const*//* override*/ {
    DerivedArgList /*P*/ DAL = new DerivedArgList(Args.getBaseArgs());
    /*const*/ OptTable /*&*/ Opts = getDriver().getOpts();

    // FIXME: We really want to get out of the tool chain level argument
    // translation business, as it makes the driver functionality much
    // more opaque. For now, we follow gcc closely solely for the
    // purpose of easily achieving feature parity & testability. Once we
    // have something that works, we should reevaluate each translation
    // and try to push it down into tool specific logic.
    for (Arg /*P*/ A : Args) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_Xarch__.getValue()))) {
        std.unique_ptr<Arg> XarchArg = null;
        try {
          // Skip this argument unless the architecture matches either the toolchain
          // triple arch, or the arch being bound.
          Triple.ArchType XarchArch = DarwinStatics.getArchTypeForMachOArchName(new StringRef(A.getValue(0)));
          if (!(XarchArch == getArch()
             || ((BoundArch != null)
             && XarchArch
             == DarwinStatics.getArchTypeForMachOArchName(new StringRef(BoundArch))))) {
            continue;
          }

          Arg /*P*/ OriginalArg = A;
          /*uint*/uint$ref Index = create_uint$ref(Args.getBaseArgs().MakeIndex(new StringRef(A.getValue(1))));
          /*uint*/int Prev = Index.$deref();
          XarchArg/*J*/= new std.unique_ptr<Arg>(Opts.ParseOneArg(Args, Index));

          // If the argument parsing failed or more than one argument was
          // consumed, the -Xarch_ argument's parameter tried to consume
          // extra arguments. Emit an error and ignore.
          //
          // We also want to disallow any options which would alter the
          // driver behavior; that isn't going to work in our model. We
          // use isDriverOption() as an approximation, although things
          // like -O4 are going to slip through.
          if (!XarchArg.$bool() || $greater_uint(Index, Prev + 1)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_Xarch_argument_with_args)),
                  new StringRef(A.getAsString(Args))));
              continue;
            } finally {
              $c$.$destroy();
            }
          } else if (XarchArg.$arrow().getOption().hasFlag(options.ClangFlags.DriverOption)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_Xarch_argument_isdriver)),
                  new StringRef(A.getAsString(Args))));
              continue;
            } finally {
              $c$.$destroy();
            }
          }

          XarchArg.$arrow().setBaseArg(A);

          A = XarchArg.release();
          DAL.AddSynthesizedArg(A);

          // Linker input arguments require custom handling. The problem is that we
          // have already constructed the phase actions, so we can not treat them as
          // "input arguments".
          if (A.getOption().hasFlag(options.ClangFlags.LinkerInput)) {
            // Convert the argument into individual Zlinker_input_args.
            for (/*const*/char$ptr/*char P*/ Value : A.getValues()) {
              DAL.AddSeparateArg(OriginalArg, Opts.getOption(new OptSpecifier(options.ID.OPT_Zlinker_input.getValue())), new StringRef(Value));
            }
            continue;
          }
        } finally {
          if (XarchArg != null) { XarchArg.$destroy(); }
        }
      }

      // Sob. These is strictly gcc compatible for the time being. Apple
      // gcc translates options twice, which means that self-expanding
      // options add duplicates.
      switch (options.ID.valueOf(A.getOption().getID())) {
       default:
        DAL.append(A);
        break;
       case OPT_mkernel:
       case OPT_fapple_kext:
        DAL.append(A);
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_static.getValue())));
        break;
       case OPT_dependency_file:
        DAL.AddSeparateArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_MF.getValue())), new StringRef(A.getValue()));
        break;
       case OPT_gfull:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_g_Flag.getValue())));
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_fno_eliminate_unused_debug_symbols.getValue())));
        break;
       case OPT_gused:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_g_Flag.getValue())));
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_feliminate_unused_debug_symbols.getValue())));
        break;
       case OPT_shared:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_dynamiclib.getValue())));
        break;
       case OPT_fconstant_cfstrings:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_mconstant_cfstrings.getValue())));
        break;
       case OPT_fno_constant_cfstrings:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_mno_constant_cfstrings.getValue())));
        break;
       case OPT_Wnonportable_cfstrings:
        DAL.AddFlagArg(A,
            Opts.getOption(new OptSpecifier(options.ID.OPT_mwarn_nonportable_cfstrings.getValue())));
        break;
       case OPT_Wno_nonportable_cfstrings:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_mno_warn_nonportable_cfstrings.getValue())));
        break;
       case OPT_fpascal_strings:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_mpascal_strings.getValue())));
        break;
       case OPT_fno_pascal_strings:
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_mno_pascal_strings.getValue())));
        break;
      }
    }
    if (getTriple().getArch() == Triple.ArchType.x86
       || getTriple().getArch() == Triple.ArchType.x86_64) {
      if (!Args.hasArgNoClaim(new OptSpecifier(options.ID.OPT_mtune_EQ.getValue()))) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_mtune_EQ.getValue())),
            new StringRef(/*KEEP_STR*/"core2"));
      }
    }

    // Add the arch options based on the particular spelling of -arch, to match
    // how the driver driver works.
    if ((BoundArch != null)) {
      StringRef Name = new StringRef(BoundArch);
      /*const*/ Option MCpu = Opts.getOption(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
      /*const*/ Option MArch = Opts.getOption(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));

      // This code must be kept in sync with LLVM's getArchTypeForDarwinArch,
      // which defines the list of which architectures we accept.
      if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc")) {
        ;
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc601")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"601"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc603")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"603"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc604")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"604"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc604e")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"604e"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc750")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"750"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc7400")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"7400"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc7450")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"7450"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc970")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MCpu, new StringRef(/*KEEP_STR*/"970"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc64") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ppc64le")) {
        DAL.AddFlagArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_m64.getValue())));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"i386")) {
        ;
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"i486")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"i486"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"i586")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"i586"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"i686")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"i686"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pentium")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"pentium"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pentium2")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"pentium2"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pentpro")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"pentiumpro"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pentIIm3")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"pentium2"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"x86_64")) {
        DAL.AddFlagArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_m64.getValue())));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"x86_64h")) {
        DAL.AddFlagArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_m64.getValue())));
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"x86_64h"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"arm")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv4t"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv4t")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv4t"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv5")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv5tej"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xscale")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"xscale"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv6")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv6k"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv6m")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv6m"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv7")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv7a"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv7em")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv7em"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv7k")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv7k"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv7m")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv7m"));
      } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"armv7s")) {
        DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/MArch, new StringRef(/*KEEP_STR*/"armv7s"));
      }
    }

    return DAL;
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::IsBlocksDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 327,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 309,
   FQN="clang::driver::toolchains::MachO::IsBlocksDefault", NM="_ZNK5clang6driver10toolchains5MachO15IsBlocksDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO15IsBlocksDefaultEv")
  //</editor-fold>
  @Override public boolean IsBlocksDefault() /*const*//* override*/ {
    // Always allow blocks on Apple; users interested in versioning are
    // expected to use /usr/include/Block.h.
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 314,
   FQN="clang::driver::toolchains::MachO::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains5MachO28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    // Default integrated assembler to on for Apple's MachO targets.
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 337,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 319,
   FQN="clang::driver::toolchains::MachO::IsMathErrnoDefault", NM="_ZNK5clang6driver10toolchains5MachO18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO18IsMathErrnoDefaultEv")
  //</editor-fold>
  @Override public boolean IsMathErrnoDefault() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::IsEncodeExtendedBlockSignatureDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 339,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 321,
   FQN="clang::driver::toolchains::MachO::IsEncodeExtendedBlockSignatureDefault", NM="_ZNK5clang6driver10toolchains5MachO37IsEncodeExtendedBlockSignatureDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO37IsEncodeExtendedBlockSignatureDefaultEv")
  //</editor-fold>
  @Override public boolean IsEncodeExtendedBlockSignatureDefault() /*const*//* override*/ {
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::IsObjCNonFragileABIDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 323,
   FQN="clang::driver::toolchains::MachO::IsObjCNonFragileABIDefault", NM="_ZNK5clang6driver10toolchains5MachO26IsObjCNonFragileABIDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO26IsObjCNonFragileABIDefaultEv")
  //</editor-fold>
  @Override public boolean IsObjCNonFragileABIDefault() /*const*//* override*/ {
    // Non-fragile ABI is default for everything but i386.
    return getTriple().getArch() != Triple.ArchType.x86;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::UseObjCMixedDispatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 346,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 328,
   FQN="clang::driver::toolchains::MachO::UseObjCMixedDispatch", NM="_ZNK5clang6driver10toolchains5MachO20UseObjCMixedDispatchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO20UseObjCMixedDispatchEv")
  //</editor-fold>
  @Override public boolean UseObjCMixedDispatch() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::IsUnwindTablesDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1088,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1054,
   FQN="clang::driver::toolchains::MachO::IsUnwindTablesDefault", NM="_ZNK5clang6driver10toolchains5MachO21IsUnwindTablesDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO21IsUnwindTablesDefaultEv")
  //</editor-fold>
  @Override public boolean IsUnwindTablesDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::GetDefaultRuntimeLibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 350,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 332,
   FQN="clang::driver::toolchains::MachO::GetDefaultRuntimeLibType", NM="_ZNK5clang6driver10toolchains5MachO24GetDefaultRuntimeLibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO24GetDefaultRuntimeLibTypeEv")
  //</editor-fold>
  @Override public RuntimeLibType GetDefaultRuntimeLibType() /*const*//* override*/ {
    return ToolChain.RuntimeLibType.RLT_CompilerRT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1116,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1074,
   FQN="clang::driver::toolchains::MachO::isPICDefault", NM="_ZNK5clang6driver10toolchains5MachO12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1118,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1076,
   FQN="clang::driver::toolchains::MachO::isPIEDefault", NM="_ZNK5clang6driver10toolchains5MachO12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1120,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1078,
   FQN="clang::driver::toolchains::MachO::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains5MachO18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public boolean isPICDefaultForced() /*const*//* override*/ {
    return (getArch() == Triple.ArchType.x86_64
       || getArch() == Triple.ArchType.aarch64);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::SupportsProfiling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1125,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1083,
   FQN="clang::driver::toolchains::MachO::SupportsProfiling", NM="_ZNK5clang6driver10toolchains5MachO17SupportsProfilingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO17SupportsProfilingEv")
  //</editor-fold>
  @Override public boolean SupportsProfiling() /*const*//* override*/ {
    // Profiling instrumentation is only supported on x86.
    return getArch() == Triple.ArchType.x86 || getArch() == Triple.ArchType.x86_64;
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::SupportsObjCGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 360,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 342,
   FQN="clang::driver::toolchains::MachO::SupportsObjCGC", NM="_ZNK5clang6driver10toolchains5MachO14SupportsObjCGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO14SupportsObjCGCEv")
  //</editor-fold>
  @Override public boolean SupportsObjCGC() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::UseDwarfDebugFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1092,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1058,
   FQN="clang::driver::toolchains::MachO::UseDwarfDebugFlags", NM="_ZNK5clang6driver10toolchains5MachO18UseDwarfDebugFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5MachO18UseDwarfDebugFlagsEv")
  //</editor-fold>
  @Override public boolean UseDwarfDebugFlags() /*const*//* override*/ {
    {
      /*const*/char$ptr/*char P*/ S = $tryClone(/*::*/getenv($("RC_DEBUG_OPTIONS")));
      if ((S != null)) {
        return S.$at(0) != $$TERM;
      }
    }
    return false;
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MachO::UseSjLjExceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 364,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 346,
   FQN="clang::driver::toolchains::MachO::UseSjLjExceptions", NM="_ZNK5clang6driver10toolchains5MachO17UseSjLjExceptionsERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains5MachO17UseSjLjExceptionsERKN4llvm3opt7ArgListE")
  //</editor-fold>
  @Override public boolean UseSjLjExceptions(/*const*/ ArgList /*&*/ Args) /*const*//* override*/ {
    return false;
  }


  public String toString() {
    return "" + "Lipo=" + Lipo // NOI18N
              + ", Dsymutil=" + Dsymutil // NOI18N
              + ", VerifyDebug=" + VerifyDebug // NOI18N
              + super.toString(); // NOI18N
  }
/// }
}
