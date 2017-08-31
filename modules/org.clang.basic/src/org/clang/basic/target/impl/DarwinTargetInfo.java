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

package org.clang.basic.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.target.impl.TargetsStatics.*;
import org.llvm.mc.MCSectionMachO;

/*template <typename Target> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 222,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 215,
 FQN="(anonymous namespace)::DarwinTargetInfo", NM="_ZN12_GLOBAL__N_116DarwinTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116DarwinTargetInfoE")
//</editor-fold>
public class DarwinTargetInfo</*typename*/ Target extends TargetInfo>  extends /*public*/ OSTargetInfo<Target> {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinTargetInfo::getOSDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 218,
   FQN="(anonymous namespace)::DarwinTargetInfo::getOSDefines", NM="_ZNK12_GLOBAL__N_116DarwinTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116DarwinTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE")
  //</editor-fold>
  protected void getOSDefines(/*const*/ LangOptions /*&*/ Opts, /*const*/ Triple /*&*/ Triple, 
              MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    getDarwinDefines(Builder, Opts, Triple, super.tgt.PlatformName, 
        super.tgt.PlatformMinVersion);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinTargetInfo::DarwinTargetInfo<Target>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 232,
   FQN="(anonymous namespace)::DarwinTargetInfo::DarwinTargetInfo<Target>", NM="_ZN12_GLOBAL__N_116DarwinTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116DarwinTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public DarwinTargetInfo(Target T, /*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : OSTargetInfo<Target>(Triple, Opts)*/ 
    //START JInit
    /*ParenListExpr*/super(T, _Triple, Opts);
    //END JInit
    // By default, no TLS, and we whitelist permitted architecture/OS
    // combinations.
    super.tgt.TLSSupported = false;
    if (_Triple.isMacOSX()) {
      super.tgt.TLSSupported = !_Triple.isMacOSXVersionLT(10, 7);
    } else if (_Triple.isiOS()) {
      // 64-bit iOS supported it from 8 onwards, 32-bit from 9 onwards.
      if (_Triple.getArch() == Triple.ArchType.x86_64
         || _Triple.getArch() == Triple.ArchType.aarch64) {
        super.tgt.TLSSupported = !_Triple.isOSVersionLT(8);
      } else if (_Triple.getArch() == Triple.ArchType.x86
         || _Triple.getArch() == Triple.ArchType.arm
         || _Triple.getArch() == Triple.ArchType.thumb) {
        super.tgt.TLSSupported = !_Triple.isOSVersionLT(9);
      }
    } else if (_Triple.isWatchOS()) {
      super.tgt.TLSSupported = !_Triple.isOSVersionLT(2);
    }
    
    super.tgt.MCountName = $("\001mcount");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinTargetInfo::isValidSectionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 247,
   FQN="(anonymous namespace)::DarwinTargetInfo::isValidSectionSpecifier", NM="_ZNK12_GLOBAL__N_116DarwinTargetInfo23isValidSectionSpecifierEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116DarwinTargetInfo23isValidSectionSpecifierEN4llvm9StringRefE")
  //</editor-fold>
  public std.string isValidSectionSpecifier(StringRef SR) /*const*//* override*/ {
    // Let MCSectionMachO validate this.
    StringRef Segment/*J*/= new StringRef(), Section/*J*/= new StringRef();
    /*uint*/uint$ref TAA = create_uint$ref(), StubSize = create_uint$ref();
    bool$ref HasTAA = create_bool$ref();
    return MCSectionMachO.ParseSectionSpecifier(new StringRef(SR), Segment, Section, 
        TAA, HasTAA, StubSize);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinTargetInfo::getStaticInitSectionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 264,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 256,
   FQN="(anonymous namespace)::DarwinTargetInfo::getStaticInitSectionSpecifier", NM="_ZNK12_GLOBAL__N_116DarwinTargetInfo29getStaticInitSectionSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116DarwinTargetInfo29getStaticInitSectionSpecifierEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getStaticInitSectionSpecifier() /*const*//* override*/ {
    // FIXME: We should return 0 when building kexts.
    return $("__TEXT,__StaticInit,regular,pure_instructions");
  }

  
  /// Darwin does not support protected visibility.  Darwin's "default"
  /// is very similar to ELF's "protected";  Darwin requires a "weak"
  /// attribute on declarations that can be dynamically replaced.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinTargetInfo::hasProtectedVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 272,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 264,
   FQN="(anonymous namespace)::DarwinTargetInfo::hasProtectedVisibility", NM="_ZNK12_GLOBAL__N_116DarwinTargetInfo22hasProtectedVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116DarwinTargetInfo22hasProtectedVisibilityEv")
  //</editor-fold>
  public boolean hasProtectedVisibility() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DarwinTargetInfo::getExnObjectAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 276,
   FQN="(anonymous namespace)::DarwinTargetInfo::getExnObjectAlignment", NM="_ZNK12_GLOBAL__N_116DarwinTargetInfo21getExnObjectAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116DarwinTargetInfo21getExnObjectAlignmentEv")
  //</editor-fold>
  public /*uint*/int getExnObjectAlignment() /*const*//* override*/ {
    // The alignment of an exception object is 8-bytes for darwin since
    // libc++abi doesn't declare _Unwind_Exception with __attribute__((aligned))
    // and therefore doesn't guarantee 16-byte alignment.
    return 64;
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
