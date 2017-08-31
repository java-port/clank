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

package org.clang.lex;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.impl.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.Module.*;
import org.clang.basic.SrcMgr.CharacteristicKind;
import org.clang.basic.java.ClankAliases;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.directory_iterator;
import static org.clang.lex.ModuleMap.KnownHeader.*;
import static org.clang.lex.impl.ModuleMapStatics.*;
import org.llvm.support.sys.path;

// JAVA PERF:
// uncomment the line in JConvert/options/optimizations.properties, we don't want to dispose IntrusiveRefCntPtr<FileSystem>

//<editor-fold defaultstate="collapsed" desc="clang::ModuleMap">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 67,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 55,
 FQN="clang::ModuleMap", NM="_ZN5clang9ModuleMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMapE")
//</editor-fold>
public class ModuleMap implements Destructors.ClassWithDestructor {
  private SourceManager /*&*/ SourceMgr;
  private DiagnosticsEngine /*&*/ Diags;
  public /*friend*/ /*const*/ LangOptions /*&*/ LangOpts;
  public /*friend*/ /*const*/ TargetInfo /*P*/ Target;
  public /*friend*/ HeaderSearch /*&*/ HeaderInfo;
  
  private SmallVector<std.unique_ptr<ModuleMapCallbacks>> Callbacks;
  
  /// \brief The directory used for Clang-supplied, builtin include headers,
  /// such as "stdint.h".
  private /*const*/ DirectoryEntry /*P*/ BuiltinIncludeDir;
  
  /// \brief Language options used to parse the module map itself.
  ///
  /// These are always simple C language options.
  private LangOptions MMapLangOpts;
  
  // The module that the main source file is associated with (the module
  // named LangOpts::CurrentModule, if we've loaded it).
  public /*friend*/ Module /*P*/ SourceModule;
  
  /// \brief The top-level modules that are known.
  private StringMap<Module /*P*//*, MallocAllocator*/> Modules;
  
  /// \brief The number of modules we have created in total.
  private /*uint*/int NumCreatedModules;
/*public:*/
  /// \brief Flags describing the role of a module header.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::ModuleHeaderRole">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 90,
   FQN="clang::ModuleMap::ModuleHeaderRole", NM="_ZN5clang9ModuleMap16ModuleHeaderRoleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap16ModuleHeaderRoleE")
  //</editor-fold>
  public static final class/*enum*/ ModuleHeaderRole {
    /// \brief This header is normally included in the module.
    public static final /*uint*/int NormalHeader = 0x0;
    /// \brief This header is included but private.
    public static final /*uint*/int PrivateHeader = 0x1;
    /// \brief This header is part of the module (for layering purposes) but
    /// should be textually included.
    public static final /*uint*/int TextualHeader = 0x2;
    // Caution: Adding an enumerator needs other changes.
    // Adjust the number of bits for KnownHeader::Storage.
    // Adjust the bitfield HeaderFileInfo::HeaderRole size.
    // Adjust the HeaderFileInfoTrait::ReadData streaming.
    // Adjust the HeaderFileInfoTrait::EmitData streaming.
    // Adjust ModuleMap::addHeader.
  };
  
  /// \brief A header that is known to reside within a given module,
  /// whether it was included or excluded.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 108,
   FQN="clang::ModuleMap::KnownHeader", NM="_ZN5clang9ModuleMap11KnownHeaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11KnownHeaderE")
  //</editor-fold>
  public static class KnownHeader implements Native.NativePOD<KnownHeader>, NativeMoveable<KnownHeader>, Native.Native$Bool  {
    private PointerInt2Pair</*const*/ Module/*P*//*, 2, ModuleHeaderRole*/ > Storage;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::KnownHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 119,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 112,
     FQN="clang::ModuleMap::KnownHeader::KnownHeader", NM="_ZN5clang9ModuleMap11KnownHeaderC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11KnownHeaderC1Ev")
    //</editor-fold>
    public KnownHeader() {
      /* : Storage(null, NormalHeader)*/ 
      //START JInit
      this.Storage = new PointerInt2Pair</*const*/ Module/*P*//*, 2, ModuleHeaderRole*/ >((Module /*P*/ )null, ModuleHeaderRole.NormalHeader);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::KnownHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 120,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 113,
     FQN="clang::ModuleMap::KnownHeader::KnownHeader", NM="_ZN5clang9ModuleMap11KnownHeaderC1EPNS_6ModuleENS0_16ModuleHeaderRoleE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11KnownHeaderC1EPNS_6ModuleENS0_16ModuleHeaderRoleE")
    //</editor-fold>
    public KnownHeader(Module /*P*/ M, /*ModuleHeaderRole*//*uint*/int Role) {
      /* : Storage(M, Role)*/ 
      assert M != null;
      //START JInit
      this.Storage = new PointerInt2Pair</*const*/ Module/*P*//*, 2, ModuleHeaderRole*/ >(M, Role);
      //END JInit
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 122,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 115,
     FQN="clang::operator==", NM="_ZN5clangeqERKNS_9ModuleMap11KnownHeaderES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clangeqERKNS_9ModuleMap11KnownHeaderES3_")
    //</editor-fold>
    public static boolean $eq_KnownHeader(/*const*/ KnownHeader /*&*/ A, /*const*/ KnownHeader /*&*/ B) {
      return A.Storage.$eq(B.Storage);
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 125,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 118,
     FQN="clang::operator!=", NM="_ZN5clangneERKNS_9ModuleMap11KnownHeaderES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clangneERKNS_9ModuleMap11KnownHeaderES3_")
    //</editor-fold>
    public static boolean $noteq_KnownHeader(/*const*/ KnownHeader /*&*/ A, /*const*/ KnownHeader /*&*/ B) {
      return A.Storage.$noteq(B.Storage);
    }

    
    /// \brief Retrieve the module the header is stored in.
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::getModule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 130,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 123,
     FQN="clang::ModuleMap::KnownHeader::getModule", NM="_ZNK5clang9ModuleMap11KnownHeader9getModuleEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap11KnownHeader9getModuleEv")
    //</editor-fold>
    public Module /*P*/ getModule() /*const*/ {
      return Storage.getPointer();
    }

    
    /// \brief The role of this header within the module.
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::getRole">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 133,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 126,
     FQN="clang::ModuleMap::KnownHeader::getRole", NM="_ZNK5clang9ModuleMap11KnownHeader7getRoleEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap11KnownHeader7getRoleEv")
    //</editor-fold>
    public /*ModuleHeaderRole*//*uint*/int getRole() /*const*/ {
      return Storage.getInt();
    }

    
    /// \brief Whether this header is available in the module.
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::isAvailable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 136,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 129,
     FQN="clang::ModuleMap::KnownHeader::isAvailable", NM="_ZNK5clang9ModuleMap11KnownHeader11isAvailableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap11KnownHeader11isAvailableEv")
    //</editor-fold>
    public boolean isAvailable() /*const*/ {
      return getModule().isAvailable();
    }

    
    /// \brief Whether this header is accessible from the specified module.
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::isAccessibleFrom">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 141,
     FQN="clang::ModuleMap::KnownHeader::isAccessibleFrom", NM="_ZNK5clang9ModuleMap11KnownHeader16isAccessibleFromEPNS_6ModuleE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap11KnownHeader16isAccessibleFromEPNS_6ModuleE")
    //</editor-fold>
    public boolean isAccessibleFrom(Module /*P*/ M) /*const*/ {
      return !((getRole() & ModuleHeaderRole.PrivateHeader) != 0)
         || ((M != null) && M.getTopLevelModule() == getModule().getTopLevelModule());
    }

    
    // \brief Whether this known header is valid (i.e., it has an
    // associated module).
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 148,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 135,
     FQN="clang::ModuleMap::KnownHeader::operator bool", NM="_ZNK5clang9ModuleMap11KnownHeadercvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap11KnownHeadercvbEv")
    //</editor-fold>
    public boolean $bool() /*const*/ {
      return Storage.getPointer() != null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::KnownHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 108,
     FQN="clang::ModuleMap::KnownHeader::KnownHeader", NM="_ZN5clang9ModuleMap11KnownHeaderC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11KnownHeaderC1ERKS1_")
    //</editor-fold>
    public /*inline*/ KnownHeader(/*const*/ KnownHeader /*&*/ $Prm0) {
      /* : Storage(.Storage)*/ 
      //START JInit
      this.Storage = new PointerInt2Pair</*const*/ Module/*P*//*, 2, ModuleHeaderRole*/ >($Prm0.Storage);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::KnownHeader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 108,
     FQN="clang::ModuleMap::KnownHeader::KnownHeader", NM="_ZN5clang9ModuleMap11KnownHeaderC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11KnownHeaderC1EOS1_")
    //</editor-fold>
    public /*inline*/ KnownHeader(JD$Move _dparam, KnownHeader /*&&*/$Prm0) {
      /* : Storage(static_cast<KnownHeader &&>().Storage)*/ 
      //START JInit
      this.Storage = new PointerInt2Pair</*const*/ Module/*P*//*, 2, ModuleHeaderRole*/ >(JD$Move.INSTANCE, $Prm0.Storage);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 108,
     FQN="clang::ModuleMap::KnownHeader::operator=", NM="_ZN5clang9ModuleMap11KnownHeaderaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11KnownHeaderaSERKS1_")
    //</editor-fold>
    public /*inline*/ KnownHeader /*&*/ $assign(/*const*/ KnownHeader /*&*/ $Prm0) {
      this.Storage.$assign($Prm0.Storage);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::KnownHeader::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 115,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 108,
     FQN="clang::ModuleMap::KnownHeader::operator=", NM="_ZN5clang9ModuleMap11KnownHeaderaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11KnownHeaderaSEOS1_")
    //</editor-fold>
    public /*inline*/ KnownHeader /*&*/ $assignMove(KnownHeader /*&&*/$Prm0) {
      this.Storage.$assignMove($Prm0.Storage);
      return /*Deref*/this;
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public KnownHeader clone() {
      return new KnownHeader(this);
    }

    public KnownHeader move() {
      return new KnownHeader(JD$Move.INSTANCE, this);
    }
    
    @Override
    public boolean $noteq(KnownHeader other) {
      return $noteq_KnownHeader(this, other);
    }

    @Override
    public boolean $eq(KnownHeader other) {
      return $eq_KnownHeader(this, other);
    }
    
    public String toString() {
      return "" + "Storage=" + Storage; // NOI18N
    }
  };
  
  /*typedef llvm::SmallPtrSet<const FileEntry *, 1> AdditionalModMapsSet*/
//  public final class AdditionalModMapsSet extends SmallPtrSet</*const*/ FileEntry /*P*/>{ };
/*private:*/
  /*typedef llvm::DenseMap<const FileEntry *, SmallVector<KnownHeader, 1> > HeadersMap*/
//  public final class HeadersMap extends DenseMap</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> >{ };
  
  /// \brief Mapping from each header to the module that owns the contents of
  /// that header.
  private /*HeadersMap*/DenseMap</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > Headers;
  
  /// \brief Mapping from directories with umbrella headers to the module
  /// that is generated from the umbrella header.
  ///
  /// This mapping is used to map headers that haven't explicitly been named
  /// in the module map over to the module that includes them via its umbrella
  /// header.
  public /*friend*/ DenseMap</*const*/ DirectoryEntry /*P*/ , Module /*P*/ > UmbrellaDirs;
  
  /// \brief The set of attributes that can be attached to a module.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::Attributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 172,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 159,
   FQN="clang::ModuleMap::Attributes", NM="_ZN5clang9ModuleMap10AttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap10AttributesE")
  //</editor-fold>
  public /*friend*/ static class/*struct*/ Attributes implements NativePOD<Attributes> {
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::Attributes::Attributes">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 173,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 160,
     FQN="clang::ModuleMap::Attributes::Attributes", NM="_ZN5clang9ModuleMap10AttributesC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap10AttributesC1Ev")
    //</editor-fold>
    public Attributes() {
      /* : IsSystem(implicit unsigned int()), IsExternC(implicit unsigned int()), IsExhaustive(implicit unsigned int())*/ 
      //START JInit
      this.IsSystem = /*implicit*/ /*uint*/false;
      this.IsExternC = /*implicit*/ /*uint*/false;
      this.IsExhaustive = /*implicit*/ /*uint*/false;
      //END JInit
    }

    
    /// \brief Whether this is a system module.
    public /*JBIT unsigned int*/ boolean IsSystem /*: 1*/;
    
    /// \brief Whether this is an extern "C" module.
    public /*JBIT unsigned int*/ boolean IsExternC /*: 1*/;
    
    /// \brief Whether this is an exhaustive set of configuration macros.
    public /*JBIT unsigned int*/ boolean IsExhaustive /*: 1*/;
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::Attributes::Attributes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 172,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 159,
     FQN="clang::ModuleMap::Attributes::Attributes", NM="_ZN5clang9ModuleMap10AttributesC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap10AttributesC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Attributes(/*const*/ Attributes /*&*/ $Prm0) {
      /* : IsSystem(.IsSystem), IsExternC(.IsExternC), IsExhaustive(.IsExhaustive)*/ 
      //START JInit
      this.IsSystem = $Prm0.IsSystem;
      this.IsExternC = $Prm0.IsExternC;
      this.IsExhaustive = $Prm0.IsExhaustive;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::Attributes::Attributes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 172,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 159,
     FQN="clang::ModuleMap::Attributes::Attributes", NM="_ZN5clang9ModuleMap10AttributesC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap10AttributesC1EOS1_")
    //</editor-fold>
    public /*inline*/ Attributes(JD$Move _dparam, Attributes /*&&*/$Prm0) {
      /* : IsSystem(static_cast<Attributes &&>().IsSystem), IsExternC(static_cast<Attributes &&>().IsExternC), IsExhaustive(static_cast<Attributes &&>().IsExhaustive)*/ 
      //START JInit
      this.IsSystem = $Prm0.IsSystem;
      this.IsExternC = $Prm0.IsExternC;
      this.IsExhaustive = $Prm0.IsExhaustive;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::Attributes::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 172,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 159,
     FQN="clang::ModuleMap::Attributes::operator=", NM="_ZN5clang9ModuleMap10AttributesaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap10AttributesaSERKS1_")
    //</editor-fold>
    public /*inline*/ Attributes /*&*/ $assign(/*const*/ Attributes /*&*/ $Prm0) {
      this.IsSystem = $Prm0.IsSystem;
      this.IsExternC = $Prm0.IsExternC;
      this.IsExhaustive = $Prm0.IsExhaustive;
      return /*Deref*/this;
    }

    @Override
    public Attributes clone() {
      return new Attributes(this);
    }

    @Override
    public boolean $eq(Attributes other) {
      if (this == other) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (this.IsSystem != other.IsSystem) {
        return false;
      }
      if (this.IsExternC != other.IsExternC) {
        return false;
      }
      if (this.IsExhaustive != other.IsExhaustive) {
        return false;
      }
      return true;
    }
    
    public String toString() {
      return "" + "IsSystem=" + IsSystem // NOI18N
                + ", IsExternC=" + IsExternC // NOI18N
                + ", IsExhaustive=" + IsExhaustive; // NOI18N
    }
  };
  
  /// \brief A directory for which framework modules can be inferred.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::InferredDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 186,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 173,
   FQN="clang::ModuleMap::InferredDirectory", NM="_ZN5clang9ModuleMap17InferredDirectoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap17InferredDirectoryE")
  //</editor-fold>
  public /*friend*/ static class/*struct*/ InferredDirectory implements Native.NativePOD<InferredDirectory> {
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::InferredDirectory::InferredDirectory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 187,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 174,
     FQN="clang::ModuleMap::InferredDirectory::InferredDirectory", NM="_ZN5clang9ModuleMap17InferredDirectoryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap17InferredDirectoryC1Ev")
    //</editor-fold>
    public InferredDirectory() {
      /* : InferModules(implicit unsigned int()), Attrs(), ExcludedModules()*/ 
      //START JInit
      this.InferModules = /*implicit*/ /*uint*/false;
      this.Attrs = new Attributes();
      this.ExcludedModules = new SmallVector<std.string>(2, new std.string());
      //END JInit
    }

    
    /// \brief Whether to infer modules from this directory.
    public /*JBIT unsigned int*/ boolean InferModules /*: 1*/;
    
    /// \brief The attributes to use for inferred modules.
    public Attributes Attrs;
    
    /// \brief If \c InferModules is non-zero, the module map file that allowed
    /// inferred modules.  Otherwise, nullptr.
    public /*const*/ FileEntry /*P*/ ModuleMapFile;
    
    /// \brief The names of modules that cannot be inferred within this
    /// directory.
    public SmallVector<std.string> ExcludedModules;
    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::InferredDirectory::InferredDirectory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 186,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 173,
     FQN="clang::ModuleMap::InferredDirectory::InferredDirectory", NM="_ZN5clang9ModuleMap17InferredDirectoryC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap17InferredDirectoryC1EOS1_")
    //</editor-fold>
    public /*inline*/ InferredDirectory(JD$Move _dparam, InferredDirectory /*&&*/$Prm0) {
      /* : InferModules(static_cast<InferredDirectory &&>().InferModules), Attrs(static_cast<InferredDirectory &&>().Attrs), ModuleMapFile(static_cast<InferredDirectory &&>().ModuleMapFile), ExcludedModules(static_cast<InferredDirectory &&>().ExcludedModules)*/ 
      //START JInit
      this.InferModules = $Prm0.InferModules;
      this.Attrs = new Attributes(JD$Move.INSTANCE, $Prm0.Attrs);
      this.ModuleMapFile = $Prm0.ModuleMapFile;
      this.ExcludedModules = new SmallVector<std.string>(JD$Move.INSTANCE, $Prm0.ExcludedModules);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::InferredDirectory::~InferredDirectory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 186,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 173,
     FQN="clang::ModuleMap::InferredDirectory::~InferredDirectory", NM="_ZN5clang9ModuleMap17InferredDirectoryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap17InferredDirectoryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      ExcludedModules.$destroy();
      //END JDestroy
    }

    // JAVA only
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private /*inline*/ InferredDirectory(InferredDirectory /*&&*/$Prm0) {
      /* : InferModules(static_cast<InferredDirectory &&>().InferModules), Attrs(static_cast<InferredDirectory &&>().Attrs), ModuleMapFile(static_cast<InferredDirectory &&>().ModuleMapFile), ExcludedModules(static_cast<InferredDirectory &&>().ExcludedModules)*/ 
      //START JInit
      this.InferModules = $Prm0.InferModules;
      this.Attrs = new Attributes($Prm0.Attrs);
      this.ModuleMapFile = $Prm0.ModuleMapFile;
      this.ExcludedModules = new SmallVector<std.string>($Prm0.ExcludedModules);
      //END JInit
    }
    
    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public InferredDirectory $assign(InferredDirectory $Prm0) {
      this.InferModules = $Prm0.InferModules;
      this.Attrs = new Attributes($Prm0.Attrs);
      this.ModuleMapFile = $Prm0.ModuleMapFile;
      this.ExcludedModules = new SmallVector<std.string>($Prm0.ExcludedModules);
      return this;
    }
    
    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public InferredDirectory clone() {
      return new InferredDirectory(this);
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public boolean $eq(InferredDirectory other) {
      if (this == other) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (this.InferModules != other.InferModules) {
        return false;
      }
      if (this.ModuleMapFile != other.ModuleMapFile) {
        return false;
      }
      if (this.ExcludedModules.$noteq(other.ExcludedModules)) {
        return false;
      }
      if (this.Attrs.$noteq(other.Attrs)) {
        return false;
      }
      return true;
    }

    public String toString() {
      return "" + "InferModules=" + InferModules // NOI18N
                + ", Attrs=" + Attrs // NOI18N
                + ", ModuleMapFile=" + ModuleMapFile // NOI18N
                + ", ExcludedModules=" + ExcludedModules; // NOI18N
    }
  };
  
  /// \brief A mapping from directories to information about inferring
  /// framework modules from within those directories.
  public /*friend*/ DenseMap</*const*/ DirectoryEntry /*P*/ , InferredDirectory> InferredDirectories;
  
  /// A mapping from an inferred module to the module map that allowed the
  /// inference.
  private DenseMap</*const*/ Module /*P*/ , /*const*/ FileEntry /*P*/ > InferredModuleAllowedBy;
  
  private DenseMap</*const*/ Module /*P*/ , SmallPtrSet</*const*/ FileEntry /*P*/> > AdditionalModMaps;
  
  /// \brief Describes whether we haved parsed a particular file as a module
  /// map.
  private DenseMapTypeBool</*const*/ FileEntry /*P*/> ParsedModuleMap;
  
  /*friend  class ModuleMapParser*/
  
  /// \brief Resolve the given export declaration into an actual export
  /// declaration.
  ///
  /// \param Mod The module in which we're resolving the export declaration.
  ///
  /// \param Unresolved The export declaration to resolve.
  ///
  /// \param Complain Whether this routine should complain about unresolvable
  /// exports.
  ///
  /// \returns The resolved export declaration, which will have a NULL pointer
  /// if the export could not be resolved.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::resolveExport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 39,
   FQN="clang::ModuleMap::resolveExport", NM="_ZNK5clang9ModuleMap13resolveExportEPNS_6ModuleERKNS1_20UnresolvedExportDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap13resolveExportEPNS_6ModuleERKNS1_20UnresolvedExportDeclEb")
  //</editor-fold>
  private PointerInt2Pair</*const*/ Module/*P*/> resolveExport(Module /*P*/ Mod, 
               /*const*/ Module.UnresolvedExportDecl /*&*/ Unresolved, 
               boolean Complain) /*const*/ {
    // We may have just a wildcard.
    if (Unresolved.Id.empty()) {
      assert (Unresolved.Wildcard) : "Invalid unresolved export";
      return new PointerInt2Pair</*const*/ Module/*P*/>((Module /*P*/ )null, true);
    }
    
    // Resolve the module-id.
    Module /*P*/ Context = resolveModuleId(Unresolved.Id, Mod, Complain);
    if (!(Context != null)) {
      return new PointerInt2Pair</*const*/ Module/*P*/>();
    }
    
    return new PointerInt2Pair</*const*/ Module/*P*/>(Context, Unresolved.Wildcard);
  }

  
  /// \brief Resolve the given module id to an actual module.
  ///
  /// \param Id The module-id to resolve.
  ///
  /// \param Mod The module in which we're resolving the module-id.
  ///
  /// \param Complain Whether this routine should complain about unresolvable
  /// module-ids.
  ///
  /// \returns The resolved module, or null if the module-id could not be
  /// resolved.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::resolveModuleId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 57,
   FQN="clang::ModuleMap::resolveModuleId", NM="_ZNK5clang9ModuleMap15resolveModuleIdERKN4llvm11SmallVectorISt4pairISsNS_14SourceLocationEELj2EEEPNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap15resolveModuleIdERKN4llvm11SmallVectorISt4pairISsNS_14SourceLocationEELj2EEEPNS_6ModuleEb")
  //</editor-fold>
  private Module /*P*/ resolveModuleId(/*const*/ClankAliases.ModuleId/*&*/ Id, Module /*P*/ Mod, 
                 boolean Complain) /*const*/ {
    // Find the starting module.
    Module /*P*/ Context = lookupModuleUnqualified(new StringRef(Id.$at(0).first), Mod);
    if (!(Context != null)) {
      if (Complain) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Id.$at(0).second, diag.err_mmap_missing_module_unqualified)), 
                  new StringRef(Id.$at(0).first)), new StringRef(Mod.getFullModuleName())));
        } finally {
          $c$.$destroy();
        }
      }
      
      return null;
    }
    
    // Dig into the module path.
    for (/*uint*/int I = 1, N = Id.size(); I != N; ++I) {
      Module /*P*/ Sub = lookupModuleQualified(new StringRef(Id.$at(I).first), Context);
      if (!(Sub != null)) {
        if (Complain) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Id.$at(I).second, diag.err_mmap_missing_module_qualified)), 
                        new StringRef(Id.$at(I).first)), new StringRef(Context.getFullModuleName())), 
                new SourceRange(/*NO_COPY*/Id.$at(0).second, /*NO_COPY*/Id.$at(I - 1).second)));
          } finally {
            $c$.$destroy();
          }
        }
        
        return null;
      }
      
      Context = Sub;
    }
    
    return Context;
  }

  
  /// \brief Looks up the modules that \p File corresponds to.
  ///
  /// If \p File represents a builtin header within Clang's builtin include
  /// directory, this also loads all of the module maps to see if it will get
  /// associated with a specific module (e.g. in /usr/include).
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::findKnownHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 163,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 165,
   FQN="clang::ModuleMap::findKnownHeader", NM="_ZN5clang9ModuleMap15findKnownHeaderEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap15findKnownHeaderEPKNS_9FileEntryE")
  //</editor-fold>
  private DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > findKnownHeader(/*const*/ FileEntry /*P*/ File) {
    DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > Known = Headers.find(File);
    if (HeaderInfo.getHeaderSearchOpts().ImplicitModuleMaps
       && Known.$eq(/*NO_ITER_COPY*/Headers.end()) && File.getDir() == BuiltinIncludeDir
       && isBuiltinHeader(path.filename(new StringRef(File.getName())))) {
      HeaderInfo.loadTopLevelSystemModules();
      return Headers.find(File);
    }
    return Known;
  }

  
  /// \brief Searches for a module whose umbrella directory contains \p File.
  ///
  /// \param File The header to search for.
  ///
  /// \param IntermediateDirs On success, contains the set of directories
  /// searched before finding \p File.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::findHeaderInUmbrellaDirs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 175,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 177,
   FQN="clang::ModuleMap::findHeaderInUmbrellaDirs", NM="_ZN5clang9ModuleMap24findHeaderInUmbrellaDirsEPKNS_9FileEntryERN4llvm15SmallVectorImplIPKNS_14DirectoryEntryEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap24findHeaderInUmbrellaDirsEPKNS_9FileEntryERN4llvm15SmallVectorImplIPKNS_14DirectoryEntryEEE")
  //</editor-fold>
  private ModuleMap.KnownHeader findHeaderInUmbrellaDirs(/*const*/ FileEntry /*P*/ File, 
                          SmallVectorImpl</*const*/ DirectoryEntry /*P*/ > /*&*/ IntermediateDirs) {
    if (UmbrellaDirs.empty()) {
      return new KnownHeader();
    }
    
    /*const*/ DirectoryEntry /*P*/ Dir = File.getDir();
    assert ((Dir != null)) : "file in no directory";
    
    // Note: as an egregious but useful hack we use the real path here, because
    // frameworks moving from top-level frameworks to embedded frameworks tend
    // to be symlinked from the top-level location to the embedded location,
    // and we need to resolve lookups as if we had found the embedded location.
    StringRef DirName = SourceMgr.getFileManager().getCanonicalName(Dir);
    
    // Keep walking up the directory hierarchy, looking for a directory with
    // an umbrella header.
    do {
      DenseMapIterator</*const*/ DirectoryEntry /*P*/ , Module /*P*/> KnownDir = UmbrellaDirs.find(Dir);
      if (KnownDir.$noteq(/*NO_ITER_COPY*/UmbrellaDirs.end())) {
        return new KnownHeader(KnownDir.$arrow().second, ModuleHeaderRole.NormalHeader);
      }
      
      IntermediateDirs.push_back(Dir);
      
      // Retrieve our parent path.
      DirName.$assignMove(path.parent_path(/*NO_COPY*/DirName));
      if (DirName.empty()) {
        break;
      }
      
      // Resolve the parent path to a directory entry.
      Dir = SourceMgr.getFileManager().getDirectory(/*NO_COPY*/DirName);
    } while ((Dir != null));
    return new KnownHeader();
  }

  
  /// \brief Given that \p File is not in the Headers map, look it up within
  /// umbrella directories and find or create a module for it.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::findOrCreateModuleForHeaderInUmbrellaDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 352,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 358,
   FQN="clang::ModuleMap::findOrCreateModuleForHeaderInUmbrellaDir", NM="_ZN5clang9ModuleMap40findOrCreateModuleForHeaderInUmbrellaDirEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap40findOrCreateModuleForHeaderInUmbrellaDirEPKNS_9FileEntryE")
  //</editor-fold>
  private ModuleMap.KnownHeader findOrCreateModuleForHeaderInUmbrellaDir(/*const*/ FileEntry /*P*/ File) {
    assert (!(Headers.count(File) != 0)) : "already have a module for this header";
    
    SmallVector</*const*/ DirectoryEntry /*P*/> SkippedDirs/*J*/= new SmallVector</*const*/ DirectoryEntry /*P*/>(2, (DirectoryEntry /*P*/)null);
    KnownHeader H = findHeaderInUmbrellaDirs(File, SkippedDirs);
    if (H.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Module /*P*/ Result = H.getModule();
        
        // Search up the module stack until we find a module with an umbrella
        // directory.
        Module /*P*/ UmbrellaModule = Result;
        while ($c$.clean(!$c$.track(UmbrellaModule.getUmbrellaDir()).$bool() && (UmbrellaModule.Parent != null))) {
          UmbrellaModule = UmbrellaModule.Parent;
        }
        if (UmbrellaModule.InferSubmodules) {
          /*const*/ FileEntry /*P*/ UmbrellaModuleMap = getModuleMapFileForUniquing(UmbrellaModule);
          
          // Infer submodules for each of the directories we found between
          // the directory of the umbrella header and the directory where
          // the actual header is located.
          boolean Explicit = UmbrellaModule.InferExplicitSubmodules;
          
          for (/*uint*/int I = SkippedDirs.size(); I != 0; --I) {
            // Find or create the module that corresponds to this directory name.
            SmallString/*32*/ NameBuf/*J*/= new SmallString/*32*/(32);
            StringRef Name = sanitizeFilenameAsIdentifier(path.stem(new StringRef(SkippedDirs.$at(I - 1).getName())), NameBuf);
            Result = findOrCreateModule(/*NO_COPY*/Name, Result, /*IsFramework=*/ false, 
                Explicit).first;
            InferredModuleAllowedBy.$set(Result, UmbrellaModuleMap);
            Result.IsInferred = true;
            
            // Associate the module and the directory.
            UmbrellaDirs.$set(SkippedDirs.$at(I - 1), Result);
            
            // If inferred submodules export everything they import, add a
            // wildcard to the set of exports.
            if (UmbrellaModule.InferExportWildcard && Result.Exports.empty()) {
              Result.Exports.push_back(new PointerInt2Pair</*const*/ Module/*P*/>((Module /*P*/ )null, true));
            }
          }
          
          // Infer a submodule with the same name as this header file.
          SmallString/*32*/ NameBuf/*J*/= new SmallString/*32*/(32);
          StringRef Name = sanitizeFilenameAsIdentifier(path.stem(new StringRef(File.getName())), NameBuf);
          Result = findOrCreateModule(/*NO_COPY*/Name, Result, /*IsFramework=*/ false, 
              Explicit).first;
          InferredModuleAllowedBy.$set(Result, UmbrellaModuleMap);
          Result.IsInferred = true;
          Result.addTopHeader(File);
          
          // If inferred submodules export everything they import, add a
          // wildcard to the set of exports.
          if (UmbrellaModule.InferExportWildcard && Result.Exports.empty()) {
            Result.Exports.push_back(new PointerInt2Pair</*const*/ Module/*P*/>((Module /*P*/ )null, true));
          }
        } else {
          // Record each of the directories we stepped through as being part of
          // the module we found, since the umbrella header covers them all.
          for (/*uint*/int I = 0, N = SkippedDirs.size(); I != N; ++I)  {
            UmbrellaDirs.$set(SkippedDirs.$at(I), Result);
          }
        }
        
        KnownHeader Header/*J*/= new KnownHeader(Result, ModuleHeaderRole.NormalHeader);
        Headers.$at(File).push_back(Header);
        return Header;
      } finally {
        $c$.$destroy();
      }
    }
    
    return new KnownHeader();
  }

  
  /// \brief A convenience method to determine if \p File is (possibly nested)
  /// in an umbrella directory.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::isHeaderInUmbrellaDirs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 271,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 258,
   FQN="clang::ModuleMap::isHeaderInUmbrellaDirs", NM="_ZN5clang9ModuleMap22isHeaderInUmbrellaDirsEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap22isHeaderInUmbrellaDirsEPKNS_9FileEntryE")
  //</editor-fold>
  private boolean isHeaderInUmbrellaDirs(/*const*/ FileEntry /*P*/ File) {
    SmallVector</*const*/ DirectoryEntry /*P*/> IntermediateDirs/*J*/= new SmallVector</*const*/ DirectoryEntry /*P*/>(2, (DirectoryEntry /*P*/)null);
    return ((/*static_cast*/boolean)(findHeaderInUmbrellaDirs(File, IntermediateDirs).$bool()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::inferFrameworkModule">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*fixed compare of std.find return value*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 594,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 606,
   FQN="clang::ModuleMap::inferFrameworkModule", NM="_ZN5clang9ModuleMap20inferFrameworkModuleEPKNS_14DirectoryEntryENS0_10AttributesEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap20inferFrameworkModuleEPKNS_14DirectoryEntryENS0_10AttributesEPNS_6ModuleE")
  //</editor-fold>
  private Module /*P*/ inferFrameworkModule(/*const*/ DirectoryEntry /*P*/ FrameworkDir, 
                      Attributes Attrs, Module /*P*/ Parent) {
    // Note: as an egregious but useful hack we use the real path here, because
    // we might be looking at an embedded framework that symlinks out to a
    // top-level framework, and we need to infer as if we were naming the
    // top-level framework.
    StringRef FrameworkDirName = SourceMgr.getFileManager().getCanonicalName(FrameworkDir);
    
    // In case this is a case-insensitive filesystem, use the canonical
    // directory name as the ModuleName, since modules are case-sensitive.
    // FIXME: we should be able to give a fix-it hint for the correct spelling.
    SmallString/*32*/ ModuleNameStorage/*J*/= new SmallString/*32*/(32);
    StringRef ModuleName = sanitizeFilenameAsIdentifier(path.stem(/*NO_COPY*/FrameworkDirName), ModuleNameStorage);
    {
      
      // Check whether we've already found this module.
      Module /*P*/ Mod = lookupModuleQualified(/*NO_COPY*/ModuleName, Parent);
      if ((Mod != null)) {
        return Mod;
      }
    }
    
    FileManager /*&*/ FileMgr = SourceMgr.getFileManager();
    
    // If the framework has a parent path from which we're allowed to infer
    // a framework module, do so.
    /*const*/ FileEntry /*P*/ ModuleMapFile = null;
    if (!(Parent != null)) {
      // Determine whether we're allowed to infer a module map.
      boolean canInfer = false;
      if (path.has_parent_path(new Twine(FrameworkDirName))) {
        // Figure out the parent path.
        StringRef _Parent = path.parent_path(/*NO_COPY*/FrameworkDirName);
        {
          /*const*/ DirectoryEntry /*P*/ ParentDir = FileMgr.getDirectory(/*NO_COPY*/_Parent);
          if ((ParentDir != null)) {
            // Check whether we have already looked into the parent directory
            // for a module map.
            DenseMapIterator</*const*/ DirectoryEntry /*P*/ , InferredDirectory> inferred = new DenseMapIterator</*const*/ DirectoryEntry /*P*/ , InferredDirectory>(InferredDirectories.find(ParentDir));
            if (inferred.$eq(/*NO_ITER_COPY*/InferredDirectories.end())) {
              // We haven't looked here before. Load a module map, if there is
              // one.
              boolean IsFrameworkDir = _Parent.endswith(/*STRINGREF_STR*/".framework");
              {
                /*const*/ FileEntry /*P*/ ModMapFile = HeaderInfo.lookupModuleMapFile(ParentDir, IsFrameworkDir);
                if ((ModMapFile != null)) {
                  parseModuleMapFile(ModMapFile, Attrs.IsSystem, ParentDir);
                  inferred.$assignMove(/*NO_ITER_COPY*/InferredDirectories.find(ParentDir));
                }
              }
              if (inferred.$eq(/*NO_ITER_COPY*/InferredDirectories.end())) {
                inferred.$assignMove(/*NO_ITER_COPY*/InferredDirectories.insert(std.make_pair_Ptr_T(ParentDir, new InferredDirectory())).first);
              }
            }
            if (inferred.$arrow().second.InferModules) {
              // We're allowed to infer for this directory, but make sure it's okay
              // to infer this particular module.
              StringRef Name = path.stem(/*NO_COPY*/FrameworkDirName);
              canInfer = $eq_ptr(std.find(inferred.$arrow().second.ExcludedModules.begin(), 
                  inferred.$arrow().second.ExcludedModules.end(), 
                  Name), inferred.$arrow().second.ExcludedModules.end());
              
              Attrs.IsSystem |= inferred.$arrow().second.Attrs.IsSystem;
              Attrs.IsExternC |= inferred.$arrow().second.Attrs.IsExternC;
              Attrs.IsExhaustive |= inferred.$arrow().second.Attrs.IsExhaustive;
              ModuleMapFile = inferred.$arrow().second.ModuleMapFile;
            }
          }
        }
      }
      
      // If we're not allowed to infer a framework module, don't.
      if (!canInfer) {
        return null;
      }
    } else {
      ModuleMapFile = getModuleMapFileForUniquing(Parent);
    }
    
    // Look for an umbrella header.
    SmallString/*128*/ UmbrellaName = new SmallString/*128*/(new StringRef(FrameworkDir.getName()), 128);
    path.append(UmbrellaName, new Twine(/*KEEP_STR*/"Headers"), $add_StringRef_char$ptr$C(ModuleName, /*KEEP_STR*/".h"));
    /*const*/ FileEntry /*P*/ UmbrellaHeader = FileMgr.getFile(UmbrellaName.$StringRef());
    
    // FIXME: If there's no umbrella header, we could probably scan the
    // framework to load *everything*. But, it's not clear that this is a good
    // idea.
    if (!(UmbrellaHeader != null)) {
      return null;
    }
    
    Module /*P*/ Result = new Module(/*NO_COPY*/ModuleName, new SourceLocation(), Parent, 
        /*IsFramework=*/ true, /*IsExplicit=*/ false, 
        NumCreatedModules++);
    InferredModuleAllowedBy.$set(Result, ModuleMapFile);
    Result.IsInferred = true;
    if (!(Parent != null)) {
      if ($eq_StringRef(new StringRef(LangOpts.CurrentModule), /*NO_COPY*/ModuleName)) {
        SourceModule = Result;
      }
      Modules.$set(/*NO_COPY*/ModuleName, Result);
    }
    
    Result.IsSystem |= Attrs.IsSystem;
    Result.IsExternC |= Attrs.IsExternC;
    Result.ConfigMacrosExhaustive |= Attrs.IsExhaustive;
    Result.Directory = FrameworkDir;
    
    // umbrella header "umbrella-header-name"
    //
    // The "Headers/" component of the name is implied because this is
    // a framework module.
    setUmbrellaHeader(Result, UmbrellaHeader, $add_StringRef_char$ptr$C(ModuleName, /*KEEP_STR*/".h"));
    
    // export *
    Result.Exports.push_back(new PointerInt2Pair</*const*/ Module/*P*/>((Module /*P*/ )null, true));
    
    // module * { export * }
    Result.InferSubmodules = true;
    Result.InferExportWildcard = true;
    
    // Look for subframeworks.
    std.error_code EC/*J*/= new std.error_code();
    SmallString/*128*/ SubframeworksDirName = new SmallString/*128*/(new StringRef(FrameworkDir.getName()), 128);
    path.append(SubframeworksDirName, new Twine(/*KEEP_STR*/"Frameworks"));
    path.__native(SubframeworksDirName);
    FileSystem /*&*/ FS = FileMgr.getVirtualFileSystem().$star();
    for (directory_iterator Dir = FS.dir_begin(new Twine(SubframeworksDirName), EC), 
        DirEnd/*J*/= new directory_iterator();
         Dir.$noteq(DirEnd) && !EC.$bool(); Dir.increment(EC)) {
      if (!Dir.$arrow().getName().endswith(/*STRINGREF_STR*/".framework")) {
        continue;
      }
      {
        
        /*const*/ DirectoryEntry /*P*/ SubframeworkDir = FileMgr.getDirectory(Dir.$arrow().getName());
        if ((SubframeworkDir != null)) {
          // Note: as an egregious but useful hack, we use the real path here and
          // check whether it is actually a subdirectory of the parent directory.
          // This will not be the case if the 'subframework' is actually a symlink
          // out to a top-level framework.
          StringRef SubframeworkDirName = FileMgr.getCanonicalName(SubframeworkDir);
          boolean FoundParent = false;
          do {
            // Get the parent directory name.
            SubframeworkDirName.$assignMove(path.parent_path(/*NO_COPY*/SubframeworkDirName));
            if (SubframeworkDirName.empty()) {
              break;
            }
            if (FileMgr.getDirectory(/*NO_COPY*/SubframeworkDirName) == FrameworkDir) {
              FoundParent = true;
              break;
            }
          } while (true);
          if (!FoundParent) {
            continue;
          }
          
          // FIXME: Do we want to warn about subframeworks without umbrella headers?
          inferFrameworkModule(SubframeworkDir, /*NO_COPY*/Attrs, Result);
        }
      }
    }
    
    // If the module is a top-level framework, automatically link against the
    // framework.
    if (!Result.isSubFramework()) {
      inferFrameworkLink(Result, FrameworkDir, FileMgr);
    }
    
    return Result;
  }

/*public:*/
  /// \brief Construct a new module map.
  ///
  /// \param SourceMgr The source manager used to find module files and headers.
  /// This source manager should be shared with the header-search mechanism,
  /// since they will refer to the same headers.
  ///
  /// \param Diags A diagnostic engine used for diagnostics.
  ///
  /// \param LangOpts Language options for this translation unit.
  ///
  /// \param Target The target for this translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::ModuleMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 87,
   FQN="clang::ModuleMap::ModuleMap", NM="_ZN5clang9ModuleMapC1ERNS_13SourceManagerERNS_17DiagnosticsEngineERKNS_11LangOptionsEPKNS_10TargetInfoERNS_12HeaderSearchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMapC1ERNS_13SourceManagerERNS_17DiagnosticsEngineERKNS_11LangOptionsEPKNS_10TargetInfoERNS_12HeaderSearchE")
  //</editor-fold>
  public ModuleMap(SourceManager /*&*/ SourceMgr, DiagnosticsEngine /*&*/ Diags, 
      /*const*/ LangOptions /*&*/ LangOpts, /*const*/ TargetInfo /*P*/ Target, 
      HeaderSearch /*&*/ HeaderInfo) {
    /* : SourceMgr(SourceMgr), Diags(Diags), LangOpts(LangOpts), Target(Target), HeaderInfo(HeaderInfo), Callbacks(), BuiltinIncludeDir(null), MMapLangOpts(), SourceModule(null), Modules(), NumCreatedModules(0), Headers(), UmbrellaDirs(), InferredDirectories(), InferredModuleAllowedBy(), AdditionalModMaps(), ParsedModuleMap()*/ 
    //START JInit
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this./*&*/Diags=/*&*/Diags;
    this./*&*/LangOpts=/*&*/LangOpts;
    this.Target = Target;
    this./*&*/HeaderInfo=/*&*/HeaderInfo;
    this.Callbacks = new SmallVector<std.unique_ptr<ModuleMapCallbacks>>(1, new std.unique_ptr<ModuleMapCallbacks>());
    this.BuiltinIncludeDir = null;
    this.MMapLangOpts = new LangOptions();
    this.SourceModule = null;
    this.Modules = new StringMap<Module /*P*//*, MallocAllocator*/>(null);
    this.NumCreatedModules = 0;
    this.Headers = new /*HeadersMap*/DenseMap</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> >(FileEntry.DMI$FileEntryPtr, new SmallVector(1, new KnownHeader()));
    this.UmbrellaDirs = new DenseMap</*const*/ DirectoryEntry /*P*/ , Module /*P*/ >(DenseMapInfo$LikePtr.$Info(), null);
    this.InferredDirectories = new DenseMap</*const*/ DirectoryEntry /*P*/ , InferredDirectory>(DenseMapInfo$LikePtr.$Info(), new InferredDirectory());
    this.InferredModuleAllowedBy = new DenseMap</*const*/ Module /*P*/ , /*const*/ FileEntry /*P*/ >(DenseMapInfo$LikePtr.$Info(), null);
    this.AdditionalModMaps = new DenseMap</*const*/ Module /*P*/ , SmallPtrSet</*const*/ FileEntry /*P*/> >(DenseMapInfo$LikePtr.$Info(), new SmallPtrSet<FileEntry>(FileEntry.DMI$FileEntryPtr, 1));
    this.ParsedModuleMap = new DenseMapTypeBool</*const*/ FileEntry /*P*/>(FileEntry.DMI$FileEntryPtr, false);
    //END JInit
    MMapLangOpts.LineComment = true;
  }

  
  /// \brief Destroy the module map.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::~ModuleMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 96,
   FQN="clang::ModuleMap::~ModuleMap", NM="_ZN5clang9ModuleMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMapD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (StringMapEntry<Module /*P*/ > /*&*/ M : Modules)  {
      if (M.getValue() != null) { M.getValue().$destroy();};
    }
    //START JDestroy
    ParsedModuleMap.$destroy();
    AdditionalModMaps.$destroy();
    InferredModuleAllowedBy.$destroy();
    InferredDirectories.$destroy();
    UmbrellaDirs.$destroy();
    Headers.$destroy();
    Modules.$destroy();
    MMapLangOpts.$destroy();
    Callbacks.$destroy();
    //END JDestroy
  }

  
  /// \brief Set the target information.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::setTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 104,
   FQN="clang::ModuleMap::setTarget", NM="_ZN5clang9ModuleMap9setTargetERKNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap9setTargetERKNS_10TargetInfoE")
  //</editor-fold>
  public void setTarget(/*const*/ TargetInfo /*&*/ Target) {
    assert ((!(this.Target != null) || this.Target == $AddrOf(Target))) : "Improper target override";
    this.Target = $AddrOf(Target);
  }

  
  /// \brief Set the directory that contains Clang-supplied include
  /// files, such as our stdarg.h or tgmath.h.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::setBuiltinIncludeDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 304,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 291,
   FQN="clang::ModuleMap::setBuiltinIncludeDir", NM="_ZN5clang9ModuleMap20setBuiltinIncludeDirEPKNS_14DirectoryEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap20setBuiltinIncludeDirEPKNS_14DirectoryEntryE")
  //</editor-fold>
  public void setBuiltinIncludeDir(/*const*/ DirectoryEntry /*P*/ Dir) {
    BuiltinIncludeDir = Dir;
  }

  
  /// \brief Add a module map callback.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::addModuleMapCallbacks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 296,
   FQN="clang::ModuleMap::addModuleMapCallbacks", NM="_ZN5clang9ModuleMap21addModuleMapCallbacksESt10unique_ptrINS_18ModuleMapCallbacksESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap21addModuleMapCallbacksESt10unique_ptrINS_18ModuleMapCallbacksESt14default_deleteIS2_EE")
  //</editor-fold>
  public void addModuleMapCallbacks(std.unique_ptr<ModuleMapCallbacks> Callback) {
    Callbacks.push_back_T$RR(std.move(Callback));
  }


  // JAVA: lambda from llvm/tools/clang/lib/Lex/ModuleMap.cpp:335
  @FunctionalInterface
  private static interface findModuleForHeader$MakeResultLambda {
    public KnownHeader $call(ModuleMap.KnownHeader R);
  }
  
  /// \brief Retrieve the module that owns the given header file, if any.
  ///
  /// \param File The header file that is likely to be included.
  ///
  /// \returns The module KnownHeader, which provides the module that owns the
  /// given header file.  The KnownHeader is default constructed to indicate
  /// that no module owns this header file.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::findModuleForHeader">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*lambda*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 328,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 334,
   FQN="clang::ModuleMap::findModuleForHeader", NM="_ZN5clang9ModuleMap19findModuleForHeaderEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap19findModuleForHeaderEPKNS_9FileEntryE")
  //</editor-fold>
  public ModuleMap.KnownHeader findModuleForHeader(/*const*/ FileEntry /*P*/ File) {
    findModuleForHeader$MakeResultLambda MakeResult =  (R) -> 
      {
        if (((R.getRole() & ModuleMap.ModuleHeaderRole.TextualHeader) != 0)) {
          return new ModuleMap.KnownHeader();
        }
        return new ModuleMap.KnownHeader(JD$Move.INSTANCE, R);
      }
;
    
    DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > Known = findKnownHeader(File);
    if (Known.$noteq(/*NO_ITER_COPY*/Headers.end())) {
      ModuleMap.KnownHeader Result/*J*/= new ModuleMap.KnownHeader();
      // Iterate over all modules that 'File' is part of to find the best fit.
      for (KnownHeader /*&*/ H : Known.$arrow().second) {
        // Prefer a header from the source module over all others.
        if (H.getModule().getTopLevelModule() == SourceModule) {
          return MakeResult.$call(new KnownHeader(H));
        }
        if (!Result.$bool() || isBetterKnownHeader(H, Result)) {
          Result.$assign(H);
        }
      }
      return MakeResult.$call(new KnownHeader(Result));
    }
    
    return MakeResult.$call(findOrCreateModuleForHeaderInUmbrellaDir(File));
  }
  
  /// \brief Retrieve all the modules that contain the given header file. This
  /// may not include umbrella modules, nor information from external sources,
  /// if they have not yet been inferred / loaded.
  ///
  /// Typically, \ref findModuleForHeader should be used instead, as it picks
  /// the preferred module for the header.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::findAllModulesForHeader">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 424,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 430,
   FQN="clang::ModuleMap::findAllModulesForHeader", NM="_ZNK5clang9ModuleMap23findAllModulesForHeaderEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap23findAllModulesForHeaderEPKNS_9FileEntryE")
  //</editor-fold>
  public ArrayRef<ModuleMap.KnownHeader> findAllModulesForHeader(/*const*/ FileEntry /*P*/ File) /*const*/ {
    DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > It = Headers.find(File);
    if (It.$eq(Headers.end())) {
      return ArrayRef.None();
    }
    return new ArrayRef<ModuleMap.KnownHeader>(It.$arrow().second);
  }

  
  /// \brief Reports errors if a module must not include a specific file.
  ///
  /// \param RequestingModule The module including a file.
  ///
  /// \param RequestingModuleIsModuleInterface \c true if the inclusion is in
  ///        the interface of RequestingModule, \c false if it's in the
  ///        implementation of RequestingModule. Value is ignored and
  ///        meaningless if RequestingModule is nullptr.
  ///
  /// \param FilenameLoc The location of the inclusion's filename.
  ///
  /// \param Filename The included filename as written.
  ///
  /// \param File The included file.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::diagnoseHeaderInclusion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 237,
   FQN="clang::ModuleMap::diagnoseHeaderInclusion", NM="_ZN5clang9ModuleMap23diagnoseHeaderInclusionEPNS_6ModuleEbNS_14SourceLocationEN4llvm9StringRefEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap23diagnoseHeaderInclusionEPNS_6ModuleEbNS_14SourceLocationEN4llvm9StringRefEPKNS_9FileEntryE")
  //</editor-fold>
  public void diagnoseHeaderInclusion(Module /*P*/ RequestingModule, 
                         boolean RequestingModuleIsModuleInterface, 
                         SourceLocation FilenameLoc, 
                         StringRef Filename, 
                         /*const*/ FileEntry /*P*/ File) {
    // No errors for indirect modules. This may be a bit of a problem for modules
    // with no source files.
    if (getTopLevelOrNull(RequestingModule) != getTopLevelOrNull(SourceModule)) {
      return;
    }
    if ((RequestingModule != null)) {
      resolveUses(RequestingModule, /*Complain=*/ false);
    }
    
    boolean Excluded = false;
    Module /*P*/ Private = null;
    Module /*P*/ NotUsed = null;
    
    DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > Known = findKnownHeader(File);
    if (Known.$noteq(/*NO_ITER_COPY*/Headers.end())) {
      for (/*const*/ KnownHeader /*&*/ Header : Known.$arrow().second) {
        // Remember private headers for later printing of a diagnostic.
        if (violatesPrivateInclude(RequestingModule, File, /*NO_COPY*/Header)) {
          Private = Header.getModule();
          continue;
        }
        
        // If uses need to be specified explicitly, we are only allowed to return
        // modules that are explicitly used by the requesting module.
        if ((RequestingModule != null) && LangOpts.ModulesDeclUse
           && !RequestingModule.directlyUses(Header.getModule())) {
          NotUsed = Header.getModule();
          continue;
        }
        
        // We have found a module that we can happily use.
        return;
      }
      
      Excluded = true;
    }
    
    // We have found a header, but it is private.
    if ((Private != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/FilenameLoc, diag.warn_use_of_private_header_outside_module)), 
            /*NO_COPY*/Filename));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // We have found a module, but we don't use it.
    if ((NotUsed != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/FilenameLoc, diag.err_undeclared_use_of_module)), 
                new StringRef(RequestingModule.getFullModuleName())), /*NO_COPY*/Filename));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (Excluded || isHeaderInUmbrellaDirs(File)) {
      return;
    }
    
    // At this point, only non-modular includes remain.
    if (LangOpts.ModulesStrictDeclUse) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/FilenameLoc, diag.err_undeclared_use_of_module)), 
                new StringRef(RequestingModule.getFullModuleName())), /*NO_COPY*/Filename));
      } finally {
        $c$.$destroy();
      }
    } else if ((RequestingModule != null) && RequestingModuleIsModuleInterface) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int DiagID = RequestingModule.getTopLevelModule().IsFramework ? diag.warn_non_modular_include_in_framework_module : diag.warn_non_modular_include_in_module;
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/FilenameLoc, DiagID)), new StringRef(RequestingModule.getFullModuleName())));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// \brief Determine whether the given header is part of a module
  /// marked 'unavailable'.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::isHeaderInUnavailableModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 432,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 438,
   FQN="clang::ModuleMap::isHeaderInUnavailableModule", NM="_ZNK5clang9ModuleMap27isHeaderInUnavailableModuleEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap27isHeaderInUnavailableModuleEPKNS_9FileEntryE")
  //</editor-fold>
  public boolean isHeaderInUnavailableModule(/*const*/ FileEntry /*P*/ Header) /*const*/ {
    return isHeaderUnavailableInModule(Header, (/*const*/ Module /*P*/ )null);
  }

  // JAVA: lambda for method isHeaderUnavailableInModule
  private static interface isHeaderUnavailableInModule$IsUnavailableLambda {
    boolean $call(/*const*/ Module /*P*/ M);
  }
  
  /// \brief Determine whether the given header is unavailable as part
  /// of the specified module.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::isHeaderUnavailableInModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*lambda*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 436,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 442,
   FQN="clang::ModuleMap::isHeaderUnavailableInModule", NM="_ZNK5clang9ModuleMap27isHeaderUnavailableInModuleEPKNS_9FileEntryEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap27isHeaderUnavailableInModuleEPKNS_9FileEntryEPKNS_6ModuleE")
  //</editor-fold>
  public boolean isHeaderUnavailableInModule(/*const*/ FileEntry /*P*/ Header, 
                             /*const*/ Module /*P*/ RequestingModule) /*const*/ {
    DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > Known = Headers.find(Header);
    if (Known.$noteq(Headers.end())) {
      for (type$ptr<KnownHeader> I = Known.$arrow().second.begin(), 
          E = Known.$arrow().second.end();
           $noteq_iter(I, E); I.$preInc()) {
        if (I./*->*/$star().isAvailable() && (!(RequestingModule != null)
           || I./*->*/$star().getModule().isSubModuleOf(RequestingModule))) {
          return false;
        }
      }
      return true;
    }
    
    /*const*/ DirectoryEntry /*P*/ Dir = Header.getDir();
    SmallVector</*const*/ DirectoryEntry /*P*/> SkippedDirs/*J*/= new SmallVector</*const*/ DirectoryEntry /*P*/>(2, (DirectoryEntry /*P*/)null);
    StringRef DirName = new StringRef(Dir.getName());
    
    isHeaderUnavailableInModule$IsUnavailableLambda IsUnavailable =  (M) -> 
      {
        return !M.isAvailable() && (!(RequestingModule != null)
           || M.isSubModuleOf(RequestingModule));
      }
  ;
    
    // Keep walking up the directory hierarchy, looking for a directory with
    // an umbrella header.
    do {
      DenseMapIterator</*const*/ DirectoryEntry /*P*/ , Module /*P*/ > KnownDir = UmbrellaDirs.find(Dir);
      if (KnownDir.$noteq(UmbrellaDirs.end())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Module /*P*/ Found = KnownDir.$arrow().second;
          if (IsUnavailable.$call(Found)) {
            return true;
          }
          
          // Search up the module stack until we find a module with an umbrella
          // directory.
          Module /*P*/ UmbrellaModule = Found;
          while ($c$.clean(!$c$.track(UmbrellaModule.getUmbrellaDir()).$bool() && (UmbrellaModule.Parent != null))) {
            UmbrellaModule = UmbrellaModule.Parent;
          }
          if (UmbrellaModule.InferSubmodules) {
            for (/*uint*/int I = SkippedDirs.size(); I != 0; --I) {
              // Find or create the module that corresponds to this directory name.
              SmallString/*32*/ NameBuf/*J*/= new SmallString/*32*/(32);
              StringRef Name = sanitizeFilenameAsIdentifier(path.stem(new StringRef(SkippedDirs.$at(I - 1).getName())), 
                  NameBuf);
              Found = lookupModuleQualified(/*NO_COPY*/Name, Found);
              if (!(Found != null)) {
                return false;
              }
              if (IsUnavailable.$call(Found)) {
                return true;
              }
            }
            
            // Infer a submodule with the same name as this header file.
            SmallString/*32*/ NameBuf/*J*/= new SmallString/*32*/(32);
            StringRef Name = sanitizeFilenameAsIdentifier(path.stem(new StringRef(Header.getName())), 
                NameBuf);
            Found = lookupModuleQualified(/*NO_COPY*/Name, Found);
            if (!(Found != null)) {
              return false;
            }
          }
          
          return IsUnavailable.$call(Found);
        } finally {
          $c$.$destroy();
        }
      }
      
      SkippedDirs.push_back(Dir);
      
      // Retrieve our parent path.
      DirName.$assignMove(path.parent_path(/*NO_COPY*/DirName));
      if (DirName.empty()) {
        break;
      }
      
      // Resolve the parent path to a directory entry.
      Dir = SourceMgr.getFileManager().getDirectory(/*NO_COPY*/DirName);
    } while ((Dir != null));
    
    return false;
  }

  
  /// \brief Retrieve a module with the given name.
  ///
  /// \param Name The name of the module to look up.
  ///
  /// \returns The named module, if known; otherwise, returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::findModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 518,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 524,
   FQN="clang::ModuleMap::findModule", NM="_ZNK5clang9ModuleMap10findModuleEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap10findModuleEN4llvm9StringRefE")
  //</editor-fold>
  public Module /*P*/ findModule(StringRef Name) /*const*/ {
    StringMapIterator<Module /*P*//*, MallocAllocator*/> Known = Modules.find(/*NO_COPY*/Name);
    if (Known.$noteq(Modules.end())) {
      return Known.$arrow().getValue();
    }
    
    return null;
  }

  
  /// \brief Retrieve a module with the given name using lexical name lookup,
  /// starting at the given context.
  ///
  /// \param Name The name of the module to look up.
  ///
  /// \param Context The module context, from which we will perform lexical
  /// name lookup.
  ///
  /// \returns The named module, if known; otherwise, returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::lookupModuleUnqualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 526,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 532,
   FQN="clang::ModuleMap::lookupModuleUnqualified", NM="_ZNK5clang9ModuleMap23lookupModuleUnqualifiedEN4llvm9StringRefEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap23lookupModuleUnqualifiedEN4llvm9StringRefEPNS_6ModuleE")
  //</editor-fold>
  public Module /*P*/ lookupModuleUnqualified(StringRef Name, 
                         Module /*P*/ Context) /*const*/ {
    for (; (Context != null); Context = Context.Parent) {
      {
        Module /*P*/ Sub = lookupModuleQualified(/*NO_COPY*/Name, Context);
        if ((Sub != null)) {
          return Sub;
        }
      }
    }
    
    return findModule(/*NO_COPY*/Name);
  }

  
  /// \brief Retrieve a module with the given name within the given context,
  /// using direct (qualified) name lookup.
  ///
  /// \param Name The name of the module to look up.
  /// 
  /// \param Context The module for which we will look for a submodule. If
  /// null, we will look for a top-level module.
  ///
  /// \returns The named submodule, if known; otherwose, returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::lookupModuleQualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 536,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 542,
   FQN="clang::ModuleMap::lookupModuleQualified", NM="_ZNK5clang9ModuleMap21lookupModuleQualifiedEN4llvm9StringRefEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap21lookupModuleQualifiedEN4llvm9StringRefEPNS_6ModuleE")
  //</editor-fold>
  public Module /*P*/ lookupModuleQualified(StringRef Name, Module /*P*/ Context) /*const*/ {
    if (!(Context != null)) {
      return findModule(/*NO_COPY*/Name);
    }
    
    return Context.findSubmodule(new StringRef(Name));
  }

  
  /// \brief Find a new module or submodule, or create it if it does not already
  /// exist.
  ///
  /// \param Name The name of the module to find or create.
  ///
  /// \param Parent The module that will act as the parent of this submodule,
  /// or NULL to indicate that this is a top-level module.
  ///
  /// \param IsFramework Whether this is a framework module.
  ///
  /// \param IsExplicit Whether this is an explicit submodule.
  ///
  /// \returns The found or newly-created module, along with a boolean value
  /// that will be true if the module is newly-created.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::findOrCreateModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 543,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 549,
   FQN="clang::ModuleMap::findOrCreateModule", NM="_ZN5clang9ModuleMap18findOrCreateModuleEN4llvm9StringRefEPNS_6ModuleEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap18findOrCreateModuleEN4llvm9StringRefEPNS_6ModuleEbb")
  //</editor-fold>
  public std.pairTypeBool<Module /*P*/> findOrCreateModule(StringRef Name, Module /*P*/ Parent, boolean IsFramework, 
                    boolean IsExplicit) {
    {
      // Try to find an existing module with this name.
      Module /*P*/ Sub = lookupModuleQualified(/*NO_COPY*/Name, Parent);
      if ((Sub != null)) {
        return std.make_pair_Ptr_bool(Sub, false);
      }
    }
    
    // Create a new module with this name.
    Module /*P*/ Result = new Module(/*NO_COPY*/Name, new SourceLocation(), Parent, 
        IsFramework, IsExplicit, NumCreatedModules++);
    if (!(Parent != null)) {
      if ($eq_StringRef(new StringRef(LangOpts.CurrentModule), /*NO_COPY*/Name)) {
        SourceModule = Result;
      }
      Modules.$set(/*NO_COPY*/Name, Result);
    }
    return std.make_pair_Ptr_bool(Result, true);
  }

  
  /// \brief Infer the contents of a framework module map from the given
  /// framework directory.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::inferFrameworkModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 587,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 599,
   FQN="clang::ModuleMap::inferFrameworkModule", NM="_ZN5clang9ModuleMap20inferFrameworkModuleEPKNS_14DirectoryEntryEbPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap20inferFrameworkModuleEPKNS_14DirectoryEntryEbPNS_6ModuleE")
  //</editor-fold>
  public Module /*P*/ inferFrameworkModule(/*const*/ DirectoryEntry /*P*/ FrameworkDir, 
                      boolean IsSystem, Module /*P*/ Parent) {
    Attributes Attrs/*J*/= new Attributes();
    Attrs.IsSystem = IsSystem;
    return inferFrameworkModule(FrameworkDir, /*NO_COPY*/Attrs, Parent);
  }

  
  /// \brief Retrieve the module map file containing the definition of the given
  /// module.
  ///
  /// \param Module The module whose module map file will be returned, if known.
  ///
  /// \returns The file entry for the module map file containing the given
  /// module, or NULL if the module definition was inferred.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::getContainingModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 831,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 834,
   FQN="clang::ModuleMap::getContainingModuleMapFile", NM="_ZNK5clang9ModuleMap26getContainingModuleMapFileEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap26getContainingModuleMapFileEPKNS_6ModuleE")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getContainingModuleMapFile(/*const*/ Module /*P*/ Module) /*const*/ {
    if (Module.DefinitionLoc.isInvalid()) {
      return null;
    }
    
    return SourceMgr.getFileEntryForID(SourceMgr.getFileID(/*NO_COPY*/Module.DefinitionLoc));
  }

  
  /// \brief Get the module map file that (along with the module name) uniquely
  /// identifies this module.
  ///
  /// The particular module that \c Name refers to may depend on how the module
  /// was found in header search. However, the combination of \c Name and
  /// this module map will be globally unique for top-level modules. In the case
  /// of inferred modules, returns the module map that allowed the inference
  /// (e.g. contained 'module *'). Otherwise, returns
  /// getContainingModuleMapFile().
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::getModuleMapFileForUniquing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 840,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 843,
   FQN="clang::ModuleMap::getModuleMapFileForUniquing", NM="_ZNK5clang9ModuleMap27getModuleMapFileForUniquingEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap27getModuleMapFileForUniquingEPKNS_6ModuleE")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getModuleMapFileForUniquing(/*const*/ Module /*P*/ M) /*const*/ {
    if (M.IsInferred) {
      assert ((InferredModuleAllowedBy.count(M) != 0)) : "missing inferred module map";
      return InferredModuleAllowedBy.find(M).$arrow().second;
    }
    return getContainingModuleMapFile(M);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::setInferredModuleAllowedBy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 848,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 851,
   FQN="clang::ModuleMap::setInferredModuleAllowedBy", NM="_ZN5clang9ModuleMap26setInferredModuleAllowedByEPNS_6ModuleEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap26setInferredModuleAllowedByEPNS_6ModuleEPKNS_9FileEntryE")
  //</editor-fold>
  public void setInferredModuleAllowedBy(Module /*P*/ M, /*const*/ FileEntry /*P*/ ModMap) {
    assert (M.IsInferred) : "module not inferred";
    InferredModuleAllowedBy.$set(M, ModMap);
  }

  
  /// \brief Get any module map files other than getModuleMapFileForUniquing(M)
  /// that define submodules of a top-level module \p M. This is cheaper than
  /// getting the module map file for each submodule individually, since the
  /// expected number of results is very small.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::getAdditionalModuleMapFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 417,
   FQN="clang::ModuleMap::getAdditionalModuleMapFiles", NM="_ZN5clang9ModuleMap27getAdditionalModuleMapFilesEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap27getAdditionalModuleMapFilesEPKNS_6ModuleE")
  //</editor-fold>
  public SmallPtrSet</*const*/ FileEntry /*P*/>/*P*/ getAdditionalModuleMapFiles(/*const*/ Module /*P*/ M) {
    DenseMapIterator</*const*/ Module /*P*/ , SmallPtrSet</*const*/ FileEntry /*P*/>> I = AdditionalModMaps.find(M);
    if (I.$eq(/*NO_ITER_COPY*/AdditionalModMaps.end())) {
      return null;
    }
    return $AddrOf(I.$arrow().second);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::addAdditionalModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 443,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 424,
   FQN="clang::ModuleMap::addAdditionalModuleMapFile", NM="_ZN5clang9ModuleMap26addAdditionalModuleMapFileEPKNS_6ModuleEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap26addAdditionalModuleMapFileEPKNS_6ModuleEPKNS_9FileEntryE")
  //</editor-fold>
  public void addAdditionalModuleMapFile(/*const*/ Module /*P*/ M, /*const*/ FileEntry /*P*/ ModuleMap) {
    AdditionalModMaps.$at(M).insert(ModuleMap);
  }

  
  /// \brief Resolve all of the unresolved exports in the given module.
  ///
  /// \param Mod The module whose exports should be resolved.
  ///
  /// \param Complain Whether to emit diagnostics for failures.
  ///
  /// \returns true if any errors were encountered while resolving exports,
  /// false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::resolveExports">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 875,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 878,
   FQN="clang::ModuleMap::resolveExports", NM="_ZN5clang9ModuleMap14resolveExportsEPNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap14resolveExportsEPNS_6ModuleEb")
  //</editor-fold>
  public boolean resolveExports(Module /*P*/ Mod, boolean Complain) {
    SmallVector<UnresolvedExportDecl> Unresolved = new SmallVector<UnresolvedExportDecl>(JD$Move.INSTANCE, std.move(Mod.UnresolvedExports));
    Mod.UnresolvedExports.clear();
    for (UnresolvedExportDecl /*&*/ UE : Unresolved) {
      PointerInt2Pair</*const*/ Module/*P*/> Export = resolveExport(Mod, UE, Complain);
      if ((Export.getPointer() != null) || (Export.getInt() != 0)) {
        Mod.Exports.push_back(Export);
      } else {
        Mod.UnresolvedExports.push_back(UE);
      }
    }
    return !Mod.UnresolvedExports.empty();
  }

  
  /// \brief Resolve all of the unresolved uses in the given module.
  ///
  /// \param Mod The module whose uses should be resolved.
  ///
  /// \param Complain Whether to emit diagnostics for failures.
  ///
  /// \returns true if any errors were encountered while resolving uses,
  /// false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::resolveUses">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*use ClankAliases.ModuleId*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 888,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 891,
   FQN="clang::ModuleMap::resolveUses", NM="_ZN5clang9ModuleMap11resolveUsesEPNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap11resolveUsesEPNS_6ModuleEb")
  //</editor-fold>
  public boolean resolveUses(Module /*P*/ Mod, boolean Complain) {
    SmallVector<ClankAliases.ModuleId> Unresolved = new SmallVector<>(Mod.UnresolvedDirectUses);
    Mod.UnresolvedDirectUses.clear();
    for (ClankAliases.ModuleId /*&*/ UDU : Unresolved) {
      Module /*P*/ DirectUse = resolveModuleId(UDU, Mod, Complain);
      if ((DirectUse != null)) {
        Mod.DirectUses.push_back(DirectUse);
      } else {
        Mod.UnresolvedDirectUses.push_back(UDU);
      }
    }
    return !Mod.UnresolvedDirectUses.empty();
  }

  
  /// \brief Resolve all of the unresolved conflicts in the given module.
  ///
  /// \param Mod The module whose conflicts should be resolved.
  ///
  /// \param Complain Whether to emit diagnostics for failures.
  ///
  /// \returns true if any errors were encountered while resolving conflicts,
  /// false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::resolveConflicts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 901,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 904,
   FQN="clang::ModuleMap::resolveConflicts", NM="_ZN5clang9ModuleMap16resolveConflictsEPNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap16resolveConflictsEPNS_6ModuleEb")
  //</editor-fold>
  public boolean resolveConflicts(Module /*P*/ Mod, boolean Complain) {
    vector<UnresolvedConflict> Unresolved = new vector<UnresolvedConflict>(JD$Move.INSTANCE, std.move(Mod.UnresolvedConflicts));
    Mod.UnresolvedConflicts.clear();
    for (UnresolvedConflict /*&*/ UC : Unresolved) {
      {
        Module /*P*/ OtherMod = resolveModuleId(UC.Id, Mod, Complain);
        if ((OtherMod != null)) {
          Module.Conflict Conflict = null;
          try {
            Conflict/*J*/= new Module.Conflict();
            Conflict.Other = OtherMod;
            Conflict.Message.$assign(UC.Message);
            Mod.Conflicts.push_back(Conflict);
          } finally {
            if (Conflict != null) { Conflict.$destroy(); }
          }
        } else {
          Mod.UnresolvedConflicts.push_back(UC);
        }
      }
    }
    return !Mod.UnresolvedConflicts.empty();
  }

  
  /// \brief Infers the (sub)module based on the given source location and
  /// source manager.
  ///
  /// \param Loc The location within the source that we are querying, along
  /// with its source manager.
  ///
  /// \returns The module that owns this source location, or null if no
  /// module owns this source location.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::inferModuleFromLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 916,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 919,
   FQN="clang::ModuleMap::inferModuleFromLocation", NM="_ZN5clang9ModuleMap23inferModuleFromLocationENS_13FullSourceLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap23inferModuleFromLocationENS_13FullSourceLocE")
  //</editor-fold>
  public Module /*P*/ inferModuleFromLocation(FullSourceLoc Loc) {
    if (Loc.isInvalid()) {
      return null;
    }
    if (UmbrellaDirs.empty() && Headers.empty()) {
      return null;
    }
    
    // Use the expansion location to determine which module we're in.
    FullSourceLoc ExpansionLoc = Loc.getExpansionLoc();
    if (!ExpansionLoc.isFileID()) {
      return null;
    }
    
    /*const*/ SourceManager /*&*/ SrcMgr = Loc.getManager();
    FileID ExpansionFileID = ExpansionLoc.getFileID();
    {
      
      /*const*/ FileEntry /*P*/ ExpansionFile;
      while (((/*P*/ ExpansionFile = SrcMgr.getFileEntryForID(/*NO_COPY*/ExpansionFileID)) != null)) {
        {
          // Find the module that owns this header (if any).
          Module /*P*/ Mod = findModuleForHeader(ExpansionFile).getModule();
          if ((Mod != null)) {
            return Mod;
          }
        }
        
        // No module owns this header, so look up the inclusion chain to see if
        // any included header has an associated module.
        SourceLocation IncludeLoc = SrcMgr.getIncludeLoc(/*NO_COPY*/ExpansionFileID);
        if (IncludeLoc.isInvalid()) {
          return null;
        }
        
        ExpansionFileID.$assignMove(SrcMgr.getFileID(/*NO_COPY*/IncludeLoc));
      }
    }
    
    return null;
  }

  
  /// \brief Sets the umbrella header of the given module to the given
  /// header.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::setUmbrellaHeader">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 759,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 771,
   FQN="clang::ModuleMap::setUmbrellaHeader", NM="_ZN5clang9ModuleMap17setUmbrellaHeaderEPNS_6ModuleEPKNS_9FileEntryEN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap17setUmbrellaHeaderEPNS_6ModuleEPKNS_9FileEntryEN4llvm5TwineE")
  //</editor-fold>
  public void setUmbrellaHeader(Module /*P*/ Mod, /*const*/ FileEntry /*P*/ UmbrellaHeader, 
                   Twine NameAsWritten) {
    Headers.$at_T1$C$R(UmbrellaHeader).push_back(new KnownHeader(Mod, ModuleHeaderRole.NormalHeader));
    Mod.Umbrella.$assign_T1$C$R(FileEntry /*P*/.class, UmbrellaHeader);
    Mod.UmbrellaAsWritten.$assignMove(NameAsWritten.str());
    UmbrellaDirs.$set(UmbrellaHeader.getDir(), Mod);
    
    // Notify callbacks that we just added a new header.
    for (/*const*/unique_ptr<ModuleMapCallbacks> /*&*/ Cb : Callbacks)  {
      Cb.$arrow().moduleMapAddUmbrellaHeader($AddrOf(SourceMgr.getFileManager()), UmbrellaHeader);
    }
  }

  
  /// \brief Sets the umbrella directory of the given module to the given
  /// directory.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::setUmbrellaDir">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 771,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 779,
   FQN="clang::ModuleMap::setUmbrellaDir", NM="_ZN5clang9ModuleMap14setUmbrellaDirEPNS_6ModuleEPKNS_14DirectoryEntryEN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap14setUmbrellaDirEPNS_6ModuleEPKNS_14DirectoryEntryEN4llvm5TwineE")
  //</editor-fold>
  public void setUmbrellaDir(Module /*P*/ Mod, /*const*/ DirectoryEntry /*P*/ UmbrellaDir, 
                Twine NameAsWritten) {
    Mod.Umbrella.$assign_T$C$R(DirectoryEntry /*P*/.class, UmbrellaDir);
    Mod.UmbrellaAsWritten.$assignMove(NameAsWritten.str());
    UmbrellaDirs.$set(UmbrellaDir, Mod);
  }

  
  /// \brief Adds this header to the given module.
  /// \param Role The role of the header wrt the module.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::addHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 792,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 800,
   FQN="clang::ModuleMap::addHeader", NM="_ZN5clang9ModuleMap9addHeaderEPNS_6ModuleENS1_6HeaderENS0_16ModuleHeaderRoleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap9addHeaderEPNS_6ModuleENS1_6HeaderENS0_16ModuleHeaderRoleEb")
  //</editor-fold>
  public void addHeader(Module /*P*/ Mod, Module.Header Header, 
           /*ModuleHeaderRole*//*uint*/int Role) {
    addHeader(Mod, Header, 
           Role, false);
  }
  public void addHeader(Module /*P*/ Mod, Module.Header Header, 
           /*ModuleHeaderRole*//*uint*/int Role, boolean Imported/*= false*/) {
    KnownHeader KH/*J*/= new KnownHeader(Mod, Role);
    
    // Only add each header to the headers list once.
    // FIXME: Should we diagnose if a header is listed twice in the
    // same module definition?
    SmallVector<KnownHeader> /*&*/ HeaderList = Headers.$at(Header.Entry);
    for (KnownHeader H : HeaderList)  {
      if ($eq_KnownHeader(H, KH)) {
        return;
      }
    }
    
    HeaderList.push_back(KH);
    Mod.Headers[headerRoleToKind(Role).getValue()].push_back_T$RR(std.move(Header));
    
    boolean isCompilingModuleHeader = LangOpts.CompilingModule && Mod.getTopLevelModule() == SourceModule;
    if (!Imported || isCompilingModuleHeader) {
      // When we import HeaderFileInfo, the external source is expected to
      // set the isModuleHeader flag itself.
      HeaderInfo.MarkFileModuleHeader(Header.Entry, Role, 
          isCompilingModuleHeader);
    }
    
    // Notify callbacks that we just added a new header.
    for (/*const*/unique_ptr<ModuleMapCallbacks> /*&*/ Cb : Callbacks)  {
      Cb.$arrow().moduleMapAddHeader(new StringRef(Header.Entry.getName()));
    }
  }

  
  /// \brief Marks this header as being excluded from the given module.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::excludeHeader">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 821,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 824,
   FQN="clang::ModuleMap::excludeHeader", NM="_ZN5clang9ModuleMap13excludeHeaderEPNS_6ModuleENS1_6HeaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap13excludeHeaderEPNS_6ModuleENS1_6HeaderE")
  //</editor-fold>
  public void excludeHeader(Module /*P*/ Mod, Module.Header Header) {
    // Add this as a known header so we won't implicitly add it to any
    // umbrella directory module.
    // FIXME: Should we only exclude it from umbrella modules within the
    // specified module?
    /*(void)*/Headers.$at(Header.Entry);
    
    Mod.Headers[Module.HeaderKind.HK_Excluded.getValue()].push_back_T$RR(std.move(Header));
  }

  
  /// \brief Parse the given module map file, and record any modules we 
  /// encounter.
  ///
  /// \param File The file to be parsed.
  ///
  /// \param IsSystem Whether this module map file is in a system header
  /// directory, and therefore should be considered a system module.
  ///
  /// \param HomeDir The directory in which relative paths within this module
  ///        map file will be resolved.
  ///
  /// \param ExternModuleLoc The location of the "extern module" declaration
  ///        that caused us to load this module map file, if any.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::parseModuleMapFile">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2440,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2433,
   FQN="clang::ModuleMap::parseModuleMapFile", NM="_ZN5clang9ModuleMap18parseModuleMapFileEPKNS_9FileEntryEbPKNS_14DirectoryEntryENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap18parseModuleMapFileEPKNS_9FileEntryEbPKNS_14DirectoryEntryENS_14SourceLocationE")
  //</editor-fold>
  public boolean parseModuleMapFile(/*const*/ FileEntry /*P*/ File, boolean IsSystem, 
                    /*const*/ DirectoryEntry /*P*/ Dir) {
    return parseModuleMapFile(File, IsSystem, 
                    Dir, 
                    new SourceLocation());
  }
  public boolean parseModuleMapFile(/*const*/ FileEntry /*P*/ File, boolean IsSystem, 
                    /*const*/ DirectoryEntry /*P*/ Dir, 
                    SourceLocation ExternModuleLoc/*= SourceLocation()*/) {
    Lexer L = null;
    ModuleMapParser Parser = null;
    try {
      DenseMapIteratorTypeBool</*const*/ FileEntry /*P*/> Known = ParsedModuleMap.find(File);
      if (Known.$noteq(/*NO_ITER_COPY*/ParsedModuleMap.end())) {
        return Known.$arrow().second;
      }
      assert ((Target != null)) : "Missing target information";
      CharacteristicKind FileCharacter = IsSystem ? SrcMgr.CharacteristicKind.C_System : SrcMgr.CharacteristicKind.C_User;
      /*FileID*/int ID = SourceMgr.createFileID(File, /*NO_COPY*/ExternModuleLoc.getRawEncoding(), FileCharacter);
      /*const*/ MemoryBuffer /*P*/ Buffer = SourceMgr.getBuffer(/*NO_COPY*/ID);
      if (!(Buffer != null)) {
        return ParsedModuleMap.$set(File, true);
      }
      
      // Parse this module map file.
      L/*J*/= new Lexer(/*NO_COPY*/ID, SourceMgr.getBuffer(/*NO_COPY*/ID), SourceMgr, MMapLangOpts);
      /*SourceLocation*/int Start = L.getCurCharSourceLocation();
      Parser/*J*/= new ModuleMapParser(L, SourceMgr, Target, Diags, /*Deref*/this, File, Dir, 
          BuiltinIncludeDir, IsSystem);
      boolean Result = Parser.parseModuleMapFile();
      ParsedModuleMap.$set(File, Result);
      
      // Notify callbacks that we parsed it.
      for (/*const*/unique_ptr<ModuleMapCallbacks> /*&*/ Cb : Callbacks)  {
        Cb.$arrow().moduleMapFileRead(/*NO_COPY*/SourceLocation.getFromRawEncoding(Start), $Deref(File), IsSystem);
      }
      return Result;
    } finally {
      if (Parser != null) { Parser.$destroy(); }
      if (L != null) { L.$destroy(); }
    }
  }

  
  /// \brief Dump the contents of the module map, for debugging purposes.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 853,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 856,
   FQN="clang::ModuleMap::dump", NM="_ZN5clang9ModuleMap4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang9ModuleMap4dumpEv")
  //</editor-fold>
  public void dump()/* __attribute__((used)) __attribute__((noinline))*/ {
    llvm.errs().$out(/*KEEP_STR*/"Modules:");
    for (StringMapIterator<Module /*P*//*, MallocAllocator*/> M = Modules.begin(), 
        MEnd = Modules.end();
         M.$noteq(MEnd); M.$preInc())  {
      M.$arrow().getValue().print(llvm.errs(), 2);
    }
    
    llvm.errs().$out(/*KEEP_STR*/"Headers:");
    for (DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector<KnownHeader> > H = Headers.begin(), HEnd = Headers.end();
         H.$noteq(/*NO_ITER_COPY*/HEnd); H.$preInc()) {
      llvm.errs().$out(/*KEEP_STR*/"  \"").$out(H.$arrow().first.getName()).$out(/*KEEP_STR*/"\" -> ");
      for (type$ptr<KnownHeader> I = H.$arrow().second.begin(), 
          E = H.$arrow().second.end();
           $noteq_iter(I, E); I.$preInc()) {
        if (I != H.$arrow().second.begin()) {
          llvm.errs().$out(/*KEEP_STR*/$COMMA);
        }
        llvm.errs().$out(I./*->*/$star().getModule().getFullModuleName());
      }
      llvm.errs().$out(/*KEEP_STR*/$LF);
    }
  }

  
  /*typedef llvm::StringMap<Module *>::const_iterator module_iterator*/
//  public final class module_iterator extends StringMapIterator<Module /*P*//*, MallocAllocator*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::module_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 528,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 509,
   FQN="clang::ModuleMap::module_begin", NM="_ZNK5clang9ModuleMap12module_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap12module_beginEv")
  //</editor-fold>
  public StringMapIterator<Module /*P*//*, MallocAllocator*/> module_begin() /*const*/ {
    return Modules.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMap::module_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", line = 529,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleMap.h", old_line = 510,
   FQN="clang::ModuleMap::module_end", NM="_ZNK5clang9ModuleMap10module_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang9ModuleMap10module_endEv")
  //</editor-fold>
  public StringMapIterator<Module /*P*//*, MallocAllocator*/> module_end() /*const*/ {
    return Modules.end();
  }

  
  public String toString() {
    return "" /* + STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diag=" + Diag // NOI18N*/
              + ", LangOpts=" + LangOpts // NOI18N
              + ", Target=" + Target // NOI18N
              + ", HeaderInfo=" + HeaderInfo // NOI18N
              + ", Callbacks=" + Callbacks // NOI18N
              + ", BuiltinIncludeDir=" + BuiltinIncludeDir // NOI18N
              + ", MMapLangOpts=" + MMapLangOpts // NOI18N
              + ", SourceModule=" + SourceModule // NOI18N
              + ", Modules=" + Modules // NOI18N
              + ", NumCreatedModules=" + NumCreatedModules // NOI18N
              + ", Headers=" + Headers // NOI18N
              + ", UmbrellaDirs=" + UmbrellaDirs // NOI18N
              + ", InferredDirectories=" + InferredDirectories // NOI18N
              + ", InferredModuleAllowedBy=" + InferredModuleAllowedBy // NOI18N
              + ", AdditionalModMaps=" + AdditionalModMaps // NOI18N
              + ", ParsedModuleMap=" + ParsedModuleMap; // NOI18N
  }
}
