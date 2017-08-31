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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.ir.mdconst.MdconstGlobals;
import org.llvm.support.sys.path;
import org.llvm.ir.impl.SymbolTableListTraits$Function.SymbolTableList$Function;
import org.llvm.ir.impl.SymbolTableListTraits$GlobalAlias.SymbolTableList$GlobalAlias;
import org.llvm.ir.impl.SymbolTableListTraits$GlobalIFunc.SymbolTableList$GlobalIFunc;
import org.llvm.ir.impl.SymbolTableListTraits$GlobalVariable.SymbolTableList$GlobalVariable;


/// A Module instance is used to store all the information related to an
/// LLVM module. Modules are the top level container of all other LLVM
/// Intermediate Representation (IR) objects. Each module directly contains a
/// list of globals variables, a list of functions, a list of libraries (or
/// other modules) this module depends on, a symbol table, and various data
/// about the target's characteristics.
///
/// A module maintains a GlobalValRefMap object that is used to hold all
/// constant references to global variables in the module.  When a global
/// variable is destroyed, it should have no entries in the GlobalValueRefMap.
/// @brief The main container class for the LLVM Intermediate Representation.
//<editor-fold defaultstate="collapsed" desc="llvm::Module">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 70,
 FQN="llvm::Module", NM="_ZN4llvm6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6ModuleE")
//</editor-fold>
public class Module implements Iterable<Function>, IValueSymbolTableProvider, Destructors.ClassWithDestructor {
/// @name Types And Enumerations
  /// @{
  /*public:*/
  /// The type for the list of global variables.
  // JAVA: typedef SymbolTableList<GlobalVariable> GlobalListType
//  public final class GlobalListType extends SymbolTableList<GlobalVariable, Module>{ };
  /// The type for the list of functions.
  // JAVA: typedef SymbolTableList<Function> FunctionListType
//  public final class FunctionListType extends SymbolTableList<Function, Module>{ };
  /// The type for the list of aliases.
  // JAVA: typedef SymbolTableList<GlobalAlias> AliasListType
//  public final class AliasListType extends SymbolTableList<GlobalAlias, Module>{ };
  /// The type for the list of ifuncs.
  // JAVA: typedef SymbolTableList<GlobalIFunc> IFuncListType
//  public final class IFuncListType extends SymbolTableList<GlobalIFunc, Module>{ };
  /// The type for the list of named metadata.
  // JAVA: typedef ilist<NamedMDNode> NamedMDListType
//  public final class NamedMDListType extends ilist<NamedMDNode>{ };
  /// The type of the comdat "symbol" table.
  // JAVA: typedef StringMap<Comdat> ComdatSymTabType
//  public final class ComdatSymTabType extends StringMap<Comdat>{ };
  
  /// The Global Variable iterator.
  // JAVA: typedef GlobalListType::iterator global_iterator
//  public final class global_iterator extends ilist_iterator<GlobalVariable>{ };
  /// The Global Variable constant iterator.
  // JAVA: typedef GlobalListType::const_iterator const_global_iterator
//  public final class const_global_iterator extends ilist_iterator</*const*/ GlobalVariable>{ };
  
  /// The Function iterators.
  // JAVA: typedef FunctionListType::iterator iterator
//  public final class iterator extends ilist_iterator<Function>{ };
  /// The Function constant iterator
  // JAVA: typedef FunctionListType::const_iterator const_iterator
//  public final class const_iterator extends ilist_iterator</*const*/ Function>{ };
  
  /// The Function reverse iterator.
  // JAVA: typedef FunctionListType::reverse_iterator reverse_iterator
//  public final class reverse_iterator extends std.reverse_iterator<Function>{ };
  /// The Function constant reverse iterator.
  // JAVA: typedef FunctionListType::const_reverse_iterator const_reverse_iterator
//  public final class const_reverse_iterator extends std.reverse_iterator</*const*/ Function>{ };
  
  /// The Global Alias iterators.
  // JAVA: typedef AliasListType::iterator alias_iterator
//  public final class alias_iterator extends ilist_iterator<GlobalAlias>{ };
  /// The Global Alias constant iterator
  // JAVA: typedef AliasListType::const_iterator const_alias_iterator
//  public final class const_alias_iterator extends ilist_iterator</*const*/ GlobalAlias>{ };
  
  /// The Global IFunc iterators.
  // JAVA: typedef IFuncListType::iterator ifunc_iterator
//  public final class ifunc_iterator extends ilist_iterator<GlobalIFunc>{ };
  /// The Global IFunc constant iterator
  // JAVA: typedef IFuncListType::const_iterator const_ifunc_iterator
//  public final class const_ifunc_iterator extends ilist_iterator</*const*/ GlobalIFunc>{ };
  
  /// The named metadata iterators.
  // JAVA: typedef NamedMDListType::iterator named_metadata_iterator
//  public final class named_metadata_iterator extends ilist_iterator<NamedMDNode>{ };
  /// The named metadata constant iterators.
  // JAVA: typedef NamedMDListType::const_iterator const_named_metadata_iterator
//  public final class const_named_metadata_iterator extends ilist_iterator</*const*/ NamedMDNode>{ };
  
  /// This enumeration defines the supported behaviors of module flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ModFlagBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 118,
   FQN="llvm::Module::ModFlagBehavior", NM="_ZN4llvm6Module15ModFlagBehaviorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module15ModFlagBehaviorE")
  //</editor-fold>
  public enum ModFlagBehavior implements Native.NativeUIntEnum {
    /// Emits an error if two values disagree, otherwise the resulting value is
    /// that of the operands.
    Error(1),
    
    /// Emits a warning if two values disagree. The result value will be the
    /// operand for the flag from the first module being linked.
    Warning(2),
    
    /// Adds a requirement that another module flag be present and have a
    /// specified value after linking is performed. The value must be a metadata
    /// pair, where the first element of the pair is the ID of the module flag
    /// to be restricted, and the second element of the pair is the value the
    /// module flag should be restricted to. This behavior can be used to
    /// restrict the allowable results (via triggering of an error) of linking
    /// IDs with the **Override** behavior.
    Require(3),
    
    /// Uses the specified value, regardless of the behavior or value of the
    /// other module. If both modules specify **Override**, but the values
    /// differ, an error will be emitted.
    Override(4),
    
    /// Appends the two values, which are required to be metadata nodes.
    Append(5),
    
    /// Appends the two values, which are required to be metadata
    /// nodes. However, duplicate entries in the second list are dropped
    /// during the append operation.
    AppendUnique(6),
    
    // Markers:
    ModFlagBehaviorFirstVal(ModFlagBehavior.Error.getValue()),
    ModFlagBehaviorLastVal(ModFlagBehavior.AppendUnique.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ModFlagBehavior valueOf(int val) {
      ModFlagBehavior out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ModFlagBehavior[] VALUES;
      private static final ModFlagBehavior[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ModFlagBehavior kind : ModFlagBehavior.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ModFlagBehavior[min < 0 ? (1-min) : 0];
        VALUES = new ModFlagBehavior[max >= 0 ? (1+max) : 0];
        for (ModFlagBehavior kind : ModFlagBehavior.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ModFlagBehavior(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Checks if Metadata represents a valid ModFlagBehavior, and stores the
  /// converted result in MFB.
  
  /// Checks if Metadata represents a valid ModFlagBehavior, and stores the
  /// converted result in MFB.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::isValidModFlagBehavior">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 290,
   FQN="llvm::Module::isValidModFlagBehavior", NM="_ZN4llvm6Module22isValidModFlagBehaviorEPNS_8MetadataERNS0_15ModFlagBehaviorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module22isValidModFlagBehaviorEPNS_8MetadataERNS0_15ModFlagBehaviorE")
  //</editor-fold>
  public static boolean isValidModFlagBehavior(Metadata /*P*/ MD, final type$ref<ModFlagBehavior /*&*/> MFB) {
    {
      ConstantInt /*P*/ Behavior = MdconstGlobals.dyn_extract_or_null$ValidReference(ConstantInt.class, MD);
      if ((Behavior != null)) {
        long/*uint64_t*/ Val = Behavior.getLimitedValue();
        if ($greatereq_ulong_uint(Val, ModFlagBehavior.ModFlagBehaviorFirstVal.getValue()) && $lesseq_ulong_uint(Val, ModFlagBehavior.ModFlagBehaviorLastVal.getValue())) {
          MFB.$set(/*static_cast*/ModFlagBehavior.valueOf($ulong2uint(Val)));
          return true;
        }
      }
    }
    return false;
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ModuleFlagEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 158,
   FQN="llvm::Module::ModuleFlagEntry", NM="_ZN4llvm6Module15ModuleFlagEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module15ModuleFlagEntryE")
  //</editor-fold>
  public static class/*struct*/ ModuleFlagEntry implements NativeCloneable<ModuleFlagEntry> {
    public ModFlagBehavior Behavior;
    public MDString /*P*/ Key;
    public Metadata /*P*/ Val;
    //<editor-fold defaultstate="collapsed" desc="llvm::Module::ModuleFlagEntry::ModuleFlagEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 162,
     FQN="llvm::Module::ModuleFlagEntry::ModuleFlagEntry", NM="_ZN4llvm6Module15ModuleFlagEntryC1ENS0_15ModFlagBehaviorEPNS_8MDStringEPNS_8MetadataE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module15ModuleFlagEntryC1ENS0_15ModFlagBehaviorEPNS_8MDStringEPNS_8MetadataE")
    //</editor-fold>
    public ModuleFlagEntry(ModFlagBehavior B, MDString /*P*/ K, Metadata /*P*/ V) {
      // : Behavior(B), Key(K), Val(V) 
      //START JInit
      this.Behavior = B;
      this.Key = K;
      this.Val = V;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public ModuleFlagEntry() {
      this.Behavior = ModFlagBehavior.Error;
      this.Key = null;
      this.Val = null;      
    }

    @Override public ModuleFlagEntry clone() {
      return new ModuleFlagEntry(this.Behavior, this.Key, this.Val);
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Behavior=" + Behavior // NOI18N
                + ", Key=" + Key // NOI18N
                + ", Val=" + Val; // NOI18N
    }
  };

  /// @}
  /// @name Member Variables
  /// @{
  /*private:*/
  private final LLVMContext /*&*/ Context; ///< The LLVMContext from which types and
  ///< constants are allocated.
  private final SymbolTableList<GlobalVariable, Module> GlobalList; ///< The Global Variables in the module
  private final SymbolTableList<Function, Module> FunctionList; ///< The Functions in the module
  private final SymbolTableList<GlobalAlias, Module> AliasList; ///< The Aliases in the module
  private final SymbolTableList<GlobalIFunc, Module> IFuncList; ///< The IFuncs in the module
  private ilist<NamedMDNode> NamedMDList; ///< The named metadata in the module
  private std.string GlobalScopeAsm; ///< Inline Asm at global scope.
  private ValueSymbolTable /*P*/ ValSymTab; ///< Symbol table for values
  private StringMap<Comdat> ComdatSymTab; ///< Symbol table for COMDATs
  private std.unique_ptr<GVMaterializer> Materializer; ///< Used to materialize GlobalValues
  private std.string ModuleID; ///< Human readable identifier for the module
  private std.string SourceFileName; ///< Original source file name for module,
  ///< recorded in bitcode.
  private std.string TargetTriple; ///< Platform target triple Module compiled on
  ///< Format: (arch)(sub)-(vendor)-(sys0-(abi)
  private Object/*void P*/ NamedMDSymTab; ///< NamedMDNode names.
  private DataLayout DL; ///< DataLayout associated with the module
  
  /*friend  class Constant*/

  /// @}
  /// @name Constructors
  /// @{
  /*public:*/
  /// The Module constructor. Note that there is no default constructor. You
  /// must provide a name for the module upon construction.
  /// The Module constructor. Note that there is no default constructor. You
  /// must provide a name for the module upon construction.
  
  //===----------------------------------------------------------------------===//
  // Primitive Module methods.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::Module">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 51,
   FQN="llvm::Module::Module", NM="_ZN4llvm6ModuleC1ENS_9StringRefERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6ModuleC1ENS_9StringRefERNS_11LLVMContextE")
  //</editor-fold>
  public Module(StringRef MID, final LLVMContext /*&*/ C) {
    // : Context(C), GlobalList(), FunctionList(), AliasList(), IFuncList(), NamedMDList(), GlobalScopeAsm(), ComdatSymTab(), Materializer(), ModuleID(MID.operator basic_string()), SourceFileName(MID.operator basic_string()), TargetTriple(), DL("") 
    //START JInit
    this./*&*/Context=/*&*/C;
    this.GlobalList = new SymbolTableList$GlobalVariable(this);
    this.FunctionList = new SymbolTableList$Function(this);
    this.AliasList = new SymbolTableList$GlobalAlias(this);
    this.IFuncList = new SymbolTableList$GlobalIFunc(this);
    this.NamedMDList = new ilist<NamedMDNode>() {
      @Override
      protected ilist_traits<NamedMDNode> $createTraits() {
        return new ilist_traitsNamedMDNode();
      }      
    };
    this.GlobalScopeAsm = new std.string();
    this.ComdatSymTab = new StringMap<Comdat>(new Comdat());
    this.Materializer = new std.unique_ptr<GVMaterializer>();
    this.ModuleID = MID.$string();
    this.SourceFileName = MID.$string();
    this.TargetTriple = new std.string();
    this.DL = new DataLayout(new StringRef(/*KEEP_STR*/$EMPTY));
    //END JInit
    ValSymTab = new ValueSymbolTable();
    NamedMDSymTab = new StringMap<NamedMDNode /*P*/ >((NamedMDNode /*P*/ )null);
    Context.addModule(this);
  }


  /// The module destructor. This will dropAllReferences.
  /// The module destructor. This will dropAllReferences.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::~Module">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 58,
   FQN="llvm::Module::~Module", NM="_ZN4llvm6ModuleD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6ModuleD0Ev")
  //</editor-fold>
  public void $destroy() {
    Context.removeModule(this);
    dropAllReferences();
    GlobalList.clear();
    FunctionList.clear();
    AliasList.clear();
    IFuncList.clear();
    NamedMDList.clear();
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)ValSymTab);
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)((/*static_cast*/StringMap<NamedMDNode /*P*/ > /*P*/)(NamedMDSymTab)));
    //START JDestroy
    DL.$destroy();
    TargetTriple.$destroy();
    SourceFileName.$destroy();
    ModuleID.$destroy();
    Materializer.$destroy();
    ComdatSymTab.$destroy();
    GlobalScopeAsm.$destroy();
    NamedMDList.$destroy();
    IFuncList.$destroy();
    AliasList.$destroy();
    FunctionList.$destroy();
    GlobalList.$destroy();
    //END JDestroy
  }


  
  /// @}
  /// @name Module Level Accessors
  /// @{
  
  /// Get the module identifier which is, essentially, the name of the module.
  /// @returns the module identifier as a string
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getModuleIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 208,
   FQN="llvm::Module::getModuleIdentifier", NM="_ZNK4llvm6Module19getModuleIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module19getModuleIdentifierEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getModuleIdentifier() /*const*/ {
    return ModuleID;
  }

  
  /// Get the module's original source file name. When compiling from
  /// bitcode, this is taken from a bitcode record where it was recorded.
  /// For other compiles it is the same as the ModuleID, which would
  /// contain the source file name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getSourceFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 214,
   FQN="llvm::Module::getSourceFileName", NM="_ZNK4llvm6Module17getSourceFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module17getSourceFileNameEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getSourceFileName() /*const*/ {
    return SourceFileName;
  }

  
  /// \brief Get a short "name" for the module.
  ///
  /// This is useful for debugging or logging. It is essentially a convenience
  /// wrapper around getModuleIdentifier().
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 220,
   FQN="llvm::Module::getName", NM="_ZNK4llvm6Module7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(ModuleID);
  }

  
  /// Get the data layout string for the module's target platform. This is
  /// equivalent to getDataLayout()->getStringRepresentation().
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getDataLayoutStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 224,
   FQN="llvm::Module::getDataLayoutStr", NM="_ZNK4llvm6Module16getDataLayoutStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module16getDataLayoutStrEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getDataLayoutStr() /*const*/ {
    return DL.getStringRepresentation();
  }

  
  /// Get the data layout for the module's target platform.
  
  /// Get the data layout for the module's target platform.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 382,
   FQN="llvm::Module::getDataLayout", NM="_ZNK4llvm6Module13getDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module13getDataLayoutEv")
  //</editor-fold>
  public /*const*/ DataLayout /*&*/ getDataLayout() /*const*/ {
    return DL;
  }


  
  /// Get the target triple which is a string describing the target host.
  /// @returns a string containing the target triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getTargetTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 233,
   FQN="llvm::Module::getTargetTriple", NM="_ZNK4llvm6Module15getTargetTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module15getTargetTripleEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getTargetTriple() /*const*/ {
    return TargetTriple;
  }

  
  /// Get the global data context.
  /// @returns LLVMContext - a container for LLVM's global information
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 237,
   FQN="llvm::Module::getContext", NM="_ZNK4llvm6Module10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return Context;
  }

  
  /// Get any module-scope inline assembly blocks.
  /// @returns a string containing the module-scope inline assembly blocks.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getModuleInlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 241,
   FQN="llvm::Module::getModuleInlineAsm", NM="_ZNK4llvm6Module18getModuleInlineAsmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module18getModuleInlineAsmEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getModuleInlineAsm() /*const*/ {
    return GlobalScopeAsm;
  }

  
  /// Get a RandomNumberGenerator salted for use with this module. The
  /// RNG can be seeded via -rng-seed=<uint64> and is salted with the
  /// ModuleID and the provided pass salt. The returned RNG should not
  /// be shared across threads or passes.
  ///
  /// A unique RNG per pass ensures a reproducible random stream even
  /// when other randomness consuming passes are added or removed. In
  /// addition, the random stream will be reproducible across LLVM
  /// versions when the pass does not change.
  
  /// Get a RandomNumberGenerator salted for use with this module. The
  /// RNG can be seeded via -rng-seed=<uint64> and is salted with the
  /// ModuleID and the provided pass salt. The returned RNG should not
  /// be shared across threads or passes.
  ///
  /// A unique RNG per pass ensures a reproducible random stream even
  /// when other randomness consuming passes are added or removed. In
  /// addition, the random stream will be reproducible across LLVM
  /// versions when the pass does not change.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::createRNG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 70,
   FQN="llvm::Module::createRNG", NM="_ZNK4llvm6Module9createRNGEPKNS_4PassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module9createRNGEPKNS_4PassE")
  //</editor-fold>
  public RandomNumberGenerator /*P*/ createRNG(/*const*/ Pass /*P*/ P) /*const*/ {
    SmallString/*<32>*/ Salt/*J*/= new SmallString/*<32>*/(32, new StringRef(P.getPassName()));
    
    // This RNG is guaranteed to produce the same random stream only
    // when the Module ID and thus the input filename is the same. This
    // might be problematic if the input filename extension changes
    // (e.g. from .c to .bc or .ll).
    //
    // We could store this salt in NamedMetadata, but this would make
    // the parameter non-const. This would unfortunately make this
    // interface unusable by any Machine passes, since they only have a
    // const reference to their IR Module. Alternatively we can always
    // store salt metadata from the Module constructor.
    Salt.$addassign(path.filename(new StringRef(getModuleIdentifier())));
    
    return new RandomNumberGenerator(Salt.$StringRef());
  }


  
  /// @}
  /// @name Module Level Mutators
  /// @{
  
  /// Set the module identifier.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setModuleIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 259,
   FQN="llvm::Module::setModuleIdentifier", NM="_ZN4llvm6Module19setModuleIdentifierENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module19setModuleIdentifierENS_9StringRefE")
  //</editor-fold>
  public void setModuleIdentifier(StringRef ID) {
    ModuleID.$assignMove(ID.$string());
  }

  
  /// Set the module's original source file name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setSourceFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 262,
   FQN="llvm::Module::setSourceFileName", NM="_ZN4llvm6Module17setSourceFileNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module17setSourceFileNameENS_9StringRefE")
  //</editor-fold>
  public void setSourceFileName(StringRef Name) {
    SourceFileName.$assignMove(Name.$string());
  }

  
  /// Set the data layout
  
  /// Set the data layout
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 376,
   FQN="llvm::Module::setDataLayout", NM="_ZN4llvm6Module13setDataLayoutENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module13setDataLayoutENS_9StringRefE")
  //</editor-fold>
  public void setDataLayout(StringRef Desc) {
    DL.reset(new StringRef(Desc));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 380,
   FQN="llvm::Module::setDataLayout", NM="_ZN4llvm6Module13setDataLayoutERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module13setDataLayoutERKNS_10DataLayoutE")
  //</editor-fold>
  public void setDataLayout(final /*const*/ DataLayout /*&*/ Other) {
    DL.$assign(Other);
  }


  
  /// Set the target triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setTargetTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 269,
   FQN="llvm::Module::setTargetTriple", NM="_ZN4llvm6Module15setTargetTripleENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module15setTargetTripleENS_9StringRefE")
  //</editor-fold>
  public void setTargetTriple(StringRef T) {
    TargetTriple.$assignMove(T.$string());
  }

  
  /// Set the module-scope inline assembly blocks.
  /// A trailing newline is added if the input doesn't have one.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setModuleInlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 273,
   FQN="llvm::Module::setModuleInlineAsm", NM="_ZN4llvm6Module18setModuleInlineAsmENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module18setModuleInlineAsmENS_9StringRefE")
  //</editor-fold>
  public void setModuleInlineAsm(StringRef Asm) {
    GlobalScopeAsm.$assignMove(Asm.$string());
    if (!GlobalScopeAsm.empty() && GlobalScopeAsm.back() != $$LF) {
      GlobalScopeAsm.$addassign_T($$LF);
    }
  }

  
  /// Append to the module-scope inline assembly blocks.
  /// A trailing newline is added if the input doesn't have one.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::appendModuleInlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 281,
   FQN="llvm::Module::appendModuleInlineAsm", NM="_ZN4llvm6Module21appendModuleInlineAsmENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module21appendModuleInlineAsmENS_9StringRefE")
  //</editor-fold>
  public void appendModuleInlineAsm(StringRef Asm) {
    $addassign_string_StringRef(GlobalScopeAsm, /*NO_COPY*/Asm);
    if (!GlobalScopeAsm.empty() && GlobalScopeAsm.back() != $$LF) {
      GlobalScopeAsm.$addassign_T($$LF);
    }
  }

  
  /// @}
  /// @name Generic Value Accessors
  /// @{
  
  /// Return the global value in the module with the specified name, of
  /// arbitrary type. This method returns null if a global with the specified
  /// name is not found.
  
  /// @}
  /// @name Generic Value Accessors
  /// @{
  
  /// Return the global value in the module with the specified name, of
  /// arbitrary type. This method returns null if a global with the specified
  /// name is not found.
  
  /// getNamedValue - Return the first global value in the module with
  /// the specified name, of arbitrary type.  This method returns null
  /// if a global with the specified name is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 91,
   FQN="llvm::Module::getNamedValue", NM="_ZNK4llvm6Module13getNamedValueENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module13getNamedValueENS_9StringRefE")
  //</editor-fold>
  public GlobalValue /*P*/ getNamedValue(StringRef Name) /*const*/ {
    return cast_or_null_GlobalValue(getValueSymbolTable$Const().lookup(new StringRef(Name)));
  }


  
  /// Return a unique non-zero ID for the specified metadata kind. This ID is
  /// uniqued across modules in the current LLVMContext.
  
  /// Return a unique non-zero ID for the specified metadata kind. This ID is
  /// uniqued across modules in the current LLVMContext.
  
  /// getMDKindID - Return a unique non-zero ID for the specified metadata kind.
  /// This ID is uniqued across modules in the current LLVMContext.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getMDKindID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 97,
   FQN="llvm::Module::getMDKindID", NM="_ZNK4llvm6Module11getMDKindIDENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module11getMDKindIDENS_9StringRefE")
  //</editor-fold>
  public /*uint*/int getMDKindID(StringRef Name) /*const*/ {
    return Context.getMDKindID(new StringRef(Name));
  }


  
  /// Populate client supplied SmallVector with the name for custom metadata IDs
  /// registered in this LLVMContext.
  
  /// Populate client supplied SmallVector with the name for custom metadata IDs
  /// registered in this LLVMContext.
  
  /// getMDKindNames - Populate client supplied SmallVector with the name for
  /// custom metadata IDs registered in this LLVMContext.   ID #0 is not used,
  /// so it is filled in as an empty string.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getMDKindNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 104,
   FQN="llvm::Module::getMDKindNames", NM="_ZNK4llvm6Module14getMDKindNamesERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module14getMDKindNamesERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public void getMDKindNames(final SmallVectorImpl<StringRef> /*&*/ Result) /*const*/ {
    Context.getMDKindNames(Result);
    /*JAVA:return*/return;
  }


  
  /// Populate client supplied SmallVector with the bundle tags registered in
  /// this LLVMContext.  The bundle tags are ordered by increasing bundle IDs.
  /// \see LLVMContext::getOperandBundleTagID
  
  /// Populate client supplied SmallVector with the bundle tags registered in
  /// this LLVMContext.  The bundle tags are ordered by increasing bundle IDs.
  /// \see LLVMContext::getOperandBundleTagID
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOperandBundleTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 108,
   FQN="llvm::Module::getOperandBundleTags", NM="_ZNK4llvm6Module20getOperandBundleTagsERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module20getOperandBundleTagsERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public void getOperandBundleTags(final SmallVectorImpl<StringRef> /*&*/ Result) /*const*/ {
    Context.getOperandBundleTags(Result);
    /*JAVA:return*/return;
  }


  
  /// Return the type with the specified name, or null if there is none by that
  /// name.
  
  /// Return the type with the specified name, or null if there is none by that
  /// name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getTypeByName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 545,
   FQN="llvm::Module::getTypeByName", NM="_ZNK4llvm6Module13getTypeByNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm6Module13getTypeByNameENS_9StringRefE")
  //</editor-fold>
  public StructType /*P*/ getTypeByName(StringRef Name) /*const*/ {
    return getContext().pImpl.NamedStructTypes.lookup(new StringRef(Name));
  }


  
  //===----------------------------------------------------------------------===//
  // Other module related stuff.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getIdentifiedStructTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 431,
   FQN="llvm::Module::getIdentifiedStructTypes", NM="_ZNK4llvm6Module24getIdentifiedStructTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module24getIdentifiedStructTypesEv")
  //</editor-fold>
  public std.vector<StructType /*P*/ > getIdentifiedStructTypes() /*const*/ {
    std.vector<StructType /*P*/ > Ret = null;
    TypeFinder SrcStructTypes = null;
    try {
      // If we have a materializer, it is possible that some unread function
      // uses a type that is currently not visible to a TypeFinder, so ask
      // the materializer which types it created.
      if (Materializer.$bool()) {
        return Materializer.$arrow().getIdentifiedStructTypes();
      }
      
      Ret/*J*/= new std.vector<StructType /*P*/ >((StructType /*P*/ )null);
      SrcStructTypes/*J*/= new TypeFinder();
      SrcStructTypes.run(/*Deref*/this, true);
      Ret.assign$T(SrcStructTypes.begin(), SrcStructTypes.end());
      return new std.vector<StructType /*P*/ >(JD$Move.INSTANCE, Ret);
    } finally {
      if (SrcStructTypes != null) { SrcStructTypes.$destroy(); }
      if (Ret != null) { Ret.$destroy(); }
    }
  }


  
  /// @}
  /// @name Function Accessors
  /// @{
  
  /// Look up the specified function in the module symbol table. Four
  /// possibilities:
  ///   1. If it does not exist, add a prototype for the function and return it.
  ///   2. If it exists, and has a local linkage, the existing function is
  ///      renamed and a new one is inserted.
  ///   3. Otherwise, if the existing function has the correct prototype, return
  ///      the existing function.
  ///   4. Finally, the function exists but has the wrong prototype: return the
  ///      function with a constantexpr cast to the right prototype.
  
  /// @}
  /// @name Function Accessors
  /// @{
  
  /// Look up the specified function in the module symbol table. Four
  /// possibilities:
  ///   1. If it does not exist, add a prototype for the function and return it.
  ///   2. If it exists, and has a local linkage, the existing function is
  ///      renamed and a new one is inserted.
  ///   3. Otherwise, if the existing function has the correct prototype, return
  ///      the existing function.
  ///   4. Finally, the function exists but has the wrong prototype: return the
  ///      function with a constantexpr cast to the right prototype.
  
  //===----------------------------------------------------------------------===//
  // Methods for easy access to the functions in the module.
  //
  
  // getOrInsertFunction - Look up the specified function in the module symbol
  // table.  If it does not exist, add a prototype for the function and return
  // it.  This is nice because it allows most passes to get away with not handling
  // the symbol table directly for this common task.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 121,
   FQN="llvm::Module::getOrInsertFunction", NM="_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefEPNS_12FunctionTypeENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefEPNS_12FunctionTypeENS_12AttributeSetE")
  //</editor-fold>
  public Constant /*P*/ getOrInsertFunction(StringRef Name, 
                     FunctionType /*P*/ Ty, 
                     AttributeSet AttributeList) {
    // See if we have a definition for the specified function already.
    GlobalValue /*P*/ F = getNamedValue(new StringRef(Name));
    if (!(F != null)) {
      // Nope, add it
      Function /*P*/ New = Function.Create(Ty, GlobalVariable.LinkageTypes.ExternalLinkage, new Twine(Name));
      if (!New.isIntrinsic()) { // Intrinsics get attrs set on construction
        New.setAttributes(new AttributeSet(AttributeList));
      }
      FunctionList.push_back(New);
      return New; // Return the new prototype.
    }
    
    // If the function exists but has the wrong type, return a bitcast to the
    // right type.
    if (F.getType() != PointerType.getUnqual(Ty)) {
      return ConstantExpr.getBitCast(F, PointerType.getUnqual(Ty));
    }
    
    // Otherwise, we just found the existing function or a prototype.
    return F;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 144,
   FQN="llvm::Module::getOrInsertFunction", NM="_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefEPNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefEPNS_12FunctionTypeE")
  //</editor-fold>
  public Constant /*P*/ getOrInsertFunction(StringRef Name, 
                     FunctionType /*P*/ Ty) {
    return getOrInsertFunction(new StringRef(Name), Ty, new AttributeSet());
  }


  
  /// Look up the specified function in the module symbol table. If it does not
  /// exist, add a prototype for the function and return it. This function
  /// guarantees to return a constant of pointer to the specified function type
  /// or a ConstantExpr BitCast of that type if the named function has a
  /// different type. This version of the method takes a null terminated list of
  /// function arguments, which makes it easier for clients to use.
  
  /// Look up the specified function in the module symbol table. If it does not
  /// exist, add a prototype for the function and return it. This function
  /// guarantees to return a constant of pointer to the specified function type
  /// or a ConstantExpr BitCast of that type if the named function has a
  /// different type. This version of the method takes a null terminated list of
  /// function arguments, which makes it easier for clients to use.
  
  // getOrInsertFunction - Look up the specified function in the module symbol
  // table.  If it does not exist, add a prototype for the function and return it.
  // This version of the method takes a null terminated list of function
  // arguments, which makes it easier for clients to use.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 154,
   FQN="llvm::Module::getOrInsertFunction", NM="_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefENS_12AttributeSetEPNS_4TypeEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefENS_12AttributeSetEPNS_4TypeEz")
  //</editor-fold>
  public Constant /*P*/ getOrInsertFunction(StringRef Name, 
                     AttributeSet AttributeList, 
                     Type /*P*/ RetTy, Type ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
    std.vector<Type /*P*/ > ArgTys = null;
    try {
      // Build the list of argument types...
      ArgTys/*J*/= new std.vector<Type /*P*/ >((Type /*P*/ )null);
      if (false) {
//        char$ptr/*char P*/ Args = create_char$ptr();
//        __builtin_va_start(Args, RetTy);
//
//        {
//          Type /*P*/ ArgTy;
//          while (((/*P*/ ArgTy = __builtin_va_arg(Args, Type /*P*/ .class)) != null)) {
//            ArgTys.push_back_T$C$R(ArgTy);
//          }
//        }
//        __builtin_va_end(Args);
      } else {
        // JAVA: 
        if ($VarArg != null) {
          for (Type ArgTy : $VarArg) {
            if (ArgTy != null) {
              ArgTys.push_back_T$C$R(ArgTy);
            }
          }
        }        
      }
      
      // Build the function type and chain to the other getOrInsertFunction...
      return getOrInsertFunction(new StringRef(Name), 
          FunctionType.get(RetTy, new ArrayRef<Type /*P*/ >(ArgTys, true), false), 
          new AttributeSet(AttributeList));
    } finally {
      if (ArgTys != null) { ArgTys.$destroy(); }
    }
  }


  
  /// Same as above, but without the attributes.
  
  /// Same as above, but without the attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 173,
   FQN="llvm::Module::getOrInsertFunction", NM="_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefEPNS_4TypeEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module19getOrInsertFunctionENS_9StringRefEPNS_4TypeEz")
  //</editor-fold>
  public Constant /*P*/ getOrInsertFunction(StringRef Name, 
                     Type /*P*/ RetTy, Type ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
    std.vector<Type /*P*/ > ArgTys = null;
    try {
      // Build the list of argument types...
      ArgTys/*J*/= new std.vector<Type /*P*/ >((Type /*P*/ )null);
      if (false) {
//        char$ptr/*char P*/ Args = create_char$ptr();
//        __builtin_va_start(Args, RetTy);
//
//        {
//          Type /*P*/ ArgTy;
//          while (((/*P*/ ArgTy = __builtin_va_arg(Args, Type /*P*/ .class)) != null)) {
//            ArgTys.push_back_T$C$R(ArgTy);
//          }
//        }
//        __builtin_va_end(Args);
      } else {
        // JAVA: 
        if ($VarArg != null) {
          for (Type ArgTy : $VarArg) {
            if (ArgTy != null) {
              ArgTys.push_back_T$C$R(ArgTy);
            }
          }
        }        
      }
      // Build the function type and chain to the other getOrInsertFunction...
      return getOrInsertFunction(new StringRef(Name), 
          FunctionType.get(RetTy, new ArrayRef<Type /*P*/ >(ArgTys, true), false), 
          new AttributeSet());
    } finally {
      if (ArgTys != null) { ArgTys.$destroy(); }
    }
  }


  
  /// Look up the specified function in the module symbol table. If it does not
  /// exist, return null.
  
  /// Look up the specified function in the module symbol table. If it does not
  /// exist, return null.
  
  // getFunction - Look up the specified function in the module symbol table.
  // If it does not exist, return null.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 194,
   FQN="llvm::Module::getFunction", NM="_ZNK4llvm6Module11getFunctionENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module11getFunctionENS_9StringRefE")
  //</editor-fold>
  public Function /*P*/ getFunction(StringRef Name) /*const*/ {
    return dyn_cast_or_null_Function(getNamedValue(new StringRef(Name)));
  }


  
  /// @}
  /// @name Global Variable Accessors
  /// @{
  
  /// Look up the specified global variable in the module symbol table. If it
  /// does not exist, return null. If AllowInternal is set to true, this
  /// function will return types that have InternalLinkage. By default, these
  /// types are not returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 359,
   FQN="llvm::Module::getGlobalVariable", NM="_ZNK4llvm6Module17getGlobalVariableENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module17getGlobalVariableENS_9StringRefE")
  //</editor-fold>
  public GlobalVariable /*P*/ getGlobalVariable$Const(StringRef Name) /*const*/ {
    return getGlobalVariable$Const(new StringRef(Name), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 363,
   FQN="llvm::Module::getGlobalVariable", NM="_ZNK4llvm6Module17getGlobalVariableENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module17getGlobalVariableENS_9StringRefEb")
  //</editor-fold>
  public GlobalVariable /*P*/ getGlobalVariable$Const(StringRef Name, boolean AllowInternal) /*const*/ {
    return ((/*const_cast*/Module /*P*/ )(this)).getGlobalVariable(new StringRef(Name), AllowInternal);
  }

  
  //===----------------------------------------------------------------------===//
  // Methods for easy access to the global variables in the module.
  //
  
  /// getGlobalVariable - Look up the specified global variable in the module
  /// symbol table.  If it does not exist, return null.  The type argument
  /// should be the underlying type of the global, i.e., it should not have
  /// the top-level PointerType, which represents the address of the global.
  /// If AllowLocal is set to true, this function will return types that
  /// have an local. By default, these types are not returned.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getGlobalVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 209,
   FQN="llvm::Module::getGlobalVariable", NM="_ZN4llvm6Module17getGlobalVariableENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module17getGlobalVariableENS_9StringRefEb")
  //</editor-fold>
  public GlobalVariable /*P*/ getGlobalVariable(StringRef Name) {
    return getGlobalVariable(Name, false);
  }
  public GlobalVariable /*P*/ getGlobalVariable(StringRef Name, boolean AllowLocal/*= false*/) {
    {
      GlobalVariable /*P*/ Result = dyn_cast_or_null_GlobalVariable(getNamedValue(new StringRef(Name)));
      if ((Result != null)) {
        if (AllowLocal || !Result.hasLocalLinkage()) {
          return Result;
        }
      }
    }
    return null;
  }


  
  /// Return the global variable in the module with the specified name, of
  /// arbitrary type. This method returns null if a global with the specified
  /// name is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 372,
   FQN="llvm::Module::getNamedGlobal", NM="_ZN4llvm6Module14getNamedGlobalENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module14getNamedGlobalENS_9StringRefE")
  //</editor-fold>
  public GlobalVariable /*P*/ getNamedGlobal(StringRef Name) {
    return getGlobalVariable(new StringRef(Name), true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 375,
   FQN="llvm::Module::getNamedGlobal", NM="_ZNK4llvm6Module14getNamedGlobalENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module14getNamedGlobalENS_9StringRefE")
  //</editor-fold>
  public /*const*/ GlobalVariable /*P*/ getNamedGlobal$Const(StringRef Name) /*const*/ {
    return ((/*const_cast*/Module /*P*/ )(this)).getNamedGlobal(new StringRef(Name));
  }

  
  /// Look up the specified global in the module symbol table.
  ///   1. If it does not exist, add a declaration of the global and return it.
  ///   2. Else, the global exists but has the wrong type: return the function
  ///      with a constantexpr cast to the right type.
  ///   3. Finally, if the existing global is the correct declaration, return
  ///      the existing global.
  
  /// Look up the specified global in the module symbol table.
  ///   1. If it does not exist, add a declaration of the global and return it.
  ///   2. Else, the global exists but has the wrong type: return the function
  ///      with a constantexpr cast to the right type.
  ///   3. Finally, if the existing global is the correct declaration, return
  ///      the existing global.
  
  /// getOrInsertGlobal - Look up the specified global in the module symbol table.
  ///   1. If it does not exist, add a declaration of the global and return it.
  ///   2. Else, the global exists but has the wrong type: return the function
  ///      with a constantexpr cast to the right type.
  ///   3. Finally, if the existing global is the correct declaration, return the
  ///      existing global.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 223,
   FQN="llvm::Module::getOrInsertGlobal", NM="_ZN4llvm6Module17getOrInsertGlobalENS_9StringRefEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module17getOrInsertGlobalENS_9StringRefEPNS_4TypeE")
  //</editor-fold>
  public Constant /*P*/ getOrInsertGlobal(StringRef Name, Type /*P*/ Ty) {
    // See if we have a definition for the specified global already.
    GlobalVariable /*P*/ GV = dyn_cast_or_null_GlobalVariable(getNamedValue(new StringRef(Name)));
    if (!(GV != null)) {
      // Nope, add it
      GlobalVariable /*P*/ New = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(/*Deref*/this, Ty, false, GlobalVariable.LinkageTypes.ExternalLinkage, 
                  (Constant /*P*/ )null, new Twine(Name));
       });
      return New; // Return the new declaration.
    }
    
    // If the variable exists but has the wrong type, return a bitcast to the
    // right type.
    Type /*P*/ GVTy = GV.getType();
    PointerType /*P*/ PTy = PointerType.get(Ty, GVTy.getPointerAddressSpace());
    if (GVTy != PTy) {
      return ConstantExpr.getBitCast(GV, PTy);
    }
    
    // Otherwise, we just found the existing function or a prototype.
    return GV;
  }


  
  /// @}
  /// @name Global Alias Accessors
  /// @{
  
  /// Return the global alias in the module with the specified name, of
  /// arbitrary type. This method returns null if a global with the specified
  /// name is not found.
  
  /// @}
  /// @name Global Alias Accessors
  /// @{
  
  /// Return the global alias in the module with the specified name, of
  /// arbitrary type. This method returns null if a global with the specified
  /// name is not found.
  
  //===----------------------------------------------------------------------===//
  // Methods for easy access to the global variables in the module.
  //
  
  // getNamedAlias - Look up the specified global in the module symbol table.
  // If it does not exist, return null.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 252,
   FQN="llvm::Module::getNamedAlias", NM="_ZNK4llvm6Module13getNamedAliasENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module13getNamedAliasENS_9StringRefE")
  //</editor-fold>
  public GlobalAlias /*P*/ getNamedAlias(StringRef Name) /*const*/ {
    return dyn_cast_or_null_GlobalAlias(getNamedValue(new StringRef(Name)));
  }


  
  /// @}
  /// @name Global IFunc Accessors
  /// @{
  
  /// Return the global ifunc in the module with the specified name, of
  /// arbitrary type. This method returns null if a global with the specified
  /// name is not found.
  
  /// @}
  /// @name Global IFunc Accessors
  /// @{
  
  /// Return the global ifunc in the module with the specified name, of
  /// arbitrary type. This method returns null if a global with the specified
  /// name is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedIFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 256,
   FQN="llvm::Module::getNamedIFunc", NM="_ZNK4llvm6Module13getNamedIFuncENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module13getNamedIFuncENS_9StringRefE")
  //</editor-fold>
  public GlobalIFunc /*P*/ getNamedIFunc(StringRef Name) /*const*/ {
    return dyn_cast_or_null_GlobalIFunc(getNamedValue(new StringRef(Name)));
  }


  
  /// @}
  /// @name Named Metadata Accessors
  /// @{
  
  /// Return the first NamedMDNode in the module with the specified name. This
  /// method returns null if a NamedMDNode with the specified name is not found.
  
  /// @}
  /// @name Named Metadata Accessors
  /// @{
  
  /// Return the first NamedMDNode in the module with the specified name. This
  /// method returns null if a NamedMDNode with the specified name is not found.
  
  /// getNamedMetadata - Return the first NamedMDNode in the module with the
  /// specified name. This method returns null if a NamedMDNode with the
  /// specified name is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 263,
   FQN="llvm::Module::getNamedMetadata", NM="_ZNK4llvm6Module16getNamedMetadataERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module16getNamedMetadataERKNS_5TwineE")
  //</editor-fold>
  public NamedMDNode /*P*/ getNamedMetadata(final /*const*/ Twine /*&*/ Name) /*const*/ {
    SmallString/*<256>*/ NameData/*J*/= new SmallString/*<256>*/(256);
    StringRef NameRef = Name.toStringRef(NameData);
    return ((/*static_cast*/StringMap<NamedMDNode /*P*/ > /*P*/)(NamedMDSymTab)).lookup(new StringRef(NameRef));
  }


  
  /// Return the named MDNode in the module with the specified name. This method
  /// returns a new NamedMDNode if a NamedMDNode with the specified name is not
  /// found.
  
  /// Return the named MDNode in the module with the specified name. This method
  /// returns a new NamedMDNode if a NamedMDNode with the specified name is not
  /// found.
  
  /// getOrInsertNamedMetadata - Return the first named MDNode in the module
  /// with the specified name. This method returns a new NamedMDNode if a
  /// NamedMDNode with the specified name is not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertNamedMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 272,
   FQN="llvm::Module::getOrInsertNamedMetadata", NM="_ZN4llvm6Module24getOrInsertNamedMetadataENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module24getOrInsertNamedMetadataENS_9StringRefE")
  //</editor-fold>
  public NamedMDNode /*P*/ getOrInsertNamedMetadata(StringRef Name) {
    final type$ref<NamedMDNode /*P*/ /*&*/> NMD = (/*Deref*/((/*static_cast*/StringMap<NamedMDNode /*P*/ > /*P*/)(NamedMDSymTab))).ref$at(/*NO_COPY*/Name);
    if (!(NMD.$deref() != null)) {
      NMD.$set(new NamedMDNode(new Twine(Name)));
      NMD.$deref().setParent(this);
      NamedMDList.push_back$P(NMD.$deref());
    }
    return NMD.$deref();
  }


  
  /// Remove the given NamedMDNode from this module and delete it.
  
  /// Remove the given NamedMDNode from this module and delete it.
  
  /// eraseNamedMetadata - Remove the given NamedMDNode from this module and
  /// delete it.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::eraseNamedMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 285,
   FQN="llvm::Module::eraseNamedMetadata", NM="_ZN4llvm6Module18eraseNamedMetadataEPNS_11NamedMDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module18eraseNamedMetadataEPNS_11NamedMDNodeE")
  //</editor-fold>
  public void eraseNamedMetadata(NamedMDNode /*P*/ NMD) {
    ((/*static_cast*/StringMap<NamedMDNode /*P*/ > /*P*/)(NamedMDSymTab)).erase(NMD.getName());
    NamedMDList.erase(NMD.getIterator());
  }


  
  /// @}
  /// @name Comdat Accessors
  /// @{
  
  /// Return the Comdat in the module with the specified name. It is created
  /// if it didn't already exist.
  
  /// @}
  /// @name Comdat Accessors
  /// @{
  
  /// Return the Comdat in the module with the specified name. It is created
  /// if it didn't already exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 480,
   FQN="llvm::Module::getOrInsertComdat", NM="_ZN4llvm6Module17getOrInsertComdatENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module17getOrInsertComdatENS_9StringRefE")
  //</editor-fold>
  public Comdat /*P*/ getOrInsertComdat(StringRef Name) {
    final StringMapEntry<Comdat> /*&*/ Entry = ComdatSymTab.insert(std.make_pair($Clone(Name), $Move(new Comdat()))).first.$star();
    Entry.second.Name = /*AddrOf*/Entry;
    return /*AddrOf*/Entry.second;
  }


  
  /// @}
  /// @name Module Flags Accessors
  /// @{
  
  /// Returns the module flags in the provided vector.
  
  /// @}
  /// @name Module Flags Accessors
  /// @{
  
  /// Returns the module flags in the provided vector.
  
  /// getModuleFlagsMetadata - Returns the module flags in the provided vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getModuleFlagsMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 302,
   FQN="llvm::Module::getModuleFlagsMetadata", NM="_ZNK4llvm6Module22getModuleFlagsMetadataERNS_15SmallVectorImplINS0_15ModuleFlagEntryEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module22getModuleFlagsMetadataERNS_15SmallVectorImplINS0_15ModuleFlagEntryEEE")
  //</editor-fold>
  public void getModuleFlagsMetadata(final SmallVectorImpl<ModuleFlagEntry> /*&*/ Flags) /*const*/ {
    /*const*/ NamedMDNode /*P*/ ModFlags = getModuleFlagsMetadata();
    if (!(ModFlags != null)) {
      return;
    }
    
    for (/*const*/ MDNode /*P*/ Flag : ModFlags.operands$Const()) {
      type$ref<ModFlagBehavior> MFB = create_type$ref();
      if ($greatereq_uint(Flag.getNumOperands(), 3)
         && isValidModFlagBehavior(Flag.getOperand(0).$Metadata$P(), MFB)
         && (dyn_cast_or_null_MDString(Flag.getOperand(1)) != null)) {
        // Check the operands of the MDNode before accessing the operands.
        // The verifier will actually catch these failures.
        MDString /*P*/ Key = cast_MDString(Flag.getOperand(1));
        Metadata /*P*/ Val = Flag.getOperand(2).$Metadata$P();
        Flags.push_back(new ModuleFlagEntry(MFB.$deref(), Key, Val));
      }
    }
  }


  
  /// Return the corresponding value if Key appears in module flags, otherwise
  /// return null.
  
  /// Return the corresponding value if Key appears in module flags, otherwise
  /// return null.
  
  /// Return the corresponding value if Key appears in module flags, otherwise
  /// return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getModuleFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 323,
   FQN="llvm::Module::getModuleFlag", NM="_ZNK4llvm6Module13getModuleFlagENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module13getModuleFlagENS_9StringRefE")
  //</editor-fold>
  public Metadata /*P*/ getModuleFlag(StringRef Key) /*const*/ {
    SmallVector<Module.ModuleFlagEntry> ModuleFlags/*J*/= new SmallVector<Module.ModuleFlagEntry>(8, new Module.ModuleFlagEntry());
    getModuleFlagsMetadata(ModuleFlags);
    for (final /*const*/ ModuleFlagEntry /*&*/ MFE : ModuleFlags) {
      if ($eq_StringRef(/*NO_COPY*/Key, MFE.Key.getString())) {
        return MFE.Val;
      }
    }
    return null;
  }


  
  /// Returns the NamedMDNode in the module that represents module-level flags.
  /// This method returns null if there are no module-level flags.
  
  /// Returns the NamedMDNode in the module that represents module-level flags.
  /// This method returns null if there are no module-level flags.
  
  /// getModuleFlagsMetadata - Returns the NamedMDNode in the module that
  /// represents module-level flags. This method returns null if there are no
  /// module-level flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getModuleFlagsMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 336,
   FQN="llvm::Module::getModuleFlagsMetadata", NM="_ZNK4llvm6Module22getModuleFlagsMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module22getModuleFlagsMetadataEv")
  //</editor-fold>
  public NamedMDNode /*P*/ getModuleFlagsMetadata() /*const*/ {
    return getNamedMetadata(new Twine(/*KEEP_STR*/"llvm.module.flags"));
  }


  
  /// Returns the NamedMDNode in the module that represents module-level flags.
  /// If module-level flags aren't found, it creates the named metadata that
  /// contains them.
  
  /// Returns the NamedMDNode in the module that represents module-level flags.
  /// If module-level flags aren't found, it creates the named metadata that
  /// contains them.
  
  /// getOrInsertModuleFlagsMetadata - Returns the NamedMDNode in the module that
  /// represents module-level flags. If module-level flags aren't found, it
  /// creates the named metadata that contains them.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getOrInsertModuleFlagsMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 343,
   FQN="llvm::Module::getOrInsertModuleFlagsMetadata", NM="_ZN4llvm6Module30getOrInsertModuleFlagsMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module30getOrInsertModuleFlagsMetadataEv")
  //</editor-fold>
  public NamedMDNode /*P*/ getOrInsertModuleFlagsMetadata() {
    return getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"llvm.module.flags"));
  }


  
  /// Add a module-level flag to the module-level flags metadata. It will create
  /// the module-level flags named metadata if it doesn't already exist.
  
  /// Add a module-level flag to the module-level flags metadata. It will create
  /// the module-level flags named metadata if it doesn't already exist.
  
  /// addModuleFlag - Add a module-level flag to the module-level flags
  /// metadata. It will create the module-level flags named metadata if it doesn't
  /// already exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::addModuleFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 350,
   FQN="llvm::Module::addModuleFlag", NM="_ZN4llvm6Module13addModuleFlagENS0_15ModFlagBehaviorENS_9StringRefEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module13addModuleFlagENS0_15ModFlagBehaviorENS_9StringRefEPNS_8MetadataE")
  //</editor-fold>
  public void addModuleFlag(ModFlagBehavior Behavior, StringRef Key, 
               Metadata /*P*/ Val) {
    Type /*P*/ Int32Ty = Type.getInt32Ty(Context);
    Metadata /*P*/ Ops[/*3*/] = new Metadata /*P*/  [/*3*/] {
      ConstantAsMetadata.get(ConstantInt.get(Int32Ty, Behavior.getValue())), 
      MDString.get(Context, new StringRef(Key)), Val};
    getOrInsertModuleFlagsMetadata().addOperand(MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(Ops, true)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Module::addModuleFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 358,
   FQN="llvm::Module::addModuleFlag", NM="_ZN4llvm6Module13addModuleFlagENS0_15ModFlagBehaviorENS_9StringRefEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module13addModuleFlagENS0_15ModFlagBehaviorENS_9StringRefEPNS_8ConstantE")
  //</editor-fold>
  public void addModuleFlag(ModFlagBehavior Behavior, StringRef Key, 
               Constant /*P*/ Val) {
    addModuleFlag(Behavior, new StringRef(Key), ConstantAsMetadata.get(Val));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Module::addModuleFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 362,
   FQN="llvm::Module::addModuleFlag", NM="_ZN4llvm6Module13addModuleFlagENS0_15ModFlagBehaviorENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module13addModuleFlagENS0_15ModFlagBehaviorENS_9StringRefEj")
  //</editor-fold>
  public void addModuleFlag(ModFlagBehavior Behavior, StringRef Key, 
               /*uint32_t*/int Val) {
    Type /*P*/ Int32Ty = Type.getInt32Ty(Context);
    addModuleFlag(Behavior, new StringRef(Key), ConstantInt.get(Int32Ty, $uint2ulong(Val)));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Module::addModuleFlag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 367,
   FQN="llvm::Module::addModuleFlag", NM="_ZN4llvm6Module13addModuleFlagEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module13addModuleFlagEPNS_6MDNodeE")
  //</editor-fold>
  public void addModuleFlag(MDNode /*P*/ Node) {
    assert (Node.getNumOperands() == 3) : "Invalid number of operands for module flag!";
    assert (MdconstGlobals.hasa$ValidPointer(ConstantInt.class, Node.getOperand(0)) && isa_MDString(Node.getOperand(1))) : "Invalid operand types for module flag!";
    getOrInsertModuleFlagsMetadata().addOperand(Node);
  }


  
  /// @}
  /// @name Materialization
  /// @{
  
  /// Sets the GVMaterializer to GVM. This module must not yet have a
  /// Materializer. To reset the materializer for a module that already has one,
  /// call materializeAll first. Destroying this module will destroy
  /// its materializer without materializing any more GlobalValues. Without
  /// destroying the Module, there is no way to detach or destroy a materializer
  /// without materializing all the GVs it controls, to avoid leaving orphan
  /// unmaterialized GVs.
  
  /// @}
  /// @name Materialization
  /// @{
  
  /// Sets the GVMaterializer to GVM. This module must not yet have a
  /// Materializer. To reset the materializer for a module that already has one,
  /// call materializeAll first. Destroying this module will destroy
  /// its materializer without materializing any more GlobalValues. Without
  /// destroying the Module, there is no way to detach or destroy a materializer
  /// without materializing all the GVs it controls, to avoid leaving orphan
  /// unmaterialized GVs.
  
  //===----------------------------------------------------------------------===//
  // Methods to control the materialization of GlobalValues in the Module.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setMaterializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 400,
   FQN="llvm::Module::setMaterializer", NM="_ZN4llvm6Module15setMaterializerEPNS_14GVMaterializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module15setMaterializerEPNS_14GVMaterializerE")
  //</editor-fold>
  public void setMaterializer(GVMaterializer /*P*/ GVM) {
    assert (!Materializer.$bool()) : "Module already has a GVMaterializer.  Call materializeAll to clear it out before setting another one.";
    Materializer.reset(GVM);
  }


  /// Retrieves the GVMaterializer, if any, for this Module.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getMaterializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 469,
   FQN="llvm::Module::getMaterializer", NM="_ZNK4llvm6Module15getMaterializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module15getMaterializerEv")
  //</editor-fold>
  public GVMaterializer /*P*/ getMaterializer() /*const*/ {
    return Materializer.get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::isMaterialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 470,
   FQN="llvm::Module::isMaterialized", NM="_ZNK4llvm6Module14isMaterializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module14isMaterializedEv")
  //</editor-fold>
  public boolean isMaterialized() /*const*/ {
    return !(getMaterializer() != null);
  }

  
  /// Make sure the GlobalValue is fully read. If the module is corrupt, this
  /// returns true and fills in the optional string with information about the
  /// problem. If successful, this returns false.
  
  /// Make sure the GlobalValue is fully read. If the module is corrupt, this
  /// returns true and fills in the optional string with information about the
  /// problem. If successful, this returns false.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::materialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 407,
   FQN="llvm::Module::materialize", NM="_ZN4llvm6Module11materializeEPNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module11materializeEPNS_11GlobalValueE")
  //</editor-fold>
  public std.error_code materialize(GlobalValue /*P*/ GV) {
    if (!Materializer.$bool()) {
      return new std.error_code();
    }
    
    return Materializer.$arrow().materialize(GV);
  }


  
  /// Make sure all GlobalValues in this Module are fully read and clear the
  /// Materializer.
  
  /// Make sure all GlobalValues in this Module are fully read and clear the
  /// Materializer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::materializeAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 414,
   FQN="llvm::Module::materializeAll", NM="_ZN4llvm6Module14materializeAllEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module14materializeAllEv")
  //</editor-fold>
  public std.error_code materializeAll() {
    if (!Materializer.$bool()) {
      return new std.error_code();
    }
    std.unique_ptr<GVMaterializer> M = new std.unique_ptr<GVMaterializer>(JD$Move.INSTANCE, std.move(Materializer));
    return M.$arrow().materializeModule();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Module::materializeMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 421,
   FQN="llvm::Module::materializeMetadata", NM="_ZN4llvm6Module19materializeMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module19materializeMetadataEv")
  //</editor-fold>
  public std.error_code materializeMetadata() {
    if (!Materializer.$bool()) {
      return new std.error_code();
    }
    return Materializer.$arrow().materializeMetadata();
  }


  
  /// @}
  /// @name Direct access to the globals list, functions list, and symbol table
  /// @{
  
  /// Get the Module's list of global variables (constant).
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getGlobalList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 488,
   FQN="llvm::Module::getGlobalList", NM="_ZNK4llvm6Module13getGlobalListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module13getGlobalListEv")
  //</editor-fold>
  public /*const*/ SymbolTableList<GlobalVariable, Module> /*&*/ getGlobalList$Const() /*const*/ {
    return GlobalList;
  }

  /// Get the Module's list of global variables.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getGlobalList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 490,
   FQN="llvm::Module::getGlobalList", NM="_ZN4llvm6Module13getGlobalListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module13getGlobalListEv")
  //</editor-fold>
  public SymbolTableList<GlobalVariable, Module> /*&*/ getGlobalList() {
    return GlobalList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 491,
   FQN="llvm::Module::getSublistAccess", NM="_ZN4llvm6Module16getSublistAccessEPNS_14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module16getSublistAccessEPNS_14GlobalVariableE")
  //</editor-fold>
  public static Void2SymbolTableList<GlobalVariable, Module> getSublistAccess(GlobalVariable /*P*/ $Prm0) {
    return /*AddrOf*/new Void2SymbolTableList<GlobalVariable, Module>() {
      @Override
      public SymbolTableList<GlobalVariable, Module> $call(Module $this) {
        return $this.GlobalList;
      }
    };
  }

  /// Get the Module's list of functions (constant).
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getFunctionList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 495,
   FQN="llvm::Module::getFunctionList", NM="_ZNK4llvm6Module15getFunctionListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module15getFunctionListEv")
  //</editor-fold>
  public /*const*/ SymbolTableList<Function, Module> /*&*/ getFunctionList$Const() /*const*/ {
    return FunctionList;
  }

  /// Get the Module's list of functions.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getFunctionList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 497,
   FQN="llvm::Module::getFunctionList", NM="_ZN4llvm6Module15getFunctionListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module15getFunctionListEv")
  //</editor-fold>
  public SymbolTableList<Function, Module> /*&*/ getFunctionList() {
    return FunctionList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 498,
   FQN="llvm::Module::getSublistAccess", NM="_ZN4llvm6Module16getSublistAccessEPNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module16getSublistAccessEPNS_8FunctionE")
  //</editor-fold>
  public static Void2SymbolTableList<Function, Module> getSublistAccess(Function /*P*/ $Prm0) {
    return /*AddrOf*/new Void2SymbolTableList<Function, Module>() {
      @Override
      public SymbolTableList<Function, Module> $call(Module $this) {
        return $this.FunctionList;
      }
    };    
  }

  /// Get the Module's list of aliases (constant).
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getAliasList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 502,
   FQN="llvm::Module::getAliasList", NM="_ZNK4llvm6Module12getAliasListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module12getAliasListEv")
  //</editor-fold>
  public /*const*/ SymbolTableList<GlobalAlias, Module> /*&*/ getAliasList$Const() /*const*/ {
    return AliasList;
  }

  /// Get the Module's list of aliases.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getAliasList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 504,
   FQN="llvm::Module::getAliasList", NM="_ZN4llvm6Module12getAliasListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module12getAliasListEv")
  //</editor-fold>
  public SymbolTableList<GlobalAlias, Module> /*&*/ getAliasList() {
    return AliasList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 505,
   FQN="llvm::Module::getSublistAccess", NM="_ZN4llvm6Module16getSublistAccessEPNS_11GlobalAliasE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module16getSublistAccessEPNS_11GlobalAliasE")
  //</editor-fold>
  public static Void2SymbolTableList<GlobalAlias, Module> getSublistAccess(GlobalAlias /*P*/ $Prm0) {
    return /*AddrOf*/new Void2SymbolTableList<GlobalAlias, Module>() {
      @Override
      public SymbolTableList<GlobalAlias, Module> $call(Module $this) {
        return $this.AliasList;
      }
    };
  }

  /// Get the Module's list of ifuncs (constant).
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getIFuncList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 509,
   FQN="llvm::Module::getIFuncList", NM="_ZNK4llvm6Module12getIFuncListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module12getIFuncListEv")
  //</editor-fold>
  public /*const*/ SymbolTableList<GlobalIFunc, Module> /*&*/ getIFuncList$Const() /*const*/ {
    return IFuncList;
  }

  /// Get the Module's list of ifuncs.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getIFuncList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 511,
   FQN="llvm::Module::getIFuncList", NM="_ZN4llvm6Module12getIFuncListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module12getIFuncListEv")
  //</editor-fold>
  public SymbolTableList<GlobalIFunc, Module> /*&*/ getIFuncList() {
    return IFuncList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 512,
   FQN="llvm::Module::getSublistAccess", NM="_ZN4llvm6Module16getSublistAccessEPNS_11GlobalIFuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module16getSublistAccessEPNS_11GlobalIFuncE")
  //</editor-fold>
  public static Void2SymbolTableList<GlobalIFunc, Module> getSublistAccess(GlobalIFunc /*P*/ $Prm0) {
    return /*AddrOf*/new Void2SymbolTableList<GlobalIFunc, Module>() {
      @Override
      public SymbolTableList<GlobalIFunc, Module> $call(Module $this) {
        return $this.IFuncList;
      }
    };
  }

  /// Get the Module's list of named metadata (constant).
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedMDList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 516,
   FQN="llvm::Module::getNamedMDList", NM="_ZNK4llvm6Module14getNamedMDListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module14getNamedMDListEv")
  //</editor-fold>
  public /*const*/ ilist<NamedMDNode> /*&*/ getNamedMDList$Const() /*const*/ {
    return NamedMDList;
  }

  /// Get the Module's list of named metadata.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getNamedMDList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 518,
   FQN="llvm::Module::getNamedMDList", NM="_ZN4llvm6Module14getNamedMDListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module14getNamedMDListEv")
  //</editor-fold>
  public ilist<NamedMDNode> /*&*/ getNamedMDList() {
    return NamedMDList;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getSublistAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 519,
   FQN="llvm::Module::getSublistAccess", NM="_ZN4llvm6Module16getSublistAccessEPNS_11NamedMDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module16getSublistAccessEPNS_11NamedMDNodeE")
  //</editor-fold>
  public static Void2NamedMDListType getSublistAccess(NamedMDNode /*P*/ $Prm0) {
    return /*AddrOf*/new Void2NamedMDListType() {
      @Override
      public ilist<NamedMDNode> $call(Module $this) {
        return $this.NamedMDList;
      }
    };
  }

  /// Get the symbol table of global variable and function identifiers
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 523,
   FQN="llvm::Module::getValueSymbolTable", NM="_ZNK4llvm6Module19getValueSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module19getValueSymbolTableEv")
  //</editor-fold>
  public /*const*/ ValueSymbolTable /*&*/ getValueSymbolTable$Const() /*const*/ {
    return /*Deref*/ValSymTab;
  }

  /// Get the Module's symbol table of global variable and function identifiers.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 525,
   FQN="llvm::Module::getValueSymbolTable", NM="_ZN4llvm6Module19getValueSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module19getValueSymbolTableEv")
  //</editor-fold>
  public ValueSymbolTable /*&*/ getValueSymbolTable() {
    return /*Deref*/ValSymTab;
  }

  /// Get the Module's symbol table for COMDATs (constant).
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getComdatSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 527,
   FQN="llvm::Module::getComdatSymbolTable", NM="_ZNK4llvm6Module20getComdatSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module20getComdatSymbolTableEv")
  //</editor-fold>
  public /*const*/StringMap<Comdat> /*&*/ getComdatSymbolTable$Const() /*const*/ {
    return ComdatSymTab;
  }

  /// Get the Module's symbol table for COMDATs.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getComdatSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 529,
   FQN="llvm::Module::getComdatSymbolTable", NM="_ZN4llvm6Module20getComdatSymbolTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module20getComdatSymbolTableEv")
  //</editor-fold>
  public StringMap<Comdat> /*&*/ getComdatSymbolTable() {
    return ComdatSymTab;
  }

  
  /// @}
  /// @name Global Variable Iteration
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 535,
   FQN="llvm::Module::global_begin", NM="_ZN4llvm6Module12global_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module12global_beginEv")
  //</editor-fold>
  public ilist_iterator<GlobalVariable> global_begin() {
    return GlobalList.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 536,
   FQN="llvm::Module::global_begin", NM="_ZNK4llvm6Module12global_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module12global_beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ GlobalVariable> global_begin$Const() /*const*/ {
    return GlobalList.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 537,
   FQN="llvm::Module::global_end", NM="_ZN4llvm6Module10global_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module10global_endEv")
  //</editor-fold>
  public ilist_iterator<GlobalVariable> global_end() {
    return GlobalList.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 538,
   FQN="llvm::Module::global_end", NM="_ZNK4llvm6Module10global_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module10global_endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ GlobalVariable> global_end$Const() /*const*/ {
    return GlobalList.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 539,
   FQN="llvm::Module::global_empty", NM="_ZNK4llvm6Module12global_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module12global_emptyEv")
  //</editor-fold>
  public boolean global_empty() /*const*/ {
    return GlobalList.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::globals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 541,
   FQN="llvm::Module::globals", NM="_ZN4llvm6Module7globalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module7globalsEv")
  //</editor-fold>
  public iterator_range<GlobalVariable> globals() {
    return make_range(global_begin(), global_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::globals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 544,
   FQN="llvm::Module::globals", NM="_ZNK4llvm6Module7globalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module7globalsEv")
  //</editor-fold>
  public iterator_range</*const*/ GlobalVariable> globals$Const() /*const*/ {
    return make_range(global_begin$Const(), global_end$Const());
  }

  
  /// @}
  /// @name Function Iteration
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 552,
   FQN="llvm::Module::begin", NM="_ZN4llvm6Module5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module5beginEv")
  //</editor-fold>
  public ilist_iterator<Function> begin() {
    return FunctionList.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 553,
   FQN="llvm::Module::begin", NM="_ZNK4llvm6Module5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module5beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ Function> begin$Const() /*const*/ {
    return FunctionList.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 554,
   FQN="llvm::Module::end", NM="_ZN4llvm6Module3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module3endEv")
  //</editor-fold>
  public ilist_iterator<Function> end() {
    return FunctionList.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 555,
   FQN="llvm::Module::end", NM="_ZNK4llvm6Module3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module3endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ Function> end$Const() /*const*/ {
    return FunctionList.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 556,
   FQN="llvm::Module::rbegin", NM="_ZN4llvm6Module6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Function> rbegin() {
    return FunctionList.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 557,
   FQN="llvm::Module::rbegin", NM="_ZNK4llvm6Module6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ Function> rbegin$Const() /*const*/ {
    return FunctionList.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 558,
   FQN="llvm::Module::rend", NM="_ZN4llvm6Module4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module4rendEv")
  //</editor-fold>
  public std.reverse_iterator<Function> rend() {
    return FunctionList.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 559,
   FQN="llvm::Module::rend", NM="_ZNK4llvm6Module4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module4rendEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ Function> rend$Const() /*const*/ {
    return FunctionList.rend$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 560,
   FQN="llvm::Module::size", NM="_ZNK4llvm6Module4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return FunctionList.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 561,
   FQN="llvm::Module::empty", NM="_ZNK4llvm6Module5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return FunctionList.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::functions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 563,
   FQN="llvm::Module::functions", NM="_ZN4llvm6Module9functionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module9functionsEv")
  //</editor-fold>
  public iterator_range<Function> functions() {
    return make_range(begin(), end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::functions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 566,
   FQN="llvm::Module::functions", NM="_ZNK4llvm6Module9functionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module9functionsEv")
  //</editor-fold>
  public iterator_range</*const*/ Function> functions$Const() /*const*/ {
    return make_range(begin$Const(), end$Const());
  }

  
  /// @}
  /// @name Alias Iteration
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::alias_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 574,
   FQN="llvm::Module::alias_begin", NM="_ZN4llvm6Module11alias_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module11alias_beginEv")
  //</editor-fold>
  public ilist_iterator<GlobalAlias> alias_begin() {
    return AliasList.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::alias_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 575,
   FQN="llvm::Module::alias_begin", NM="_ZNK4llvm6Module11alias_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module11alias_beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ GlobalAlias> alias_begin$Const() /*const*/ {
    return AliasList.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::alias_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 576,
   FQN="llvm::Module::alias_end", NM="_ZN4llvm6Module9alias_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module9alias_endEv")
  //</editor-fold>
  public ilist_iterator<GlobalAlias> alias_end() {
    return AliasList.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::alias_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 577,
   FQN="llvm::Module::alias_end", NM="_ZNK4llvm6Module9alias_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module9alias_endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ GlobalAlias> alias_end$Const() /*const*/ {
    return AliasList.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::alias_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 578,
   FQN="llvm::Module::alias_size", NM="_ZNK4llvm6Module10alias_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module10alias_sizeEv")
  //</editor-fold>
  public /*size_t*/int alias_size() /*const*/ {
    return AliasList.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::alias_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 579,
   FQN="llvm::Module::alias_empty", NM="_ZNK4llvm6Module11alias_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module11alias_emptyEv")
  //</editor-fold>
  public boolean alias_empty() /*const*/ {
    return AliasList.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::aliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 581,
   FQN="llvm::Module::aliases", NM="_ZN4llvm6Module7aliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module7aliasesEv")
  //</editor-fold>
  public iterator_range<GlobalAlias> aliases() {
    return make_range(alias_begin(), alias_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::aliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 584,
   FQN="llvm::Module::aliases", NM="_ZNK4llvm6Module7aliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module7aliasesEv")
  //</editor-fold>
  public iterator_range</*const*/ GlobalAlias> aliases$Const() /*const*/ {
    return make_range(alias_begin$Const(), alias_end$Const());
  }

  
  /// @}
  /// @name IFunc Iteration
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifunc_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 592,
   FQN="llvm::Module::ifunc_begin", NM="_ZN4llvm6Module11ifunc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module11ifunc_beginEv")
  //</editor-fold>
  public ilist_iterator<GlobalIFunc> ifunc_begin() {
    return IFuncList.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifunc_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 593,
   FQN="llvm::Module::ifunc_begin", NM="_ZNK4llvm6Module11ifunc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module11ifunc_beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ GlobalIFunc> ifunc_begin$Const() /*const*/ {
    return IFuncList.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifunc_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 594,
   FQN="llvm::Module::ifunc_end", NM="_ZN4llvm6Module9ifunc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module9ifunc_endEv")
  //</editor-fold>
  public ilist_iterator<GlobalIFunc> ifunc_end() {
    return IFuncList.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifunc_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 595,
   FQN="llvm::Module::ifunc_end", NM="_ZNK4llvm6Module9ifunc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module9ifunc_endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ GlobalIFunc> ifunc_end$Const() /*const*/ {
    return IFuncList.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifunc_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 596,
   FQN="llvm::Module::ifunc_size", NM="_ZNK4llvm6Module10ifunc_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module10ifunc_sizeEv")
  //</editor-fold>
  public /*size_t*/int ifunc_size() /*const*/ {
    return IFuncList.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifunc_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 597,
   FQN="llvm::Module::ifunc_empty", NM="_ZNK4llvm6Module11ifunc_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module11ifunc_emptyEv")
  //</editor-fold>
  public boolean ifunc_empty() /*const*/ {
    return IFuncList.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifuncs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 599,
   FQN="llvm::Module::ifuncs", NM="_ZN4llvm6Module6ifuncsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module6ifuncsEv")
  //</editor-fold>
  public iterator_range<GlobalIFunc> ifuncs() {
    return make_range(ifunc_begin(), ifunc_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::ifuncs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 602,
   FQN="llvm::Module::ifuncs", NM="_ZNK4llvm6Module6ifuncsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module6ifuncsEv")
  //</editor-fold>
  public iterator_range</*const*/ GlobalIFunc> ifuncs$Const() /*const*/ {
    return make_range(ifunc_begin$Const(), ifunc_end$Const());
  }

  
  /// @}
  /// @name Convenience iterators
  /// @{
  /*template <bool IsConst> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_iterator_t">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 610,
   FQN="llvm::Module::global_object_iterator_t", NM="_ZN4llvm6Module24global_object_iterator_tE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module24global_object_iterator_tE")
  //</editor-fold>
  public static class global_object_iterator_t/*<boolean IsConst>*/ implements type$iterator<global_object_iterator_t, GlobalObject/*P*/> {
    /*friend  Module*/
    
    private /*conditional<IsConst, Ilist_iterator$Function$C,Ilist_iterator$Function>*/ilist_iterator</*const*/ Function> function_i;
    
    private /*conditional<IsConst, Ilist_iterator$Function$C,Ilist_iterator$Function>*/ilist_iterator</*const*/ Function> function_e;
    private /*conditional<IsConst, Ilist_iterator$GlobalVariable$C,Ilist_iterator$GlobalVariable>*/ilist_iterator</*const*/ GlobalVariable> global_i;
    
    // JAVA: typedef typename std::conditional<IsConst, const Module, Module>::type ModuleTy
//    public final class ModuleTy extends /*conditional<IsConst, Module$C,Module>*//*const*/ Module{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_iterator_t::global_object_iterator_t<IsConst>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 622,
     FQN="llvm::Module::global_object_iterator_t::global_object_iterator_t<IsConst>", NM="_ZN4llvm6Module24global_object_iterator_tC1ERNSt11conditionalIXT_EKS0_S0_E4typeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module24global_object_iterator_tC1ERNSt11conditionalIXT_EKS0_S0_E4typeE")
    //</editor-fold>
    private global_object_iterator_t(final /*conditional<IsConst, Module$C,Module>*//*const*/ Module /*&*/ M) {
      // : function_i(M.begin()), function_e(M.end()), global_i(M.global_begin()) 
      //START JInit
      this.function_i = /*ParenListExpr*/new /*conditional<IsConst, Ilist_iterator$Function$C,Ilist_iterator$Function>*/ilist_iterator</*const*/ Function>(M.begin());
      this.function_e = /*ParenListExpr*/new /*conditional<IsConst, Ilist_iterator$Function$C,Ilist_iterator$Function>*/ilist_iterator</*const*/ Function>(M.end());
      this.global_i = /*ParenListExpr*/new /*conditional<IsConst, Ilist_iterator$GlobalVariable$C,Ilist_iterator$GlobalVariable>*/ilist_iterator</*const*/ GlobalVariable>(M.global_begin());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_iterator_t::global_object_iterator_t<IsConst>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 625,
     FQN="llvm::Module::global_object_iterator_t::global_object_iterator_t<IsConst>", NM="_ZN4llvm6Module24global_object_iterator_tC1ERNSt11conditionalIXT_EKS0_S0_E4typeEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module24global_object_iterator_tC1ERNSt11conditionalIXT_EKS0_S0_E4typeEi")
    //</editor-fold>
    private global_object_iterator_t(final /*conditional<IsConst, Module$C,Module>*//*const*/ Module /*&*/ M, int $Prm1) {
      // : function_i(M.end()), function_e(M.end()), global_i(M.global_end()) 
      //START JInit
      this.function_i = /*ParenListExpr*/new /*conditional<IsConst, Ilist_iterator$Function$C,Ilist_iterator$Function>*/ilist_iterator</*const*/ Function>(M.end());
      this.function_e = /*ParenListExpr*/new /*conditional<IsConst, Ilist_iterator$Function$C,Ilist_iterator$Function>*/ilist_iterator</*const*/ Function>(M.end());
      this.global_i = /*ParenListExpr*/new /*conditional<IsConst, Ilist_iterator$GlobalVariable$C,Ilist_iterator$GlobalVariable>*/ilist_iterator</*const*/ GlobalVariable>(M.global_end());
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_iterator_t::operator++">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 629,
     FQN="llvm::Module::global_object_iterator_t::operator++", NM="_ZN4llvm6Module24global_object_iterator_tppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module24global_object_iterator_tppEv")
    //</editor-fold>
    public global_object_iterator_t/*<IsConst>*//*&*/ $preInc() {
      if (Native.$noteq_iter(function_i, function_e)) {
        function_i.$preInc();
      } else {
        global_i.$preInc();
      }
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_iterator_t::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 637,
     FQN="llvm::Module::global_object_iterator_t::operator*", NM="_ZNK4llvm6Module24global_object_iterator_tdeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module24global_object_iterator_tdeEv")
    //</editor-fold>
    public /*conditional<IsConst, GlobalObject$C,GlobalObject>*//*const*/ GlobalObject /*&*/ $star() /*const*/ {
      if (Native.$noteq_iter(function_i, function_e)) {
        return /*Deref*/function_i.$star();
      } else {
        return /*Deref*/global_i.$star();
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_iterator_t::operator!=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 645,
     FQN="llvm::Module::global_object_iterator_t::operator!=", NM="_ZNK4llvm6Module24global_object_iterator_tneERKNS0_24global_object_iterator_tIXT_EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module24global_object_iterator_tneERKNS0_24global_object_iterator_tIXT_EEE")
    //</editor-fold>
    public boolean $noteq(final /*const*/global_object_iterator_t/*<IsConst>*//*&*/ other) /*const*/ {
      return Native.$bool(Native.$noteq_iter(function_i, other.function_i)) || Native.$bool(Native.$noteq_iter(global_i, other.global_i));
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public global_object_iterator_t(global_object_iterator_t $Prm0) {
      this.IsConst = $tryClone($Prm0.IsConst);
      this.function_i = $tryClone($Prm0.function_i);
      this.function_e = $tryClone($Prm0.function_e);
      this.global_i = $tryClone($Prm0.global_i);
    }
    
    @Override public global_object_iterator_t clone() {
      return new global_object_iterator_t(this);
    }
    
    /*JAVA*/private boolean IsConst;

    @Override
    public boolean $eq(Object other) {
      return !$noteq((global_object_iterator_t)other);
    }
    
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "function_i=" + function_i // NOI18N
                + ", function_e=" + function_e // NOI18N
                + ", global_i=" + global_i; // NOI18N
    }
  };
  
  // JAVA: typedef global_object_iterator_t</*IsConst=*/ false> global_object_iterator
//  public final class global_object_iterator extends global_object_iterator_t/*false*/{ };
  // JAVA: typedef global_object_iterator_t</*IsConst=*/ true> const_global_object_iterator
//  public final class const_global_object_iterator extends global_object_iterator_t/*true*/{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 654,
   FQN="llvm::Module::global_object_begin", NM="_ZN4llvm6Module19global_object_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module19global_object_beginEv")
  //</editor-fold>
  public global_object_iterator_t/*false*/ global_object_begin() {
    return new global_object_iterator_t/*false*/(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 657,
   FQN="llvm::Module::global_object_end", NM="_ZN4llvm6Module17global_object_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module17global_object_endEv")
  //</editor-fold>
  public global_object_iterator_t/*false*/ global_object_end() {
    return new global_object_iterator_t/*false*/(/*Deref*/this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 661,
   FQN="llvm::Module::global_object_begin", NM="_ZNK4llvm6Module19global_object_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module19global_object_beginEv")
  //</editor-fold>
  public global_object_iterator_t/*true*/ global_object_begin$Const() /*const*/ {
    return new global_object_iterator_t/*true*/(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_object_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 664,
   FQN="llvm::Module::global_object_end", NM="_ZNK4llvm6Module17global_object_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module17global_object_endEv")
  //</editor-fold>
  public global_object_iterator_t/*true*/ global_object_end$Const() /*const*/ {
    return new global_object_iterator_t/*true*/(/*Deref*/this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_objects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 668,
   FQN="llvm::Module::global_objects", NM="_ZN4llvm6Module14global_objectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module14global_objectsEv")
  //</editor-fold>
  public iterator_range</*conditional<False, GlobalObject$C,GlobalObject>*//*const*/ GlobalObject /*&*/> global_objects() {
    return make_range(global_object_begin(), global_object_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::global_objects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 671,
   FQN="llvm::Module::global_objects", NM="_ZNK4llvm6Module14global_objectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module14global_objectsEv")
  //</editor-fold>
  public iterator_range</*conditional<True, GlobalObject$C,GlobalObject>*//*const*/ GlobalObject /*&*/> global_objects$Const() /*const*/ {
    return make_range(global_object_begin$Const(), global_object_end$Const());
  }

  
  /// @}
  /// @name Named Metadata Iteration
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 679,
   FQN="llvm::Module::named_metadata_begin", NM="_ZN4llvm6Module20named_metadata_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module20named_metadata_beginEv")
  //</editor-fold>
  public ilist_iterator<NamedMDNode> named_metadata_begin() {
    return NamedMDList.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 680,
   FQN="llvm::Module::named_metadata_begin", NM="_ZNK4llvm6Module20named_metadata_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module20named_metadata_beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ NamedMDNode> named_metadata_begin$Const() /*const*/ {
    return NamedMDList.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 684,
   FQN="llvm::Module::named_metadata_end", NM="_ZN4llvm6Module18named_metadata_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module18named_metadata_endEv")
  //</editor-fold>
  public ilist_iterator<NamedMDNode> named_metadata_end() {
    return NamedMDList.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 685,
   FQN="llvm::Module::named_metadata_end", NM="_ZNK4llvm6Module18named_metadata_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module18named_metadata_endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ NamedMDNode> named_metadata_end$Const() /*const*/ {
    return NamedMDList.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 689,
   FQN="llvm::Module::named_metadata_size", NM="_ZNK4llvm6Module19named_metadata_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module19named_metadata_sizeEv")
  //</editor-fold>
  public /*size_t*/int named_metadata_size() /*const*/ {
    return NamedMDList.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 690,
   FQN="llvm::Module::named_metadata_empty", NM="_ZNK4llvm6Module20named_metadata_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module20named_metadata_emptyEv")
  //</editor-fold>
  public boolean named_metadata_empty() /*const*/ {
    return NamedMDList.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 692,
   FQN="llvm::Module::named_metadata", NM="_ZN4llvm6Module14named_metadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module14named_metadataEv")
  //</editor-fold>
  public iterator_range<NamedMDNode> named_metadata() {
    return make_range(named_metadata_begin(), named_metadata_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Module::named_metadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 695,
   FQN="llvm::Module::named_metadata", NM="_ZNK4llvm6Module14named_metadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module14named_metadataEv")
  //</editor-fold>
  public iterator_range</*const*/ NamedMDNode> named_metadata$Const() /*const*/ {
    return make_range(named_metadata_begin$Const(), named_metadata_end$Const());
  }

  
  /// An iterator for DICompileUnits that skips those marked NoDebug.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 700,
   FQN="llvm::Module::debug_compile_units_iterator", NM="_ZN4llvm6Module28debug_compile_units_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module28debug_compile_units_iteratorE")
  //</editor-fold>
  public static class debug_compile_units_iterator implements /*public*/// std.iterator<std.input_iterator_tag, DICompileUnit /*P*/ >, Native.NativeComparable<debug_compile_units_iterator>
          type$iterator<debug_compile_units_iterator, DICompileUnit/*P*/> {
    private NamedMDNode /*P*/ CUs;
    private /*uint*/int Idx;
    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::SkipNoDebugCUs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 391,
     FQN="llvm::Module::debug_compile_units_iterator::SkipNoDebugCUs", NM="_ZN4llvm6Module28debug_compile_units_iterator14SkipNoDebugCUsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module28debug_compile_units_iterator14SkipNoDebugCUsEv")
    //</editor-fold>
    private void SkipNoDebugCUs() {
      while ((CUs != null) && ($less_uint(Idx, CUs.getNumOperands()))
         && ((/*Deref*/this).$arrow().getEmissionKind() == DICompileUnit.DebugEmissionKind.NoDebug)) {
        ++Idx;
      }
    }


  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::debug_compile_units_iterator">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 706,
     FQN="llvm::Module::debug_compile_units_iterator::debug_compile_units_iterator", NM="_ZN4llvm6Module28debug_compile_units_iteratorC1EPNS_11NamedMDNodeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module28debug_compile_units_iteratorC1EPNS_11NamedMDNodeEj")
    //</editor-fold>
    public /*explicit*/ debug_compile_units_iterator(NamedMDNode /*P*/ CUs, /*uint*/int Idx) {
      // : std::iterator<std::input_iterator_tag, DICompileUnit * >(), CUs(CUs), Idx(Idx) 
      //START JInit
//      $iterator();
      this.CUs = CUs;
      this.Idx = Idx;
      //END JInit
      SkipNoDebugCUs();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 710,
     FQN="llvm::Module::debug_compile_units_iterator::operator++", NM="_ZN4llvm6Module28debug_compile_units_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module28debug_compile_units_iteratorppEv")
    //</editor-fold>
    public debug_compile_units_iterator /*&*/ $preInc() {
      ++Idx;
      SkipNoDebugCUs();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 715,
     FQN="llvm::Module::debug_compile_units_iterator::operator++", NM="_ZN4llvm6Module28debug_compile_units_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module28debug_compile_units_iteratorppEi")
    //</editor-fold>
    public debug_compile_units_iterator $postInc(int $Prm0) {
      debug_compile_units_iterator T/*J*/= new debug_compile_units_iterator(/*Deref*/this);
      ++Idx;
      return T;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 720,
     FQN="llvm::Module::debug_compile_units_iterator::operator==", NM="_ZNK4llvm6Module28debug_compile_units_iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module28debug_compile_units_iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ debug_compile_units_iterator /*&*/ I) /*const*/ {
      return Idx == I.Idx;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 723,
     FQN="llvm::Module::debug_compile_units_iterator::operator!=", NM="_ZNK4llvm6Module28debug_compile_units_iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module28debug_compile_units_iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ debug_compile_units_iterator /*&*/ I) /*const*/ {
      return Idx != I.Idx;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 384,
     FQN="llvm::Module::debug_compile_units_iterator::operator*", NM="_ZNK4llvm6Module28debug_compile_units_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module28debug_compile_units_iteratordeEv")
    //</editor-fold>
    public DICompileUnit /*P*/ $star() /*const*/ {
      return cast_DICompileUnit(CUs.getOperand(Idx));
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 387,
     FQN="llvm::Module::debug_compile_units_iterator::operator->", NM="_ZNK4llvm6Module28debug_compile_units_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module28debug_compile_units_iteratorptEv")
    //</editor-fold>
    public DICompileUnit /*P*/ $arrow() /*const*/ {
      return cast_DICompileUnit(CUs.getOperand(Idx));
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::debug_compile_units_iterator">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 700,
     FQN="llvm::Module::debug_compile_units_iterator::debug_compile_units_iterator", NM="_ZN4llvm6Module28debug_compile_units_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module28debug_compile_units_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ debug_compile_units_iterator(final /*const*/ debug_compile_units_iterator /*&*/ $Prm0) {
      // : std::iterator<std::input_iterator_tag, DICompileUnit * >(), CUs(.CUs), Idx(.Idx) 
      //START JInit
//      $iterator($Prm0);
      this.CUs = $Prm0.CUs;
      this.Idx = $Prm0.Idx;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_iterator::debug_compile_units_iterator">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 700,
     FQN="llvm::Module::debug_compile_units_iterator::debug_compile_units_iterator", NM="_ZN4llvm6Module28debug_compile_units_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Module28debug_compile_units_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ debug_compile_units_iterator(JD$Move _dparam, final debug_compile_units_iterator /*&&*/$Prm0) {
      // : std::iterator<std::input_iterator_tag, DICompileUnit * >(static_cast<debug_compile_units_iterator &&>()), CUs(static_cast<debug_compile_units_iterator &&>().CUs), Idx(static_cast<debug_compile_units_iterator &&>().Idx) 
      //START JInit
//      $iterator(JD$Move.INSTANCE, $Prm0);
      this.CUs = $Prm0.CUs;
      this.Idx = $Prm0.Idx;
      //END JInit
    }
    
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public debug_compile_units_iterator clone() { return new debug_compile_units_iterator(this); }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "CUs=" + CUs // NOI18N
                + ", Idx=" + Idx // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 730,
   FQN="llvm::Module::debug_compile_units_begin", NM="_ZNK4llvm6Module25debug_compile_units_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module25debug_compile_units_beginEv")
  //</editor-fold>
  public debug_compile_units_iterator debug_compile_units_begin() /*const*/ {
    NamedMDNode /*P*/ CUs = getNamedMetadata(new Twine(/*KEEP_STR*/"llvm.dbg.cu"));
    return new debug_compile_units_iterator(CUs, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 735,
   FQN="llvm::Module::debug_compile_units_end", NM="_ZNK4llvm6Module23debug_compile_units_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module23debug_compile_units_endEv")
  //</editor-fold>
  public debug_compile_units_iterator debug_compile_units_end() /*const*/ {
    NamedMDNode /*P*/ CUs = getNamedMetadata(new Twine(/*KEEP_STR*/"llvm.dbg.cu"));
    return new debug_compile_units_iterator(CUs, (CUs != null) ? CUs.getNumOperands() : 0);
  }

  
  /// Return an iterator for all DICompileUnits listed in this Module's
  /// llvm.dbg.cu named metadata node and aren't explicitly marked as
  /// NoDebug.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::debug_compile_units">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 743,
   FQN="llvm::Module::debug_compile_units", NM="_ZNK4llvm6Module19debug_compile_unitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module19debug_compile_unitsEv")
  //</editor-fold>
  public iterator_range<DICompileUnit /*P*/ > debug_compile_units() /*const*/ {
    NamedMDNode /*P*/ CUs = getNamedMetadata(new Twine(/*KEEP_STR*/"llvm.dbg.cu"));
    return make_range(new debug_compile_units_iterator(CUs, 0), 
        new debug_compile_units_iterator(CUs, (CUs != null) ? CUs.getNumOperands() : 0));
  }

  /// @}
  
  /// Destroy ConstantArrays in LLVMContext if they are not used.
  /// ConstantArrays constructed during linking can cause quadratic memory
  /// explosion. Releasing all unused constants can cause a 20% LTO compile-time
  /// slowdown for a large application.
  ///
  /// NOTE: Constants are currently owned by LLVMContext. This can then only
  /// be called where all uses of the LLVMContext are understood.
  /// @}
  
  /// Destroy ConstantArrays in LLVMContext if they are not used.
  /// ConstantArrays constructed during linking can cause quadratic memory
  /// explosion. Releasing all unused constants can cause a 20% LTO compile-time
  /// slowdown for a large application.
  ///
  /// NOTE: Constants are currently owned by LLVMContext. This can then only
  /// be called where all uses of the LLVMContext are understood.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::dropTriviallyDeadConstantArrays">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 161,
   FQN="llvm::Module::dropTriviallyDeadConstantArrays", NM="_ZN4llvm6Module31dropTriviallyDeadConstantArraysEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm6Module31dropTriviallyDeadConstantArraysEv")
  //</editor-fold>
  public void dropTriviallyDeadConstantArrays() {
    Context.pImpl.dropTriviallyDeadConstantArrays();
  }


  
  /// @name Utility functions for printing and dumping Module objects
  /// @{
  
  /// Print the module to an output stream with an optional
  /// AssemblyAnnotationWriter.  If \c ShouldPreserveUseListOrder, then include
  /// uselistorder directives so that use-lists can be recreated when reading
  /// the assembly.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3306,
   FQN="llvm::Module::print", NM="_ZNK4llvm6Module5printERNS_11raw_ostreamEPNS_24AssemblyAnnotationWriterEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module5printERNS_11raw_ostreamEPNS_24AssemblyAnnotationWriterEbb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ ROS, AssemblyAnnotationWriter /*P*/ AAW) /*const*/ {
    print(ROS, AAW, 
       false, false);
  }
  public void print(final raw_ostream /*&*/ ROS, AssemblyAnnotationWriter /*P*/ AAW, 
       boolean ShouldPreserveUseListOrder/*= false*/) /*const*/ {
    print(ROS, AAW, 
       ShouldPreserveUseListOrder, false);
  }
  public void print(final raw_ostream /*&*/ ROS, AssemblyAnnotationWriter /*P*/ AAW, 
       boolean ShouldPreserveUseListOrder/*= false*/, boolean IsForDebug/*= false*/) /*const*/ {
    SlotTracker SlotTable = null;
    formatted_raw_ostream OS = null;
    AssemblyWriter W = null;
    try {
      SlotTable/*J*/= new SlotTracker(this);
      OS/*J*/= new formatted_raw_ostream(ROS);
      W/*J*/= new AssemblyWriter(OS, SlotTable, this, AAW, IsForDebug, 
          ShouldPreserveUseListOrder);
      W.printModule(this);
    } finally {
      if (W != null) { W.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      if (SlotTable != null) { SlotTable.$destroy(); }
    }
  }

  
  /// Dump the module to stderr (for debugging).
  
  // Module::dump() - Allow printing of Modules from the debugger.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3542,
   FQN="llvm::Module::dump", NM="_ZNK4llvm6Module4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Module4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), (AssemblyAnnotationWriter /*P*/ )null, 
        /*ShouldPreserveUseListOrder=*/ false, /*IsForDebug=*/ true);
  }

  
  /// This function causes all the subinstructions to "let go" of all references
  /// that they are maintaining.  This allows one to 'delete' a whole class at
  /// a time, even though there may be circular references... first all
  /// references are dropped, and all use counts go to zero.  Then everything
  /// is delete'd for real.  Note that no operations are valid on an object
  /// that has "dropped all references", except operator delete.
  
  /// This function causes all the subinstructions to "let go" of all references
  /// that they are maintaining.  This allows one to 'delete' a whole class at
  /// a time, even though there may be circular references... first all
  /// references are dropped, and all use counts go to zero.  Then everything
  /// is delete'd for real.  Note that no operations are valid on an object
  /// that has "dropped all references", except operator delete.
  
  // dropAllReferences() - This function causes all the subelements to "let go"
  // of all references that they are maintaining.  This allows one to 'delete' a
  // whole module at a time, even though there may be circular references... first
  // all references are dropped, and all use counts go to zero.  Then everything
  // is deleted for real.  Note that no operations are valid on an object that
  // has "dropped all references", except operator delete.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::dropAllReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 452,
   FQN="llvm::Module::dropAllReferences", NM="_ZN4llvm6Module17dropAllReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module17dropAllReferencesEv")
  //</editor-fold>
  public void dropAllReferences() {
    for (final Function /*&*/ F : /*Deref*/this)  {
      F.dropAllReferences();
    }
    
    for (final GlobalVariable /*&*/ GV : globals())  {
      GV.dropAllReferences();
    }
    
    for (final GlobalAlias /*&*/ GA : aliases())  {
      GA.dropAllReferences();
    }
    
    for (final GlobalIFunc /*&*/ GIF : ifuncs())  {
      GIF.dropAllReferences();
    }
  }


  
  /// @}
  /// @name Utility functions for querying Debug information.
  /// @{
  
  /// \brief Returns the Dwarf Version by checking module flags.
  
  /// @}
  /// @name Utility functions for querying Debug information.
  /// @{
  
  /// \brief Returns the Dwarf Version by checking module flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 466,
   FQN="llvm::Module::getDwarfVersion", NM="_ZNK4llvm6Module15getDwarfVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module15getDwarfVersionEv")
  //</editor-fold>
  public /*uint*/int getDwarfVersion() /*const*/ {
    ConstantAsMetadata /*P*/ Val = cast_or_null_ConstantAsMetadata(getModuleFlag(new StringRef(/*KEEP_STR*/"Dwarf Version")));
    if (!(Val != null)) {
      return 0;
    }
    return $ulong2uint(cast_ConstantInt(Val.getValue()).getZExtValue());
  }


  
  /// \brief Returns the CodeView Version by checking module flags.
  /// Returns zero if not present in module.
  
  /// \brief Returns the CodeView Version by checking module flags.
  /// Returns zero if not present in module.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getCodeViewFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 473,
   FQN="llvm::Module::getCodeViewFlag", NM="_ZNK4llvm6Module15getCodeViewFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module15getCodeViewFlagEv")
  //</editor-fold>
  public /*uint*/int getCodeViewFlag() /*const*/ {
    ConstantAsMetadata /*P*/ Val = cast_or_null_ConstantAsMetadata(getModuleFlag(new StringRef(/*KEEP_STR*/"CodeView")));
    if (!(Val != null)) {
      return 0;
    }
    return $ulong2uint(cast_ConstantInt(Val.getValue()).getZExtValue());
  }


  
  /// @}
  /// @name Utility functions for querying and setting PIC level
  /// @{
  
  /// \brief Returns the PIC level (small or large model)
  
  /// @}
  /// @name Utility functions for querying and setting PIC level
  /// @{
  
  /// \brief Returns the PIC level (small or large model)
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getPICLevel">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 486,
   FQN="llvm::Module::getPICLevel", NM="_ZNK4llvm6Module11getPICLevelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module11getPICLevelEv")
  //</editor-fold>
  public PICLevel.Level getPICLevel() /*const*/ {
    ConstantAsMetadata /*P*/ Val = cast_or_null_ConstantAsMetadata(getModuleFlag(new StringRef(/*KEEP_STR*/"PIC Level")));
    if (!(Val != null)) {
      return PICLevel.Level.NotPIC;
    }
    
    return /*static_cast*/PICLevel.Level.valueOf($ulong2uint(cast_ConstantInt(Val.getValue()).getZExtValue()));
  }


  
  /// \brief Set the PIC level (small or large model)
  
  /// \brief Set the PIC level (small or large model)
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setPICLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 496,
   FQN="llvm::Module::setPICLevel", NM="_ZN4llvm6Module11setPICLevelENS_8PICLevel5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module11setPICLevelENS_8PICLevel5LevelE")
  //</editor-fold>
  public void setPICLevel(PICLevel.Level PL) {
    addModuleFlag(ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"PIC Level"), PL.getValue());
  }


  /// @}
  
  /// @}
  /// @name Utility functions for querying and setting PIE level
  /// @{
  
  /// \brief Returns the PIE level (small or large model)
  /// @}
  
  /// @}
  /// @name Utility functions for querying and setting PIE level
  /// @{
  
  /// \brief Returns the PIE level (small or large model)
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getPIELevel">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 500,
   FQN="llvm::Module::getPIELevel", NM="_ZNK4llvm6Module11getPIELevelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZNK4llvm6Module11getPIELevelEv")
  //</editor-fold>
  public PIELevel.Level getPIELevel() /*const*/ {
    ConstantAsMetadata /*P*/ Val = cast_or_null_ConstantAsMetadata(getModuleFlag(new StringRef(/*KEEP_STR*/"PIE Level")));
    if (!(Val != null)) {
      return PIELevel.Level.Default;
    }
    
    return /*static_cast*/PIELevel.Level.valueOf($ulong2uint(cast_ConstantInt(Val.getValue()).getZExtValue()));
  }


  
  /// \brief Set the PIE level (small or large model)
  
  /// \brief Set the PIE level (small or large model)
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setPIELevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 510,
   FQN="llvm::Module::setPIELevel", NM="_ZN4llvm6Module11setPIELevelENS_8PIELevel5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module11setPIELevelENS_8PIELevel5LevelE")
  //</editor-fold>
  public void setPIELevel(PIELevel.Level PL) {
    addModuleFlag(ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"PIE Level"), PL.getValue());
  }


  /// @}
  
  /// @name Utility functions for querying and setting PGO summary
  /// @{
  
  /// \brief Attach profile summary metadata to this module.
  /// @}
  
  /// @name Utility functions for querying and setting PGO summary
  /// @{
  
  /// \brief Attach profile summary metadata to this module.
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::setProfileSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 514,
   FQN="llvm::Module::setProfileSummary", NM="_ZN4llvm6Module17setProfileSummaryEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module17setProfileSummaryEPNS_8MetadataE")
  //</editor-fold>
  public void setProfileSummary(Metadata /*P*/ M) {
    addModuleFlag(ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"ProfileSummary"), M);
  }


  
  /// \brief Returns profile summary metadata
  
  /// \brief Returns profile summary metadata
  //<editor-fold defaultstate="collapsed" desc="llvm::Module::getProfileSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 518,
   FQN="llvm::Module::getProfileSummary", NM="_ZN4llvm6Module17getProfileSummaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6Module17getProfileSummaryEv")
  //</editor-fold>
  public Metadata /*P*/ getProfileSummary() {
    return getModuleFlag(new StringRef(/*KEEP_STR*/"ProfileSummary"));
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<Function> iterator() {return new JavaIterator(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Context=" + "[LLVMContext]" // NOI18N
              + ", GlobalList=" + NativeTrace.getIdentityStr(GlobalList) // NOI18N
              + ", FunctionList=" + NativeTrace.getIdentityStr(FunctionList) // NOI18N
              + ", AliasList=" + NativeTrace.getIdentityStr(AliasList) // NOI18N
              + ", IFuncList=" + NativeTrace.getIdentityStr(IFuncList) // NOI18N
              + ", NamedMDList=" + NativeTrace.getIdentityStr(NamedMDList) // NOI18N
              + ", GlobalScopeAsm=" + GlobalScopeAsm // NOI18N
              + ", ValSymTab=" + NativeTrace.getIdentityStr(ValSymTab) // NOI18N
              + ", ComdatSymTab=" + NativeTrace.getIdentityStr(ComdatSymTab) // NOI18N
              + ", Materializer=" + Materializer // NOI18N
              + ", ModuleID=" + ModuleID // NOI18N
              + ", SourceFileName=" + SourceFileName // NOI18N
              + ", TargetTriple=" + TargetTriple // NOI18N
              + ", NamedMDSymTab=" + NativeTrace.getIdentityStr(NamedMDSymTab) // NOI18N
              + ", DL=" + DL; // NOI18N
  }
/// @}
}
