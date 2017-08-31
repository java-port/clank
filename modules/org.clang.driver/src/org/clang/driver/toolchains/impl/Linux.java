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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.driver.impl.ToolChainsStatics.*;
import org.clang.driver.java.DriverFunctionPointers.IncludeDirsFunc;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 822,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 783,
 FQN="clang::driver::toolchains::Linux", NM="_ZN5clang6driver10toolchains5LinuxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains5LinuxE")
//</editor-fold>
public class Linux extends /*public*/ Generic_ELF implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::Linux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3992,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3643,
   FQN="clang::driver::toolchains::Linux::Linux", NM="_ZN5clang6driver10toolchains5LinuxC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains5LinuxC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public Linux(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ _Triple, /*const*/ ArgList /*&*/ Args) {
    /* : Generic_ELF(D, Triple, Args), ExtraOpts()*/ 
    //START JInit
    super(D, _Triple, Args);
    this.ExtraOpts = new std.vectorString(std.string.EMPTY);
    //END JInit
    GCCInstallation.init(_Triple, Args);
    CudaInstallation.init(_Triple, Args);
    Multilibs.$assign(GCCInstallation.getMultilibs());
    Triple.ArchType Arch = _Triple.getArch();
    std.string SysRoot = computeSysRoot();
    
    // Cross-compiling binutils and GCC installations (vanilla and openSUSE at
    // least) put various tools in a triple-prefixed directory off of the parent
    // of the GCC installation. We use the GCC triple here to ensure that we end
    // up with tools that support the same amount of cross compiling as the
    // detected GCC installation. For example, if we find a GCC installation
    // targeting x86_64, but it is a bi-arch GCC installation, it can also be
    // used to target i386.
    // FIXME: This seems unlikely to be Linux-specific.
    SmallVector<std.string> /*&*/ PPaths = getProgramPaths();
    PPaths.push_back($add_Twine($add_Twine($add_StringRef_char$ptr$C(GCCInstallation.getParentLibPath(), /*KEEP_STR*/"/../"), 
                new Twine(GCCInstallation.getTriple().str())), new Twine(/*KEEP_STR*/"/bin")).
            str());
    
    Distro Distro = DetectDistro(D, Arch);
    if (IsOpenSUSE(Distro) || IsUbuntu(Distro)) {
      ExtraOpts.push_back(new std.string(/*KEEP_STR*/"-z"));
      ExtraOpts.push_back(new std.string(/*KEEP_STR*/"relro"));
    }
    if (Arch == Triple.ArchType.arm || Arch == Triple.ArchType.thumb) {
      ExtraOpts.push_back(new std.string(/*KEEP_STR*/"-X"));
    }
    
    /*const*/boolean IsAndroid = _Triple.isAndroid();
    /*const*/boolean IsMips = isMipsArch(Arch);
    if (IsMips && !SysRoot.empty()) {
      ExtraOpts.push_back($add_T_string$C(/*KEEP_STR*/"--sysroot=", SysRoot));
    }
    
    // Do not use 'gnu' hash style for Mips targets because .gnu.hash
    // and the MIPS ABI require .dynsym to be sorted in different ways.
    // .gnu.hash needs symbols to be grouped by hash code whereas the MIPS
    // ABI requires a mapping between the GOT and the symbol table.
    // Android loader does not support .gnu.hash.
    if (!IsMips && !IsAndroid) {
      if (IsRedhat(Distro) || IsOpenSUSE(Distro)
         || (IsUbuntu(Distro) && Distro.getValue() >= Distro.UbuntuMaverick.getValue())) {
        ExtraOpts.push_back(new std.string(/*KEEP_STR*/"--hash-style=gnu"));
      }
      if (IsDebian(Distro) || IsOpenSUSE(Distro) || Distro == Distro.UbuntuLucid
         || Distro == Distro.UbuntuJaunty || Distro == Distro.UbuntuKarmic) {
        ExtraOpts.push_back(new std.string(/*KEEP_STR*/"--hash-style=both"));
      }
    }
    if (IsRedhat(Distro) && Distro != Distro.RHEL5 && Distro != Distro.RHEL6) {
      ExtraOpts.push_back(new std.string(/*KEEP_STR*/"--no-add-needed"));
    }
    if (IsOpenSUSE(Distro)) {
      ExtraOpts.push_back(new std.string(/*KEEP_STR*/"--enable-new-dtags"));
    }
    
    // The selection of paths to try here is designed to match the patterns which
    // the GCC driver itself uses, as this is part of the GCC-compatible driver.
    // This was determined by running GCC in a fake filesystem, creating all
    // possible permutations of these directories, and seeing which ones it added
    // to the link paths.
    SmallVector<std.string> /*&*/ Paths = getFilePaths();
    
    /*const*/std.string OSLibDir = getOSLibDir(_Triple, Args).$string();
    /*const*/std.string MultiarchTriple = getMultiarchTriple(D, _Triple, new StringRef(SysRoot));
    
    // Add the multilib suffixed paths where they are available.
    if (GCCInstallation.isValid()) {
      /*const*/ Triple /*&*/ GCCTriple = GCCInstallation.getTriple();
      /*const*/std.string/*&*/ LibPath = GCCInstallation.getParentLibPath().$string();
      /*const*/ Multilib /*&*/ Multilib = GCCInstallation.getMultilib();
      /*const*/ MultilibSet /*&*/ Multilibs = GCCInstallation.getMultilibs();
      
      // Add toolchain / multilib specific file paths.
      addMultilibsFilePaths(D, Multilibs, Multilib, 
          GCCInstallation.getInstallPath(), Paths);
      
      // Sourcery CodeBench MIPS toolchain holds some libraries under
      // a biarch-like suffix of the GCC installation.
      addPathIfExists(D, $add_Twine(new Twine(GCCInstallation.getInstallPath()), new Twine(Multilib.gccSuffix())), 
          Paths);
      
      // GCC cross compiling toolchains will install target libraries which ship
      // as part of the toolchain under <prefix>/<triple>/<libdir> rather than as
      // any part of the GCC installation in
      // <prefix>/<libdir>/gcc/<triple>/<version>. This decision is somewhat
      // debatable, but is the reality today. We need to search this tree even
      // when we have a sysroot somewhere else. It is the responsibility of
      // whomever is doing the cross build targeting a sysroot using a GCC
      // installation that is *not* within the system root to ensure two things:
      //
      //  1) Any DSOs that are linked in from this tree or from the install path
      //     above must be present on the system root and found via an
      //     appropriate rpath.
      //  2) There must not be libraries installed into
      //     <prefix>/<triple>/<libdir> unless they should be preferred over
      //     those within the system root.
      //
      // Note that this matches the GCC behavior. See the below comment for where
      // Clang diverges from GCC's behavior.
      addPathIfExists(D, new Twine($add_string_string$C($add_string_string$C($add_string_T($add_string_string$C($add_string$C_T(LibPath, /*KEEP_STR*/"/../"), GCCTriple.str()), /*KEEP_STR*/"/lib/../"), 
                      OSLibDir), Multilib.osSuffix())), 
          Paths);
      
      // If the GCC installation we found is inside of the sysroot, we want to
      // prefer libraries installed in the parent prefix of the GCC installation.
      // It is important to *not* use these paths when the GCC installation is
      // outside of the system root as that can pick up unintended libraries.
      // This usually happens when there is an external cross compiler on the
      // host system, and a more minimal sysroot available that is the target of
      // the cross. Note that GCC does include some of these directories in some
      // configurations but this seems somewhere between questionable and simply
      // a bug.
      if (new StringRef(LibPath).startswith(new StringRef(SysRoot))) {
        addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(LibPath, /*KEEP_STR*/"/"), MultiarchTriple)), Paths);
        addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(LibPath, /*KEEP_STR*/"/../"), OSLibDir)), Paths);
      }
    }
    
    // Similar to the logic for GCC above, if we currently running Clang inside
    // of the requested system root, add its parent library paths to
    // those searched.
    // FIXME: It's not clear whether we should use the driver's installed
    // directory ('Dir' below) or the ResourceDir.
    if (new StringRef(D.Dir).startswith(new StringRef(SysRoot))) {
      addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(D.Dir, /*KEEP_STR*/"/../lib/"), MultiarchTriple)), Paths);
      addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(D.Dir, /*KEEP_STR*/"/../"), OSLibDir)), Paths);
    }
    
    addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(SysRoot, /*KEEP_STR*/"/lib/"), MultiarchTriple)), Paths);
    addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(SysRoot, /*KEEP_STR*/"/lib/../"), OSLibDir)), Paths);
    addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/lib/"), MultiarchTriple)), Paths);
    addPathIfExists(D, new Twine($add_string_string$C($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/lib/../"), OSLibDir)), Paths);
    
    // Try walking via the GCC triple path in case of biarch or multiarch GCC
    // installations with strange symlinks.
    if (GCCInstallation.isValid()) {
      Multilib BiarchSibling = null;
      try {
        addPathIfExists(D, 
            new Twine($add_string_string$C($add_string_T($add_string_string$C($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/lib/"), GCCInstallation.getTriple().str()), 
                        /*KEEP_STR*/"/../../"), OSLibDir)), 
            Paths);
        
        // Add the 'other' biarch variant path
        BiarchSibling/*J*/= new Multilib();
        if (GCCInstallation.getBiarchSibling(BiarchSibling)) {
          addPathIfExists(D, $add_Twine(new Twine(GCCInstallation.getInstallPath()), 
                  new Twine(BiarchSibling.gccSuffix())), 
              Paths);
        }
        
        // See comments above on the multilib variant for details of why this is
        // included even from outside the sysroot.
        /*const*/std.string/*&*/ LibPath = GCCInstallation.getParentLibPath().$string();
        /*const*/ Triple /*&*/ GCCTriple = GCCInstallation.getTriple();
        /*const*/ Multilib /*&*/ Multilib = GCCInstallation.getMultilib();
        addPathIfExists(D, new Twine($add_string_string$C($add_string_T($add_string_string$C($add_string$C_T(LibPath, /*KEEP_STR*/"/../"), GCCTriple.str()), /*KEEP_STR*/"/lib"), 
                    Multilib.osSuffix())), 
            Paths);
        
        // See comments above on the multilib variant for details of why this is
        // only included from within the sysroot.
        if (new StringRef(LibPath).startswith(new StringRef(SysRoot))) {
          addPathIfExists(D, new Twine(LibPath), Paths);
        }
      } finally {
        if (BiarchSibling != null) { BiarchSibling.$destroy(); }
      }
    }
    
    // Similar to the logic for GCC above, if we are currently running Clang
    // inside of the requested system root, add its parent library path to those
    // searched.
    // FIXME: It's not clear whether we should use the driver's installed
    // directory ('Dir' below) or the ResourceDir.
    if (new StringRef(D.Dir).startswith(new StringRef(SysRoot))) {
      addPathIfExists(D, new Twine($add_string$C_T(D.Dir, /*KEEP_STR*/"/../lib")), Paths);
    }
    
    addPathIfExists(D, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/lib")), Paths);
    addPathIfExists(D, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/lib")), Paths);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::HasNativeLLVMSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4175,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3822,
   FQN="clang::driver::toolchains::Linux::HasNativeLLVMSupport", NM="_ZNK5clang6driver10toolchains5Linux20HasNativeLLVMSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux20HasNativeLLVMSupportEv")
  //</editor-fold>
  @Override public boolean HasNativeLLVMSupport() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4332,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3860,
   FQN="clang::driver::toolchains::Linux::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains5Linux25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    /*const*/ Driver /*&*/ D = getDriver();
    std.string SysRoot = computeSysRoot();
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
      return;
    }
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
      addSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/local/include")));
    }
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nobuiltininc.getValue()))) {
      SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(D.ResourceDir), 128);
      path.append(P, new Twine(/*KEEP_STR*/$include));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P));
    }
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
      return;
    }
    
    // Check for configure-time C include directories.
    StringRef CIncludeDirs/*J*/= new StringRef(/*KEEP_STR*/$EMPTY);
    if ($noteq_StringRef(/*NO_COPY*/CIncludeDirs, /*STRINGREF_STR*/"")) {
      SmallVector<StringRef> dirs/*J*/= new SmallVector<StringRef>(5, new StringRef());
      CIncludeDirs.split(dirs, /*STRINGREF_STR*/":");
      for (StringRef dir : dirs) {
        StringRef Prefix = path.is_absolute(new Twine(dir)) ? new StringRef(SysRoot) : new StringRef(/*KEEP_STR*/$EMPTY);
        addExternCSystemInclude(DriverArgs, CC1Args, $add_Twine(new Twine(Prefix), new Twine(dir)));
      }
      return;
    }
    
    // Lacking those, try to detect the correct set of system includes for the
    // target triple.
    
    // Add include directories specific to the selected multilib set and multilib.
    if (GCCInstallation.isValid()) {
      /*const*/IncludeDirsFunc/*&*/ Callback = Multilibs.includeDirsCallback();
      if (Callback != null) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          for (/*const*/std.string/*&*/ Path : Callback.$call(GCCInstallation.getMultilib()))  {
            addExternCSystemIncludeIfExists(DriverArgs, CC1Args, $add_Twine(new Twine(GCCInstallation.getInstallPath()), new Twine(Path)));
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Implement generic Debian multiarch support.
    /*const*/ StringRef X86_64MultiarchIncludeDirs[/*3*/] = new /*const*/ StringRef [/*3*/] {
      new StringRef("/usr/include/x86_64-linux-gnu"), 
      
      // FIXME: These are older forms of multiarch. It's not clear that they're
      // in use in any released version of Debian, so we should consider
      // removing them.
      new StringRef("/usr/include/i686-linux-gnu/64"), new StringRef("/usr/include/i486-linux-gnu/64")};
    /*const*/ StringRef X86MultiarchIncludeDirs[/*4*/] = new /*const*/ StringRef [/*4*/] {
      new StringRef("/usr/include/i386-linux-gnu"), 
      
      // FIXME: These are older forms of multiarch. It's not clear that they're
      // in use in any released version of Debian, so we should consider
      // removing them.
      new StringRef("/usr/include/x86_64-linux-gnu/32"), new StringRef("/usr/include/i686-linux-gnu"), 
      new StringRef("/usr/include/i486-linux-gnu")};
    /*const*/ StringRef AArch64MultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/aarch64-linux-gnu")};
    /*const*/ StringRef ARMMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/arm-linux-gnueabi")};
    /*const*/ StringRef ARMHFMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/arm-linux-gnueabihf")};
    /*const*/ StringRef ARMEBMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/armeb-linux-gnueabi")};
    /*const*/ StringRef ARMEBHFMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/armeb-linux-gnueabihf")};
    /*const*/ StringRef MIPSMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/mips-linux-gnu")};
    /*const*/ StringRef MIPSELMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/mipsel-linux-gnu")};
    /*const*/ StringRef MIPS64MultiarchIncludeDirs[/*2*/] = new /*const*/ StringRef [/*2*/] {new StringRef("/usr/include/mips64-linux-gnu"), new StringRef("/usr/include/mips64-linux-gnuabi64")};
    /*const*/ StringRef MIPS64ELMultiarchIncludeDirs[/*2*/] = new /*const*/ StringRef [/*2*/] {
      new StringRef("/usr/include/mips64el-linux-gnu"), 
      new StringRef("/usr/include/mips64el-linux-gnuabi64")};
    /*const*/ StringRef PPCMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/powerpc-linux-gnu")};
    /*const*/ StringRef PPC64MultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/powerpc64-linux-gnu")};
    /*const*/ StringRef PPC64LEMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/powerpc64le-linux-gnu")};
    /*const*/ StringRef SparcMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/sparc-linux-gnu")};
    /*const*/ StringRef Sparc64MultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/sparc64-linux-gnu")};
    /*const*/ StringRef SYSTEMZMultiarchIncludeDirs[/*1*/] = new /*const*/ StringRef [/*1*/] {new StringRef("/usr/include/s390x-linux-gnu")};
    ArrayRef<StringRef> MultiarchIncludeDirs/*J*/= new ArrayRef<StringRef>();
    switch (getTriple().getArch()) {
     case x86_64:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(X86_64MultiarchIncludeDirs));
      break;
     case x86:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(X86MultiarchIncludeDirs));
      break;
     case aarch64:
     case aarch64_be:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(AArch64MultiarchIncludeDirs));
      break;
     case arm:
     case thumb:
      if (getTriple().getEnvironment() == Triple.EnvironmentType.GNUEABIHF) {
        MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(ARMHFMultiarchIncludeDirs));
      } else {
        MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(ARMMultiarchIncludeDirs));
      }
      break;
     case armeb:
     case thumbeb:
      if (getTriple().getEnvironment() == Triple.EnvironmentType.GNUEABIHF) {
        MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(ARMEBHFMultiarchIncludeDirs));
      } else {
        MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(ARMEBMultiarchIncludeDirs));
      }
      break;
     case mips:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(MIPSMultiarchIncludeDirs));
      break;
     case mipsel:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(MIPSELMultiarchIncludeDirs));
      break;
     case mips64:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(MIPS64MultiarchIncludeDirs));
      break;
     case mips64el:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(MIPS64ELMultiarchIncludeDirs));
      break;
     case ppc:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(PPCMultiarchIncludeDirs));
      break;
     case ppc64:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(PPC64MultiarchIncludeDirs));
      break;
     case ppc64le:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(PPC64LEMultiarchIncludeDirs));
      break;
     case sparc:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(SparcMultiarchIncludeDirs));
      break;
     case sparcv9:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(Sparc64MultiarchIncludeDirs));
      break;
     case systemz:
      MultiarchIncludeDirs.$assignMove(new ArrayRef<StringRef>(SYSTEMZMultiarchIncludeDirs));
      break;
     default:
      break;
    }
    for (StringRef Dir : MultiarchIncludeDirs) {
      if (D.getVFS().exists($add_Twine(new Twine(SysRoot), new Twine(Dir)))) {
        addExternCSystemInclude(DriverArgs, CC1Args, $add_Twine(new Twine(SysRoot), new Twine(Dir)));
        break;
      }
    }
    if (getTriple().getOS() == Triple.OSType.RTEMS) {
      return;
    }
    
    // Add an include of '/include' directly. This isn't provided by default by
    // system GCCs, but is often used with cross-compiling GCCs, and harmless to
    // add even when Clang is acting as-if it were a system compiler.
    addExternCSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/include")));
    
    addExternCSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/include")));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4520,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4051,
   FQN="clang::driver::toolchains::Linux::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains5Linux28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    
    // Check if libc++ has been enabled and provide its include paths if so.
    if (GetCXXStdlibType(DriverArgs) == ToolChain.CXXStdlibType.CST_Libcxx) {
      /*const*/std.string LibCXXIncludePathCandidates[/*3*/] = new /*const*/std.string [/*3*/] {
        DetectLibcxxIncludePath(new StringRef($add_string$C_T(getDriver().Dir, /*KEEP_STR*/"/../include/c++"))), 
        // If this is a development, non-installed, clang, libcxx will
        // not be found at ../include/c++ but it likely to be found at
        // one of the following two locations:
        DetectLibcxxIncludePath(new StringRef($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/local/include/c++"))), 
        DetectLibcxxIncludePath(new StringRef($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/include/c++")))};
      for (/*const*/std.string/*&*/ IncludePath : LibCXXIncludePathCandidates) {
        if (IncludePath.empty() || !getVFS().exists(new Twine(IncludePath))) {
          continue;
        }
        // Add the first candidate that exists.
        addSystemInclude(DriverArgs, CC1Args, new Twine(IncludePath));
        break;
      }
      return;
    }
    
    // We need a detected GCC installation on Linux to provide libstdc++'s
    // headers. We handled the libc++ case above.
    if (!GCCInstallation.isValid()) {
      return;
    }
    
    // By default, look for the C++ headers in an include directory adjacent to
    // the lib directory of the GCC installation. Note that this is expect to be
    // equivalent to '/usr/include/c++/X.Y' in almost all cases.
    StringRef LibDir = GCCInstallation.getParentLibPath();
    StringRef InstallDir = GCCInstallation.getInstallPath();
    StringRef TripleStr = new StringRef(GCCInstallation.getTriple().str());
    /*const*/ Multilib /*&*/ Multilib = GCCInstallation.getMultilib();
    /*const*/std.string GCCMultiarchTriple = getMultiarchTriple(getDriver(), GCCInstallation.getTriple(), new StringRef(getDriver().SysRoot));
    /*const*/std.string TargetMultiarchTriple = getMultiarchTriple(getDriver(), getTriple(), new StringRef(getDriver().SysRoot));
    /*const*/ GCCVersion /*&*/ Version = GCCInstallation.getVersion();
    
    // The primary search for libstdc++ supports multiarch variants.
    if (addLibStdCXXIncludePaths(new Twine($add_string_T(LibDir.str(), /*KEEP_STR*/"/../include")), 
        new Twine($add_T_string$C(/*KEEP_STR*/"/c++/", Version.Text)), new StringRef(TripleStr), 
        new StringRef(GCCMultiarchTriple), new StringRef(TargetMultiarchTriple), 
        new Twine(Multilib.includeSuffix()), DriverArgs, CC1Args)) {
      return;
    }
    
    // Otherwise, fall back on a bunch of options which don't use multiarch
    // layouts for simplicity.
    /*const*/std.string LibStdCXXIncludePathCandidates[/*5*/] = new /*const*/std.string [/*5*/] {
      // Gentoo is weird and places its headers inside the GCC install,
      // so if the first attempt to find the headers fails, try these patterns.
      $add_string_string$C($add_string_T(InstallDir.str(), /*KEEP_STR*/"/include/g++-v"), Version.Text), 
      $add_string_string$C($add_string_T($add_string_string$C($add_string_T(InstallDir.str(), /*KEEP_STR*/"/include/g++-v"), Version.MajorStr), /*KEEP_STR*/"."), 
          Version.MinorStr), 
      $add_string_string$C($add_string_T(InstallDir.str(), /*KEEP_STR*/"/include/g++-v"), Version.MajorStr), 
      // Android standalone toolchain has C++ headers in yet another place.
      $add_string_string$C($add_string_T($add_string($add_string_T(LibDir.str(), /*KEEP_STR*/"/../"), TripleStr.str()), /*KEEP_STR*/"/include/c++/"), Version.Text), 
      // Freescale SDK C++ headers are directly in <sysroot>/usr/include/c++,
      // without a subdirectory corresponding to the gcc version.
      $add_string_T(LibDir.str(), /*KEEP_STR*/"/../include/c++")
    };
    
    for (/*const*/std.string/*&*/ IncludePath : LibStdCXXIncludePathCandidates) {
      if (addLibStdCXXIncludePaths(new Twine(IncludePath), /*Suffix*/ new Twine(/*KEEP_STR*/$EMPTY), new StringRef(TripleStr), 
          /*GCCMultiarchTriple*/ new StringRef(/*KEEP_STR*/$EMPTY), 
          /*TargetMultiarchTriple*/ new StringRef(/*KEEP_STR*/$EMPTY), 
          new Twine(Multilib.includeSuffix()), DriverArgs, CC1Args)) {
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::AddCudaIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4595,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4125,
   FQN="clang::driver::toolchains::Linux::AddCudaIncludeArgs", NM="_ZNK5clang6driver10toolchains5Linux18AddCudaIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux18AddCudaIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCudaIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                    ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nocudainc.getValue()))) {
      return;
    }
    if (!CudaInstallation.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(getDriver().Diag(diag.err_drv_no_cuda_installation)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    addSystemInclude(DriverArgs, CC1Args, new Twine(CudaInstallation.getIncludePath()));
    CC1Args.push_back($("-include"));
    CC1Args.push_back($("__clang_cuda_runtime_wrapper.h"));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::AddIAMCUIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4610,
   FQN="clang::driver::toolchains::Linux::AddIAMCUIncludeArgs", NM="_ZNK5clang6driver10toolchains5Linux19AddIAMCUIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux19AddIAMCUIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddIAMCUIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                     ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (GCCInstallation.isValid()) {
      CC1Args.push_back($("-isystem"));
      CC1Args.push_back(DriverArgs.MakeArgString($add_Twine($add_Twine($add_StringRef_char$ptr$C(GCCInstallation.getParentLibPath(), /*KEEP_STR*/"/../"), 
                      new Twine(GCCInstallation.getTriple().str())), new Twine(/*KEEP_STR*/"/include"))));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4620,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4137,
   FQN="clang::driver::toolchains::Linux::isPIEDefault", NM="_ZNK5clang6driver10toolchains5Linux12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return getSanitizerArgs().requiresPIE();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::getSupportedSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4622,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4139,
   FQN="clang::driver::toolchains::Linux::getSupportedSanitizers", NM="_ZNK5clang6driver10toolchains5Linux22getSupportedSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux22getSupportedSanitizersEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSupportedSanitizers() /*const*//* override*/ {
    /*const*/boolean IsX86 = getTriple().getArch() == Triple.ArchType.x86;
    /*const*/boolean IsX86_64 = getTriple().getArch() == Triple.ArchType.x86_64;
    /*const*/boolean IsMIPS64 = getTriple().getArch() == Triple.ArchType.mips64
       || getTriple().getArch() == Triple.ArchType.mips64el;
    /*const*/boolean IsPowerPC64 = getTriple().getArch() == Triple.ArchType.ppc64
       || getTriple().getArch() == Triple.ArchType.ppc64le;
    /*const*/boolean IsAArch64 = getTriple().getArch() == Triple.ArchType.aarch64
       || getTriple().getArch() == Triple.ArchType.aarch64_be;
    long/*uint64_t*/ Res = super.getSupportedSanitizers();
    Res |= SanitizerKind.Address;
    Res |= SanitizerKind.KernelAddress;
    Res |= SanitizerKind.Vptr;
    Res |= SanitizerKind.SafeStack;
    if (IsX86_64 || IsMIPS64 || IsAArch64) {
      Res |= SanitizerKind.DataFlow;
    }
    if (IsX86_64 || IsMIPS64 || IsAArch64) {
      Res |= SanitizerKind.Leak;
    }
    if (IsX86_64 || IsMIPS64 || IsAArch64 || IsPowerPC64) {
      Res |= SanitizerKind.Thread;
    }
    if (IsX86_64 || IsMIPS64 || IsPowerPC64 || IsAArch64) {
      Res |= SanitizerKind.Memory;
    }
    if (IsX86_64) {
      Res |= SanitizerKind.Efficiency;
    }
    if (IsX86 || IsX86_64) {
      Res |= SanitizerKind.Function;
    }
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::addProfileRTLibs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4652,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4167,
   FQN="clang::driver::toolchains::Linux::addProfileRTLibs", NM="_ZNK5clang6driver10toolchains5Linux16addProfileRTLibsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux16addProfileRTLibsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addProfileRTLibs(/*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    if (!needsProfileRT(Args)) {
      return;
    }
    
    // Add linker option -u__llvm_runtime_variable to cause runtime
    // initialization module to be linked in.
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_coverage.getValue()))) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-u", llvm.getInstrProfRuntimeHookVarName())));
    }
    super.addProfileRTLibs(Args, CmdArgs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::computeSysRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4183,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3830,
   FQN="clang::driver::toolchains::Linux::computeSysRoot", NM="_ZNK5clang6driver10toolchains5Linux14computeSysRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux14computeSysRootEv")
  //</editor-fold>
  public std.string computeSysRoot() /*const*/ {
    if (!getDriver().SysRoot.empty()) {
      return new std.string(getDriver().SysRoot);
    }
    if (!GCCInstallation.isValid() || !isMipsArch(getTriple().getArch())) {
      return new std.string();
    }
    
    // Standalone MIPS toolchains use different names for sysroot folder
    // and put it into different places. Here we try to check some known
    // variants.
    /*const*/ StringRef InstallDir = GCCInstallation.getInstallPath();
    /*const*/ StringRef TripleStr = new StringRef(GCCInstallation.getTriple().str());
    /*const*/ Multilib /*&*/ Multilib = GCCInstallation.getMultilib();
    
    std.string Path = ($add_Twine($add_Twine($add_Twine($add_StringRef_char$ptr$C(InstallDir, /*KEEP_STR*/"/../../../../"), new Twine(TripleStr)), new Twine(/*KEEP_STR*/"/libc")), new Twine(Multilib.osSuffix()))).
        str();
    if (getVFS().exists(new Twine(Path))) {
      return Path;
    }
    
    Path.$assignMove(($add_Twine($add_StringRef_char$ptr$C(InstallDir, /*KEEP_STR*/"/../../../../sysroot"), new Twine(Multilib.osSuffix()))).str());
    if (getVFS().exists(new Twine(Path))) {
      return Path;
    }
    
    return new std.string();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::getDynamicLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4213,
   FQN="clang::driver::toolchains::Linux::getDynamicLinker", NM="_ZNK5clang6driver10toolchains5Linux16getDynamicLinkerERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux16getDynamicLinkerERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public std.string getDynamicLinker(/*const*/ ArgList /*&*/ Args) /*const*/ {
    /*const*/ Triple.ArchType Arch = getArch();
    /*const*/ Triple /*&*/ _Triple = getTriple();
    
    /*const*/  Distro Distro = DetectDistro(getDriver(), Arch);
    if (_Triple.isAndroid()) {
      return new std.string(_Triple.isArch64Bit() ? $("/system/bin/linker64") : $("/system/bin/linker"));
    } else if (_Triple.isMusl()) {
      std.string ArchName/*J*/= new std.string();
      switch (Arch) {
       case thumb:
        ArchName.$assign(/*KEEP_STR*/"arm");
        break;
       case thumbeb:
        ArchName.$assign(/*KEEP_STR*/"armeb");
        break;
       default:
        ArchName.$assignMove(_Triple.getArchName().str());
      }
      if (_Triple.getEnvironment() == Triple.EnvironmentType.MuslEABIHF) {
        ArchName.$addassign(/*KEEP_STR*/"hf");
      }
      
      return $add_string_T($add_T_string$C(/*KEEP_STR*/"/lib/ld-musl-", ArchName), /*KEEP_STR*/".so.1");
    }
    
    std.string LibDir/*J*/= new std.string();
    std.string Loader/*J*/= new std.string();
    switch (Arch) {
     default:
      throw new llvm_unreachable("unsupported architecture");
     case aarch64:
      LibDir.$assign(/*KEEP_STR*/"lib");
      Loader.$assign(/*KEEP_STR*/"ld-linux-aarch64.so.1");
      break;
     case aarch64_be:
      LibDir.$assign(/*KEEP_STR*/"lib");
      Loader.$assign(/*KEEP_STR*/"ld-linux-aarch64_be.so.1");
      break;
     case arm:
     case thumb:
     case armeb:
     case thumbeb:
      {
        /*const*/boolean HF = _Triple.getEnvironment() == Triple.EnvironmentType.GNUEABIHF
           || ArmStatics.getARMFloatABI(/*Deref*/this, Args) == ArmStatics.FloatABI.Hard;
        
        LibDir.$assign(/*KEEP_STR*/"lib");
        Loader.$assign(HF ? $("ld-linux-armhf.so.3") : $("ld-linux.so.3"));
        break;
      }
     case mips:
     case mipsel:
     case mips64:
     case mips64el:
      {
        boolean LE = (_Triple.getArch() == Triple.ArchType.mipsel)
           || (_Triple.getArch() == Triple.ArchType.mips64el);
        boolean IsNaN2008 = MipsStatics.isNaN2008(Args, _Triple);
        
        LibDir.$assignMove($add_T_string(/*KEEP_STR*/"lib", MipsStatics.getMipsABILibSuffix(Args, _Triple)));
        if (MipsStatics.isUCLibc(Args)) {
          Loader.$assign(IsNaN2008 ? $("ld-uClibc-mipsn8.so.0") : $("ld-uClibc.so.0"));
        } else if (!_Triple.hasEnvironment()
           && _Triple.getVendor() == Triple.VendorType.MipsTechnologies) {
          Loader.$assign(LE ? $("ld-musl-mipsel.so.1") : $("ld-musl-mips.so.1"));
        } else {
          Loader.$assign(IsNaN2008 ? $("ld-linux-mipsn8.so.1") : $("ld.so.1"));
        }
        
        break;
      }
     case ppc:
      LibDir.$assign(/*KEEP_STR*/"lib");
      Loader.$assign(/*KEEP_STR*/"ld.so.1");
      break;
     case ppc64:
      LibDir.$assign(/*KEEP_STR*/"lib64");
      Loader.$assign((PpcStatics.hasPPCAbiArg(Args, $("elfv2"))) ? $("ld64.so.2") : $("ld64.so.1"));
      break;
     case ppc64le:
      LibDir.$assign(/*KEEP_STR*/"lib64");
      Loader.$assign((PpcStatics.hasPPCAbiArg(Args, $("elfv1"))) ? $("ld64.so.1") : $("ld64.so.2"));
      break;
     case sparc:
     case sparcel:
      LibDir.$assign(/*KEEP_STR*/"lib");
      Loader.$assign(/*KEEP_STR*/"ld-linux.so.2");
      break;
     case sparcv9:
      LibDir.$assign(/*KEEP_STR*/"lib64");
      Loader.$assign(/*KEEP_STR*/"ld-linux.so.2");
      break;
     case systemz:
      LibDir.$assign(/*KEEP_STR*/"lib");
      Loader.$assign(/*KEEP_STR*/"ld64.so.1");
      break;
     case x86:
      LibDir.$assign(/*KEEP_STR*/"lib");
      Loader.$assign(/*KEEP_STR*/"ld-linux.so.2");
      break;
     case x86_64:
      {
        boolean X32 = _Triple.getEnvironment() == Triple.EnvironmentType.GNUX32;
        
        LibDir.$assign(X32 ? $("libx32") : $("lib64"));
        Loader.$assign(X32 ? $("ld-linux-x32.so.2") : $("ld-linux-x86-64.so.2"));
        break;
      }
    }
    if (Distro == Distro.Exherbo && (_Triple.getVendor() == Triple.VendorType.UnknownVendor
       || _Triple.getVendor() == Triple.VendorType.PC)) {
      return $add_string_string$C($add_string_T($add_T_string$C(/*KEEP_STR*/"/usr/", _Triple.str()), /*KEEP_STR*/"/lib/"), Loader);
    }
    return $add_string_string$C($add_string_T($add_T_string$C(/*KEEP_STR*/"/", LibDir), /*KEEP_STR*/"/"), Loader);
  }

  
  public std.vectorString ExtraOpts;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::buildAssembler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3826,
   FQN="clang::driver::toolchains::Linux::buildAssembler", NM="_ZNK5clang6driver10toolchains5Linux14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new GnutoolsStatics.Assembler(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4177,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3824,
   FQN="clang::driver::toolchains::Linux::buildLinker", NM="_ZNK5clang6driver10toolchains5Linux11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains5Linux11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new GnutoolsStatics.Linker(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Linux::~Linux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 822,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 783,
   FQN="clang::driver::toolchains::Linux::~Linux", NM="_ZN5clang6driver10toolchains5LinuxD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains5LinuxD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ExtraOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "ExtraOpts=" + ExtraOpts // NOI18N
              + super.toString(); // NOI18N
  }
}
