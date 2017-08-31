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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.support.sys.*;
import static org.clang.frontend.impl.InitHeaderSearchStatics.*;
import org.clang.lex.frontend.*;


/// InitHeaderSearch - This class makes it easier to set the search paths of
///  a HeaderSearch object. InitHeaderSearch stores several search path lists
///  internally, which can be sent to a HeaderSearch object in one swoop.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added system-prop based field*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 40,
 FQN="(anonymous namespace)::InitHeaderSearch", NM="_ZN12_GLOBAL__N_116InitHeaderSearchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearchE")
//</editor-fold>
public class InitHeaderSearch implements Destructors.ClassWithDestructor {
  // dirs specified via 'configure --with-c-include-dirs'.
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static final StringRef C_INCLUDE_DIRS = new StringRef(System.getProperty("C_INCLUDE_DIRS", ""));
  
  private std.vector<std.pair<IncludeDirGroup, DirectoryLookup>> IncludePath;
  /*typedef std::vector<std::pair<IncludeDirGroup, DirectoryLookup> >::const_iterator path_iterator*/
//  public final class path_iterator extends __normal_iterator</*const*/ pair<IncludeDirGroup, DirectoryLookup> /*P*/ , vector<pair<IncludeDirGroup, DirectoryLookup>> >{ };
  private std.vector<std.pairTypeBool<std.string>> SystemHeaderPrefixes;
  private HeaderSearch /*&*/ Headers;
  private boolean Verbose;
  private std.string IncludeSysroot;
  private boolean HasSysroot;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::InitHeaderSearch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 52,
   FQN="(anonymous namespace)::InitHeaderSearch::InitHeaderSearch", NM="_ZN12_GLOBAL__N_116InitHeaderSearchC1ERN5clang12HeaderSearchEbN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearchC1ERN5clang12HeaderSearchEbN4llvm9StringRefE")
  //</editor-fold>
  public InitHeaderSearch(HeaderSearch /*&*/ HS, boolean verbose, StringRef sysroot) {
    // : IncludePath(), SystemHeaderPrefixes(), Headers(HS), Verbose(verbose), IncludeSysroot(sysroot.operator basic_string()), HasSysroot(!(sysroot.empty() || sysroot == "/")) 
    //START JInit
    this.IncludePath = new std.vector<std.pair<IncludeDirGroup, DirectoryLookup>>(new std.pairTypeType<IncludeDirGroup, DirectoryLookup>(IncludeDirGroup.Quoted, DirectoryLookup.DEFAULT));
    this.SystemHeaderPrefixes = new std.vector<std.pairTypeBool<std.string>>(new std.pairTypeBool<std.string>(std.string.EMPTY, false));
    this./*&*/Headers=/*&*/HS;
    this.Verbose = verbose;
    this.IncludeSysroot = sysroot.$string();
    this.HasSysroot = !(sysroot.empty() || $eq_StringRef(/*NO_COPY*/sysroot, /*STRINGREF_STR*/"/"));
    //END JInit
  }

  
  /// AddPath - Add the specified path to the specified group list, prefixing
  /// the sysroot if used.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 116,
   FQN="(anonymous namespace)::InitHeaderSearch::AddPath", NM="_ZN12_GLOBAL__N_116InitHeaderSearch7AddPathERKN4llvm5TwineEN5clang8frontend15IncludeDirGroupEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch7AddPathERKN4llvm5TwineEN5clang8frontend15IncludeDirGroupEb")
  //</editor-fold>
  public void AddPath(/*const*/ Twine /*&*/ Path, IncludeDirGroup Group, 
         boolean isFramework) {
    // Add the path with sysroot prepended, if desired and this is a system header
    // group.
    if (HasSysroot) {
      SmallString/*256*/ MappedPathStorage/*J*/= new SmallString/*256*/(256);
      StringRef MappedPathStr = Path.toStringRef(MappedPathStorage);
      if (CanPrefixSysroot(/*NO_COPY*/MappedPathStr)) {
        AddUnmappedPath($add_Twine$C(new Twine(IncludeSysroot), Path), Group, isFramework);
        return;
      }
    }
    
    AddUnmappedPath(Path, Group, isFramework);
  }

  
  /// AddUnmappedPath - Add the specified path to the specified group list,
  /// without performing any sysroot remapping.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddUnmappedPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 132,
   FQN="(anonymous namespace)::InitHeaderSearch::AddUnmappedPath", NM="_ZN12_GLOBAL__N_116InitHeaderSearch15AddUnmappedPathERKN4llvm5TwineEN5clang8frontend15IncludeDirGroupEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch15AddUnmappedPathERKN4llvm5TwineEN5clang8frontend15IncludeDirGroupEb")
  //</editor-fold>
  public void AddUnmappedPath(/*const*/ Twine /*&*/ Path, IncludeDirGroup Group, 
                 boolean isFramework) {
    assert (!Path.isTriviallyEmpty()) : "can't handle empty path here";
    
    FileManager /*&*/ FM = Headers.getFileMgr();
    SmallString/*256*/ MappedPathStorage/*J*/= new SmallString/*256*/(256);
    StringRef MappedPathStr = Path.toStringRef(MappedPathStorage);
    
    // Compute the DirectoryLookup type.
    SrcMgr.CharacteristicKind Type;
    if (Group == IncludeDirGroup.Quoted || Group == IncludeDirGroup.Angled || Group == IncludeDirGroup.IndexHeaderMap) {
      Type = SrcMgr.CharacteristicKind.C_User;
    } else if (Group == IncludeDirGroup.ExternCSystem) {
      Type = SrcMgr.CharacteristicKind.C_ExternCSystem;
    } else {
      Type = SrcMgr.CharacteristicKind.C_System;
    }
    {
      
      // If the directory exists, add it.
      /*const*/ DirectoryEntry /*P*/ DE = FM.getDirectory(/*NO_COPY*/MappedPathStr);
      if ((DE != null)) {
        IncludePath.push_back_T$RR(std.make_pair_E_T(Group, new DirectoryLookup(DE, Type, isFramework)));
        return;
      }
    }
    
    // Check to see if this is an apple-style headermap (which are not allowed to
    // be frameworks).
    if (!isFramework) {
      {
        /*const*/ FileEntry /*P*/ FE = FM.getFile(/*NO_COPY*/MappedPathStr);
        if ((FE != null)) {
          {
            /*const*/ HeaderMap /*P*/ HM = Headers.CreateHeaderMap(FE);
            if ((HM != null)) {
              // It is a headermap, add it to the search path.
              IncludePath.push_back_T$RR(std.make_pair_E_T(Group, 
                      new DirectoryLookup(HM, Type, Group == IncludeDirGroup.IndexHeaderMap)));
              return;
            }
          }
        }
      }
    }
    if (Verbose) {
      llvm.errs().$out(/*KEEP_STR*/"ignoring nonexistent directory \"").$out(
          /*NO_COPY*/MappedPathStr
      ).$out(/*KEEP_STR*/$QUOTE_LF);
    }
  }

  
  /// AddSystemHeaderPrefix - Add the specified prefix to the system header
  /// prefix list.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddSystemHeaderPrefix">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 68,
   FQN="(anonymous namespace)::InitHeaderSearch::AddSystemHeaderPrefix", NM="_ZN12_GLOBAL__N_116InitHeaderSearch21AddSystemHeaderPrefixEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch21AddSystemHeaderPrefixEN4llvm9StringRefEb")
  //</editor-fold>
  public void AddSystemHeaderPrefix(StringRef Prefix, boolean IsSystemHeader) {
    SystemHeaderPrefixes.emplace_back(std.make_pair_T_bool(Prefix.$string(), IsSystemHeader));
  }

  
  /// AddGnuCPlusPlusIncludePaths - Add the necessary paths to support a gnu
  ///  libstdc++.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddGnuCPlusPlusIncludePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 176,
   FQN="(anonymous namespace)::InitHeaderSearch::AddGnuCPlusPlusIncludePaths", NM="_ZN12_GLOBAL__N_116InitHeaderSearch27AddGnuCPlusPlusIncludePathsEN4llvm9StringRefES2_S2_S2_RKNS1_6TripleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch27AddGnuCPlusPlusIncludePathsEN4llvm9StringRefES2_S2_S2_RKNS1_6TripleE")
  //</editor-fold>
  public void AddGnuCPlusPlusIncludePaths(StringRef Base, 
                             StringRef ArchDir, 
                             StringRef Dir32, 
                             StringRef Dir64, 
                             /*const*/ Triple /*&*/ triple) {
    // Add the base dir
    AddPath(new Twine(Base), IncludeDirGroup.CXXSystem, false);
    
    // Add the multilib dirs
    Triple.ArchType arch = triple.getArch();
    boolean is64bit = arch == Triple.ArchType.ppc64 || arch == Triple.ArchType.x86_64;
    if (is64bit) {
      AddPath($add_Twine$C($add_Twine$C($add_Twine$C($add_StringRef$C_char$ptr$C(Base, /*KEEP_STR*/$SLASH), new Twine(ArchDir)), new Twine(/*KEEP_STR*/$SLASH)), new Twine(Dir64)), IncludeDirGroup.CXXSystem, false);
    } else {
      AddPath($add_Twine$C($add_Twine$C($add_Twine$C($add_StringRef$C_char$ptr$C(Base, /*KEEP_STR*/$SLASH), new Twine(ArchDir)), new Twine(/*KEEP_STR*/$SLASH)), new Twine(Dir32)), IncludeDirGroup.CXXSystem, false);
    }
    
    // Add the backward dir
    AddPath($add_StringRef$C_char$ptr$C(Base, /*KEEP_STR*/"/backward"), IncludeDirGroup.CXXSystem, false);
  }

  
  /// AddMinGWCPlusPlusIncludePaths - Add the necessary paths to support a MinGW
  ///  libstdc++.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddMinGWCPlusPlusIncludePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 196,
   FQN="(anonymous namespace)::InitHeaderSearch::AddMinGWCPlusPlusIncludePaths", NM="_ZN12_GLOBAL__N_116InitHeaderSearch29AddMinGWCPlusPlusIncludePathsEN4llvm9StringRefES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch29AddMinGWCPlusPlusIncludePathsEN4llvm9StringRefES2_S2_")
  //</editor-fold>
  public void AddMinGWCPlusPlusIncludePaths(StringRef Base, 
                               StringRef Arch, 
                               StringRef Version) {
    AddPath($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_StringRef$C_char$ptr$C(Base, /*KEEP_STR*/$SLASH), new Twine(Arch)), new Twine(/*KEEP_STR*/$SLASH)), new Twine(Version)), new Twine(/*KEEP_STR*/"/include/c++")), 
        IncludeDirGroup.CXXSystem, false);
    AddPath($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_StringRef$C_char$ptr$C(Base, /*KEEP_STR*/$SLASH), new Twine(Arch)), new Twine(/*KEEP_STR*/$SLASH)), new Twine(Version)), new Twine(/*KEEP_STR*/"/include/c++/")), new Twine(Arch)), 
        IncludeDirGroup.CXXSystem, false);
    AddPath($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_StringRef$C_char$ptr$C(Base, /*KEEP_STR*/$SLASH), new Twine(Arch)), new Twine(/*KEEP_STR*/$SLASH)), new Twine(Version)), new Twine(/*KEEP_STR*/"/include/c++/backward")), 
        IncludeDirGroup.CXXSystem, false);
  }

  
  // AddDefaultCIncludePaths - Add paths that should always be searched.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddDefaultCIncludePaths">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 207,
   FQN="(anonymous namespace)::InitHeaderSearch::AddDefaultCIncludePaths", NM="_ZN12_GLOBAL__N_116InitHeaderSearch23AddDefaultCIncludePathsERKN4llvm6TripleERKN5clang19HeaderSearchOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch23AddDefaultCIncludePathsERKN4llvm6TripleERKN5clang19HeaderSearchOptionsE")
  //</editor-fold>
  public void AddDefaultCIncludePaths(/*const*/ Triple /*&*/ triple, 
                         /*const*/ HeaderSearchOptions /*&*/ HSOpts) {
    Triple.OSType os = triple.getOS();
    if (HSOpts.UseStandardSystemIncludes) {
      switch (os) {
       case CloudABI:
       case FreeBSD:
       case NetBSD:
       case OpenBSD:
       case Bitrig:
       case NaCl:
       case PS4:
       case ELFIAMCU:
        break;
       case Win32:
        if (triple.getEnvironment() != Triple.EnvironmentType.Cygnus) {
          break;
        }
       default:
        // FIXME: temporary hack: hard-coded paths.
        AddPath(new Twine(/*KEEP_STR*/"/usr/local/include"), IncludeDirGroup.System, false);
        break;
      }
    }
    
    // Builtin includes use #include_next directives and should be positioned
    // just prior C include dirs.
    if (HSOpts.UseBuiltinIncludes) {
      // Ignore the sys root, we *always* look for clang headers relative to
      // supplied path.
      SmallString/*128*/ P = new SmallString/*128*/(new StringRef(HSOpts.ResourceDir), 128);
      path.append(P, new Twine(/*KEEP_STR*/$include));
      AddUnmappedPath(new Twine(P), IncludeDirGroup.ExternCSystem, false);
    }
    
    // All remaining additions are for system include directories, early exit if
    // we aren't using them.
    if (!HSOpts.UseStandardSystemIncludes) {
      return;
    }
    
    // Add dirs specified via 'configure --with-c-include-dirs'.
    StringRef CIncludeDirs/*J*/= new StringRef(/*KEEP_STR*/$EMPTY/*JAVA: C_INCLUDE_DIRS*/);/*do not use StringRef.EMPTY here!*/
    if ($noteq_StringRef(/*NO_COPY*/CIncludeDirs, /*STRINGREF_STR*/"")) {
      SmallVector<StringRef> dirs/*J*/= new SmallVector<StringRef>(5, new StringRef());
      CIncludeDirs.split(dirs, /*STRINGREF_STR*/":");
      for (StringRef dir : dirs)  {
        AddPath(new Twine(dir), IncludeDirGroup.ExternCSystem, false);
      }
      return;
    }
    switch (os) {
     case Linux:
      throw new llvm_unreachable("Include management is handled in the driver.");
     case CloudABI:
      {
        // <sysroot>/<triple>/include
        SmallString/*128*/ P = new SmallString/*128*/(new StringRef(HSOpts.ResourceDir), 128);
        path.append(P, new Twine(/*KEEP_STR*/"../../.."), new Twine(triple.str()), new Twine(/*KEEP_STR*/$include));
        AddPath(new Twine(P), IncludeDirGroup.System, false);
        break;
      }
     case Haiku:
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/non-packaged/develop/headers"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/app"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/arch"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/device"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/drivers"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/game"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/interface"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/kernel"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/locale"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/mail"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/media"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/midi"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/midi2"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/net"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/opengl"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/storage"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/support"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/translation"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/add-ons/graphics"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/add-ons/input_server"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/add-ons/mail_daemon"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/add-ons/registrar"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/add-ons/screen_saver"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/add-ons/tracker"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/be_apps/Deskbar"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/be_apps/NetPositive"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/os/be_apps/Tracker"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/3rdparty"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/bsd"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/glibc"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers/posix"), IncludeDirGroup.System, false);
      AddPath(new Twine(/*KEEP_STR*/"/boot/system/develop/headers"), IncludeDirGroup.System, false);
      break;
     case RTEMS:
      break;
     case Win32:
      switch (triple.getEnvironment()) {
       default:
        throw new llvm_unreachable("Include management is handled in the driver.");
       case Cygnus:
        AddPath(new Twine(/*KEEP_STR*/"/usr/include/w32api"), IncludeDirGroup.System, false);
        break;
       case GNU:
        break;
      }
      break;
     default:
      break;
    }
    switch (os) {
     case CloudABI:
     case RTEMS:
     case NaCl:
     case ELFIAMCU:
      break;
     case PS4:
      {
        // <isysroot> gets prepended later in AddPath().
        std.string BaseSDKPath = new std.string(/*KEEP_STR*/$EMPTY);
        if (!HasSysroot) {
          /*const*/char$ptr/*char P*/ envValue = $tryClone(getenv($("SCE_ORBIS_SDK_DIR")));
          if ((envValue != null)) {
            BaseSDKPath.$assign_T$C$P(envValue);
          } else {
            // HSOpts.ResourceDir variable contains the location of Clang's
            // resource files.
            // Assuming that Clang is configured for PS4 without
            // --with-clang-resource-dir option, the location of Clang's resource
            // files is <SDK_DIR>/host_tools/lib/clang
            SmallString/*128*/ P = new SmallString/*128*/(new StringRef(HSOpts.ResourceDir), 128);
            path.append(P, new Twine(/*KEEP_STR*/"../../.."));
            BaseSDKPath.$assignMove(P.str().$string());
          }
        }
        AddPath(new Twine($add_string$C_T$C$P(BaseSDKPath, /*KEEP_STR*/"/target/include")), IncludeDirGroup.System, false);
        if (triple.isPS4CPU()) {
          AddPath(new Twine($add_string$C_T$C$P(BaseSDKPath, /*KEEP_STR*/"/target/include_common")), IncludeDirGroup.System, false);
        }
      }
     default:
      AddPath(new Twine(/*KEEP_STR*/"/usr/include"), IncludeDirGroup.ExternCSystem, false);
      break;
    }
  }

  
  // AddDefaultCPlusPlusIncludePaths -  Add paths that should be searched when
  //  compiling c++.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddDefaultCPlusPlusIncludePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 354,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", old_line = 353,
   FQN="(anonymous namespace)::InitHeaderSearch::AddDefaultCPlusPlusIncludePaths", NM="_ZN12_GLOBAL__N_116InitHeaderSearch31AddDefaultCPlusPlusIncludePathsERKN4llvm6TripleERKN5clang19HeaderSearchOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch31AddDefaultCPlusPlusIncludePathsERKN4llvm6TripleERKN5clang19HeaderSearchOptionsE")
  //</editor-fold>
  public void AddDefaultCPlusPlusIncludePaths(/*const*/ Triple /*&*/ triple, /*const*/ HeaderSearchOptions /*&*/ HSOpts) {
    Triple.OSType os = triple.getOS();
    // FIXME: temporary hack: hard-coded paths.
    if (triple.isOSDarwin()) {
      switch (triple.getArch()) {
       default:
        break;
       case ppc:
       case ppc64:
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/c++/4.2.1"), 
            new StringRef(/*KEEP_STR*/"powerpc-apple-darwin10"), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/"ppc64"), 
            triple);
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/c++/4.0.0"), 
            new StringRef(/*KEEP_STR*/"powerpc-apple-darwin10"), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/"ppc64"), 
            triple);
        break;
       case x86:
       case x86_64:
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/c++/4.2.1"), 
            new StringRef(/*KEEP_STR*/"i686-apple-darwin10"), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/"x86_64"), triple);
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/c++/4.0.0"), 
            new StringRef(/*KEEP_STR*/"i686-apple-darwin8"), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), triple);
        break;
       case arm:
       case thumb:
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/c++/4.2.1"), 
            new StringRef(/*KEEP_STR*/"arm-apple-darwin10"), new StringRef(/*KEEP_STR*/"v7"), new StringRef(/*KEEP_STR*/$EMPTY), triple);
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/c++/4.2.1"), 
            new StringRef(/*KEEP_STR*/"arm-apple-darwin10"), new StringRef(/*KEEP_STR*/"v6"), new StringRef(/*KEEP_STR*/$EMPTY), triple);
        break;
       case aarch64:
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/c++/4.2.1"), 
            new StringRef(/*KEEP_STR*/"arm64-apple-darwin10"), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), triple);
        break;
      }
      return;
    }
    switch (os) {
     case Linux:
      throw new llvm_unreachable("Include management is handled in the driver.");
      /*break;*/
     case Win32:
      switch (triple.getEnvironment()) {
       default:
        throw new llvm_unreachable("Include management is handled in the driver.");
       case Cygnus:
        // Cygwin-1.7
        AddMinGWCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/lib/gcc"), new StringRef(/*KEEP_STR*/"i686-pc-cygwin"), new StringRef(/*KEEP_STR*/"4.7.3"));
        AddMinGWCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/lib/gcc"), new StringRef(/*KEEP_STR*/"i686-pc-cygwin"), new StringRef(/*KEEP_STR*/"4.5.3"));
        AddMinGWCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/lib/gcc"), new StringRef(/*KEEP_STR*/"i686-pc-cygwin"), new StringRef(/*KEEP_STR*/"4.3.4"));
        // g++-4 / Cygwin-1.5
        AddMinGWCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/lib/gcc"), new StringRef(/*KEEP_STR*/"i686-pc-cygwin"), new StringRef(/*KEEP_STR*/"4.3.2"));
        break;
      }
      break;
     case DragonFly:
      AddPath(new Twine(/*KEEP_STR*/"/usr/include/c++/5.0"), IncludeDirGroup.CXXSystem, false);
      break;
     case OpenBSD:
      {
        std.string t = new std.string(triple.getTriple());
        if ($eq_string$C_T$C$P(t.substr(0, 6), /*KEEP_STR*/"x86_64")) {
          t.replace(0, 6, $("amd64"));
        }
        AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/include/g++"), 
            new StringRef(t), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), triple);
        break;
      }
     case Minix:
      AddGnuCPlusPlusIncludePaths(new StringRef(/*KEEP_STR*/"/usr/gnu/include/c++/4.4.3"), 
          new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(/*KEEP_STR*/$EMPTY), triple);
      break;
     default:
      break;
    }
  }

  
  /// AddDefaultSystemIncludePaths - Adds the default system include paths so
  ///  that e.g. stdio.h is found.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::AddDefaultIncludePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 434,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", old_line = 433,
   FQN="(anonymous namespace)::InitHeaderSearch::AddDefaultIncludePaths", NM="_ZN12_GLOBAL__N_116InitHeaderSearch22AddDefaultIncludePathsERKN5clang11LangOptionsERKN4llvm6TripleERKNS1_19HeaderSearchOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch22AddDefaultIncludePathsERKN5clang11LangOptionsERKN4llvm6TripleERKNS1_19HeaderSearchOptionsE")
  //</editor-fold>
  public void AddDefaultIncludePaths(/*const*/ LangOptions /*&*/ Lang, 
                        /*const*/ Triple /*&*/ triple, 
                        /*const*/ HeaderSearchOptions /*&*/ HSOpts) {
    // NB: This code path is going away. All of the logic is moving into the
    // driver which has the information necessary to do target-specific
    // selections of default include paths. Each target which moves there will be
    // exempted from this logic here until we can delete the entire pile of code.
    switch (triple.getOS()) {
     default:
      break; // Everything else continues to use this routine's logic.
     case Linux:
      return;
     case Win32:
      if (triple.getEnvironment() != Triple.EnvironmentType.Cygnus
         || triple.isOSBinFormatMachO()) {
        return;
      }
      break;
    }
    if (Lang.CPlusPlus && HSOpts.UseStandardCXXIncludes
       && HSOpts.UseStandardSystemIncludes) {
      if (HSOpts.UseLibcxx) {
        if (triple.isOSDarwin()) {
          // On Darwin, libc++ may be installed alongside the compiler in
          // include/c++/v1.
          if (!HSOpts.ResourceDir.empty()) {
            // Remove version from foo/lib/clang/version
            StringRef NoVer = path.parent_path(new StringRef(HSOpts.ResourceDir));
            // Remove clang from foo/lib/clang
            StringRef Lib = path.parent_path(/*NO_COPY*/NoVer);
            // Remove lib from foo/lib
            SmallString/*128*/ P = new SmallString/*128*/(path.parent_path(/*NO_COPY*/Lib), 128);
            
            // Get foo/include/c++/v1
            path.append(P, new Twine(/*KEEP_STR*/$include), new Twine(/*KEEP_STR*/"c++"), new Twine(/*KEEP_STR*/"v1"));
            AddUnmappedPath(new Twine(P), IncludeDirGroup.CXXSystem, false);
          }
        }
        AddPath(new Twine(/*KEEP_STR*/"/usr/include/c++/v1"), IncludeDirGroup.CXXSystem, false);
      } else {
        AddDefaultCPlusPlusIncludePaths(triple, HSOpts);
      }
    }
    
    AddDefaultCIncludePaths(triple, HSOpts);
    
    // Add the default framework include paths on Darwin.
    if (HSOpts.UseStandardSystemIncludes) {
      if (triple.isOSDarwin()) {
        AddPath(new Twine(/*KEEP_STR*/"/System/Library/Frameworks"), IncludeDirGroup.System, true);
        AddPath(new Twine(/*KEEP_STR*/"/Library/Frameworks"), IncludeDirGroup.System, true);
      }
    }
  }

  
  /// Realize - Merges all search path lists into one list and send it to
  /// HeaderSearch.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::Realize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 578,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", old_line = 577,
   FQN="(anonymous namespace)::InitHeaderSearch::Realize", NM="_ZN12_GLOBAL__N_116InitHeaderSearch7RealizeERKN5clang11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearch7RealizeERKN5clang11LangOptionsE")
  //</editor-fold>
  public void Realize(/*const*/ LangOptions /*&*/ Lang) {
    std.vector<DirectoryLookup> SearchList = null;
    try {
      // Concatenate ANGLE+SYSTEM+AFTER chains together into SearchList.
      SearchList/*J*/= new std.vector<DirectoryLookup>(DirectoryLookup.DEFAULT);
      SearchList.reserve(IncludePath.size());
      
      // Quoted arguments go first.
      for (pair<IncludeDirGroup, DirectoryLookup> /*&*/ Include : IncludePath)  {
        if (Include.first == IncludeDirGroup.Quoted) {
          SearchList.push_back_T$C$R(Include.second);
        }
      }
      
      // Deduplicate and remember index.
      RemoveDuplicates(SearchList, 0, Verbose);
      /*uint*/int NumQuoted = SearchList.size();
      
      for (pair<IncludeDirGroup, DirectoryLookup> /*&*/ Include : IncludePath)  {
        if (Include.first == IncludeDirGroup.Angled || Include.first == IncludeDirGroup.IndexHeaderMap) {
          SearchList.push_back_T$C$R(Include.second);
        }
      }
      
      RemoveDuplicates(SearchList, NumQuoted, Verbose);
      /*uint*/int NumAngled = SearchList.size();
      
      for (pair<IncludeDirGroup, DirectoryLookup> /*&*/ Include : IncludePath)  {
        if (Include.first == IncludeDirGroup.System || Include.first == IncludeDirGroup.ExternCSystem
           || (!Lang.ObjC1 && !Lang.CPlusPlus && Include.first == IncludeDirGroup.CSystem)
           || (/*FIXME !Lang.ObjC1 && */ Lang.CPlusPlus
           && Include.first == IncludeDirGroup.CXXSystem)
           || (Lang.ObjC1 && !Lang.CPlusPlus && Include.first == IncludeDirGroup.ObjCSystem)
           || (Lang.ObjC1 && Lang.CPlusPlus && Include.first == IncludeDirGroup.ObjCXXSystem)) {
          SearchList.push_back_T$C$R(Include.second);
        }
      }
      
      for (pair<IncludeDirGroup, DirectoryLookup> /*&*/ Include : IncludePath)  {
        if (Include.first == IncludeDirGroup.After) {
          SearchList.push_back_T$C$R(Include.second);
        }
      }
      
      // Remove duplicates across both the Angled and System directories.  GCC does
      // this and failing to remove duplicates across these two groups breaks
      // #include_next.
      /*uint*/int NonSystemRemoved = RemoveDuplicates(SearchList, NumQuoted, Verbose);
      NumAngled -= NonSystemRemoved;
      
      boolean DontSearchCurDir = false; // TODO: set to true if -I- is set?
      Headers.SetSearchPaths(SearchList, NumQuoted, NumAngled, DontSearchCurDir);
      
      Headers.SetSystemHeaderPrefixes(new ArrayRef<std.pairTypeBool<std.string> >(SystemHeaderPrefixes));
      
      // If verbose, print the list of directories that will be searched.
      if (Verbose) {
        llvm.errs().$out(/*KEEP_STR*/"#include \"...\" search starts here:\n");
        for (/*uint*/int i = 0, e = SearchList.size(); i != e; ++i) {
          if (i == NumQuoted) {
            llvm.errs().$out(/*KEEP_STR*/"#include <...> search starts here:\n");
          }
          /*const*/char$ptr/*char P*/ Name = $tryClone(SearchList.$at(i).getName());
          // JAVA: use String
          /*const*/String/*char P*/ Suffix;
          if (SearchList.$at(i).isNormalDir()) {
            Suffix = "";
          } else if (SearchList.$at(i).isFramework()) {
            Suffix = " (framework directory)";
          } else {
            assert (SearchList.$at(i).isHeaderMap()) : "Unknown DirectoryLookup";
            Suffix = " (headermap)";
          }
          llvm.errs().$out(/*KEEP_STR*/$SPACE).$out(Name).$out(Suffix).$out(/*KEEP_STR*/$LF);
        }
        llvm.errs().$out(/*KEEP_STR*/"End of search list.\n");
      }
    } finally {
      if (SearchList != null) { SearchList.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::InitHeaderSearch::~InitHeaderSearch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 40,
   FQN="(anonymous namespace)::InitHeaderSearch::~InitHeaderSearch", NM="_ZN12_GLOBAL__N_116InitHeaderSearchD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN12_GLOBAL__N_116InitHeaderSearchD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    IncludeSysroot.$destroy();
    SystemHeaderPrefixes.$destroy();
    IncludePath.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "IncludePath=" + IncludePath // NOI18N
              + ", SystemHeaderPrefixes=" + SystemHeaderPrefixes // NOI18N
              + ", Headers=" + Headers // NOI18N
              + ", Verbose=" + Verbose // NOI18N
              + ", IncludeSysroot=" + IncludeSysroot // NOI18N
              + ", HasSysroot=" + HasSysroot; // NOI18N
  }
}
