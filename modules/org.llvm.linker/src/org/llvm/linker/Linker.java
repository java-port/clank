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

package org.llvm.linker;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.ir.*;
import org.llvm.linker.*;;
import org.llvm.linker.java.*;
import org.llvm.linker.java.LinkerFunctionPointers.*;
import org.llvm.linker.impl.*;
import org.llvm.llvmc.*;
import org.llvm.transforms.utils.*;


/// This class provides the core functionality of linking in LLVM. It keeps a
/// pointer to the merged module so far. It doesn't take ownership of the
/// module since it is assumed that the user of this class will want to do
/// something with it after the linking.
//<editor-fold defaultstate="collapsed" desc="llvm::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Linker/Linker.h", line = 24,
 FQN="llvm::Linker", NM="_ZN4llvm6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm6LinkerE")
//</editor-fold>
public class Linker implements Destructors.ClassWithDestructor {
  private IRMover Mover;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Linker::Flags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Linker/Linker.h", line = 28,
   FQN="llvm::Linker::Flags", NM="_ZN4llvm6Linker5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm6Linker5FlagsE")
  //</editor-fold>
  public static final class/*enum*/ Flags {
    public static final /*uint*/int None = 0;
    public static final /*uint*/int OverrideFromSrc = (1 << 0);
    public static final /*uint*/int LinkOnlyNeeded = (1 << 1);
    public static final /*uint*/int InternalizeLinkedSymbols = (1 << 2);
    /// Don't force link referenced linkonce definitions, import declaration.
    public static final /*uint*/int DontForceLinkLinkonceODR = (1 << 3);
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 602,
   FQN="llvm::Linker::Linker", NM="_ZN4llvm6LinkerC1ERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm6LinkerC1ERNS_6ModuleE")
  //</editor-fold>
  public Linker(final Module /*&*/ M) {
    // : Mover(M) 
    //START JInit
    this.Mover = new IRMover(M);
    //END JInit
  }

  
  /// \brief Link \p Src into the composite.
  ///
  /// Passing OverrideSymbols as true will have symbols from Src
  /// shadow those in the Dest.
  /// For ThinLTO function importing/exporting the \p ModuleSummaryIndex
  /// is passed. If \p GlobalsToImport is provided, only the globals that
  /// are part of the set will be imported from the source module.
  ///
  /// Returns true on error.
  //<editor-fold defaultstate="collapsed" desc="llvm::Linker::linkInModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 604,
   FQN="llvm::Linker::linkInModule", NM="_ZN4llvm6Linker12linkInModuleESt10unique_ptrINS_6ModuleESt14default_deleteIS2_EEjPNS_8DenseSetIPKNS_11GlobalValueENS_12DenseMapInfoIS9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm6Linker12linkInModuleESt10unique_ptrINS_6ModuleESt14default_deleteIS2_EEjPNS_8DenseSetIPKNS_11GlobalValueENS_12DenseMapInfoIS9_EEEE")
  //</editor-fold>
  public boolean linkInModule(std.unique_ptr<Module> Src) {
    return linkInModule(Src, Flags.None, 
              (DenseSet</*const*/ GlobalValue /*P*/ > /*P*/)null);
  }
  public boolean linkInModule(std.unique_ptr<Module> Src, /*uint*/int Flags/*= Flags::None*/) {
    return linkInModule(Src, Flags, 
              (DenseSet</*const*/ GlobalValue /*P*/ > /*P*/)null);
  }
  public boolean linkInModule(std.unique_ptr<Module> Src, /*uint*/int Flags/*= Flags::None*/, 
              DenseSet</*const*/ GlobalValue /*P*/ > /*P*/ GlobalsToImport/*= null*/) {
    ModuleLinker ModLinker = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ModLinker/*J*/= $c$.clean(new ModuleLinker(Mover, $c$.track(new std.unique_ptr<Module>(JD$Move.INSTANCE, std.move(Src))), Flags, GlobalsToImport));
      return ModLinker.run();
    } finally {
      if (ModLinker != null) { ModLinker.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  //===----------------------------------------------------------------------===//
  // LinkModules entrypoint.
  //===----------------------------------------------------------------------===//
  
  /// This function links two modules together, with the resulting Dest module
  /// modified to be the composite of the two input modules. If an error occurs,
  /// true is returned and ErrorMsg (if not null) is set to indicate the problem.
  /// Upon failure, the Dest module could be in a modified state, and shouldn't be
  /// relied on to be consistent.
  //<editor-fold defaultstate="collapsed" desc="llvm::Linker::linkModules">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 619,
   FQN="llvm::Linker::linkModules", NM="_ZN4llvm6Linker11linkModulesERNS_6ModuleESt10unique_ptrIS1_St14default_deleteIS1_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm6Linker11linkModulesERNS_6ModuleESt10unique_ptrIS1_St14default_deleteIS1_EEj")
  //</editor-fold>
  public static boolean linkModules(final Module /*&*/ Dest, std.unique_ptr<Module> Src) {
    return linkModules(Dest, Src, 
             Flags.None);
  }
  public static boolean linkModules(final Module /*&*/ Dest, std.unique_ptr<Module> Src, 
             /*uint*/int Flags/*= Flags::None*/) {
    Linker L = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      L/*J*/= new Linker(Dest);
      return $c$.clean(L.linkInModule($c$.track(new std.unique_ptr<Module>(JD$Move.INSTANCE, std.move(Src))), Flags));
    } finally {
      if (L != null) { L.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Linker/Linker.h", line = 24,
   FQN="llvm::Linker::~Linker", NM="_ZN4llvm6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm6LinkerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Mover.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Mover=" + Mover; // NOI18N
  }
}
